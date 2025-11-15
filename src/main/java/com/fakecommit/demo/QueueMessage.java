package com.fakecommit.demo;

import java.util.List;

public class QueueMessage {

    private String produto;
    private String nomeProduto;

    public QueueMessage() {

    }

    public List<QueueMessage> buildFakeListMessage(){

        final var queueMessage = new QueueMessage();
        queueMessage.nomeProduto = "teste";
        queueMessage.produto = "produto teste";

        return List.of(queueMessage);
    }


}
