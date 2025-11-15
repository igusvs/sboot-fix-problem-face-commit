package com.fakecommit.demo.publish;

import com.amazonaws.services.sqs.AmazonSQSAsync;
import com.amazonaws.services.sqs.model.SendMessageBatchRequest;
import com.amazonaws.services.sqs.model.SendMessageBatchRequestEntry;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import com.fakecommit.demo.QueueMessage;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class QueuePublish {

    private final AmazonSQSAsync queue;

    public QueuePublish(AmazonSQSAsync queue) {
        this.queue = queue;
    }

    public void publishQueue(List<QueueMessage> messages){


        try {
            System.out.println("PUBLISH QUEUE MESSAGE");
            List<SendMessageBatchRequestEntry> entries = new ArrayList<>();


            messages.forEach(item -> {
                final var entry = new SendMessageBatchRequestEntry();
                entry.setMessageBody(JsonConverter.toJson(item));
                entry.setId(UUID.randomUUID().toString());
                entries.add(entry);
            });

            SendMessageBatchRequest batchRequest = new SendMessageBatchRequest();
            batchRequest.setQueueUrl("http://localhost:4566/000000000000/queue-teste");
            batchRequest.setEntries(entries);


            queue.sendMessageBatch(batchRequest);

        }catch (Exception e){
            throw e;
        }
    }

    public void publishThrottling(QueueMessage queueMessage){

            SendMessageRequest request = new SendMessageRequest();
            request.setQueueUrl("http://localhost:4566/000000000000/queue-throttling");
            request.setMessageBody(JsonConverter.toJson(queueMessage));
            request.setDelaySeconds(60);

            queue.sendMessage(request);
    }
}
