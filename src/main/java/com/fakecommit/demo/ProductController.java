package com.fakecommit.demo;

import com.fakecommit.demo.service.ProdutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Controller("/")
public class ProductController {

    private final ProdutoService produtoService;

    public ProductController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping("/product")
    public ResponseEntity<Object> produce(@RequestBody ProdutoDomain produtoDomain){

        produtoService.saveProduto(produtoDomain);

        return ResponseEntity.accepted().build();
    }

}
