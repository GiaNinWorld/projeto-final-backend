package com.example.projetofinal.dto;

import java.util.UUID;

public class LivroDTO {

    private UUID id;
    private String titulo;
    private Integer anoPublicacao;
    private UUID autorId;
    private UUID generoId;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

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
