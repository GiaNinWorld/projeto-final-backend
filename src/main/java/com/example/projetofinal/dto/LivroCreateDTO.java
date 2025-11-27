package com.example.projetofinal.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.UUID;

public class LivroCreateDTO {

    @NotBlank(message = "É necessário informar o título do livro")
    private String titulo;

    @NotNull(message = "É necessário informar o ano de publicação")
    @Positive(message = "O ano de publicação deve ser um valor positivo")
    private Integer anoPublicacao;

    @NotNull(message = "É necessário informar o autor do livro")
    private UUID autorId;

    @NotNull(message = "É necessário informar o gênero do livro")
    private UUID generoId;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(Integer anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public UUID getAutorId() {
        return autorId;
    }

    public void setAutorId(UUID autorId) {
        this.autorId = autorId;
    }

    public UUID getGeneroId() {
        return generoId;
    }

    public void setGeneroId(UUID generoId) {
        this.generoId = generoId;
    }
}
