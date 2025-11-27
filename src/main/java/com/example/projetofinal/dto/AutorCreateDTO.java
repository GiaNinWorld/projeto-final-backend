package com.example.projetofinal.dto;

import jakarta.validation.constraints.NotBlank;

public class AutorCreateDTO {

    @NotBlank(message = "É necessário informar o nome do autor")
    private String nome;

    private String nacionalidade;

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