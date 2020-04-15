package com.produtos.apirest.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

//import lombok.*;

import javax.persistence.*;
@Entity
@Table(name="TB_PRODUTO")
public class Produto implements Serializable{
    private static final long serialVersionUID = 1L;
    //{id:1, nome: 'Teste', quantidade: 1, valor: 9 }
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String nome;
    private BigDecimal quantidade;

    private BigDecimal valor;
    /*
    @ManyToMany(mappedBy = "produtos")
    private List<Compra> compras;


    public List<Compra> getCompras() {
        return compras;
    }

    public void setCompras(List<Compra> compras) {
        this.compras = compras;
    }
    */
    public long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public BigDecimal getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }
    public BigDecimal getValor() {
        return valor;
    }
    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}