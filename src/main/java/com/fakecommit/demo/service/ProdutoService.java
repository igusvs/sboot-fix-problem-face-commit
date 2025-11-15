package com.fakecommit.demo.service;

import com.fakecommit.demo.ProdutoDomain;
import com.fakecommit.demo.QueueMessage;
import com.fakecommit.demo.publish.QueuePublish;
import com.fakecommit.demo.repository.entity.ProdutoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;
    private final QueuePublish queuePublish;

    public ProdutoService(ProdutoRepository produtoRepository, QueuePublish queuePublish) {
        this.produtoRepository = produtoRepository;
        this.queuePublish = queuePublish;
    }


    @Transactional
    public void saveProduto(ProdutoDomain produto){

        produtoRepository.save(produto.toEntity());
        queuePublish.publishQueue(new QueueMessage().buildFakeListMessage());

    }
}
