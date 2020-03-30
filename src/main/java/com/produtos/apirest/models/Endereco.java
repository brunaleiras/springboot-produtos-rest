package com.produtos.apirest.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "TB_ENDERECO")
public class Endereco {

    @Id
    @GeneratedValue(generator = "UUID")

    private UUID id;

    private String endereco_principal;

    private String endereco_de_entrega;

    private String endereço_opcional;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getEndereco_principal() {
        return endereco_principal;
    }

    public void setEndereco_principal(String endereco_principal) {
        this.endereco_principal = endereco_principal;
    }

    public String getEndereco_de_entrega() {
        return endereco_de_entrega;
    }

    public void setEndereco_de_entrega(String endereco_de_entrega) {
        this.endereco_de_entrega = endereco_de_entrega;
    }

    public String getEndereço_opcional() {
        return endereço_opcional;
    }

    public void setEndereço_opcional(String endereço_opcional) {
        this.endereço_opcional = endereço_opcional;
    }


}
