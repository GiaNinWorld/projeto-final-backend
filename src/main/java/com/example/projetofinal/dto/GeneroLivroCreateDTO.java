package com.example.projetofinal.dto;

import jakarta.validation.constraints.NotBlank;

public class GeneroLivroCreateDTO {

    @NotBlank(message = "É necessário informar o nome do gênero do livro")
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}