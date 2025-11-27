package com.example.projetofinal.dto;

import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public class GeneroLivroDTO {

    private UUID id;

    @NotBlank(message = "É necessário informar o nome do gênero do livro")
    private String nome;

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
}
