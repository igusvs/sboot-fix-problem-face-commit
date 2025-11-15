package com.fakecommit.demo.repository.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "tb_produto")
public class ProdutoEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduto;

    @Column(name = "nome_produto")
    private String nomeProduto;

    @Column(name = "valor_produto")
    private BigDecimal valorProduto;

    @Column(name = "quantidade")
    private Long quantidade;


    public Long getIdProduto() {
        return idProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public BigDecimal getValorProduto() {
        return valorProduto;
    }

    public Long getQuantidade() {
        return quantidade;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public void setValorProduto(BigDecimal valorProduto) {
        this.valorProduto = valorProduto;
    }

    public void setQuantidade(Long quantidade) {
        this.quantidade = quantidade;
    }
}
