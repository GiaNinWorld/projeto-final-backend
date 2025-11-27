package com.example.projetofinal.dto;

import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public class AutorDTO {

    private UUID id;

    @NotBlank(message = "É necessário informar o nome do autor")
    private String nome;

    private String nacionalidade;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }
}
