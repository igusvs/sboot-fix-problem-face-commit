package com.fakecommit.demo;

import com.fakecommit.demo.repository.entity.ProdutoEntity;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.math.BigDecimal;

public class ProdutoDomain {

    private Long idProduto;
    private String nomeProduto;
    private BigDecimal valorProduto;
    private Long quantidade;


    public ProdutoEntity toEntity(){

        final var entity = new ProdutoEntity();
        entity.setIdProduto(this.getIdProduto());
        entity.setNomeProduto(this.getNomeProduto());
        entity.setQuantidade(this.getQuantidade());
        entity.setValorProduto(this.getValorProduto());

        return entity;

    }


    public BigDecimal getValorProduto() {
        return valorProduto;
    }

    public void setValorProduto(BigDecimal valorProduto) {
        this.valorProduto = valorProduto;
    }

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public Long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Long quantidade) {
        this.quantidade = quantidade;
    }
}
