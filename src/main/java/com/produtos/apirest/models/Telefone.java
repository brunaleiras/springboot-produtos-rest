package com.produtos.apirest.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "TB_TELEFONE")
public class Telefone {

    @Id
    @GeneratedValue(generator = "UUID")

    private UUID id;

    private String telefone_residencial;

    private String telefone_celular;

    private String telefone_opcional;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTelefone_residencial() {
        return telefone_residencial;
    }

    public void setTelefone_residencial(String telefone_residencial) {
        this.telefone_residencial = telefone_residencial;
    }

    public String getTelefone_celular() {
        return telefone_celular;
    }

    public void setTelefone_celular(String telefone_celular) {
        this.telefone_celular = telefone_celular;
    }

    public String getTelefone_opcional() {
        return telefone_opcional;
    }

    public void setTelefone_opcional(String telefone_opcional) {
        this.telefone_opcional = telefone_opcional;
    }


}
