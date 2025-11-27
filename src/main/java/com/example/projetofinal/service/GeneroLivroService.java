package com.example.projetofinal.service;

import com.example.projetofinal.dto.GeneroLivroCreateDTO;
import com.example.projetofinal.dto.GeneroLivroDTO;
import com.example.projetofinal.exception.NotFoundException;
import com.example.projetofinal.model.GeneroLivro;
import com.example.projetofinal.repository.GeneroLivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class GeneroLivroService {

    @Autowired
    private GeneroLivroRepository generoLivroRepository;

    public Page<GeneroLivroDTO> findAll(Pageable pageable) {
        Page<GeneroLivro> page = generoLivroRepository.findAll(pageable);
        return new PageImpl<>(page.getContent().stream().map(this::toDTO).toList(), pageable, page.getTotalElements());
    }

    public Page<GeneroLivroDTO> findByNome(String nome, Pageable pageable) {
        Page<GeneroLivro> page = generoLivroRepository.findByNomeContainingIgnoreCase(nome, pageable);
        return new PageImpl<>(page.getContent().stream().map(this::toDTO).toList(), pageable, page.getTotalElements());
    }

    public GeneroLivroDTO findById(UUID id) {
        return generoLivroRepository.findById(id)
                .map(this::toDTO)
                .orElseThrow(() -> new NotFoundException("Não foi possível encontrar o gênero do livro com o ID informado"));
    }

    public GeneroLivroDTO create(GeneroLivroCreateDTO dto) {
        GeneroLivro genero = new GeneroLivro();
        genero.setNome(dto.getNome());

        genero = generoLivroRepository.save(genero);
        return toDTO(genero);
    }

    public GeneroLivroDTO update(UUID id, GeneroLivroDTO dto) {
        GeneroLivro genero = generoLivroRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Não foi possível encontrar o gênero do livro com o ID informado"));

        genero.setNome(dto.getNome());

        genero = generoLivroRepository.save(genero);
        return toDTO(genero);
    }

    public void delete(UUID id) {
        GeneroLivro genero = generoLivroRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Não foi possível encontrar o gênero do livro com o ID informado"));

        generoLivroRepository.delete(genero);
    }

    private GeneroLivroDTO toDTO(GeneroLivro genero) {
        GeneroLivroDTO dto = new GeneroLivroDTO();
        dto.setId(genero.getId());
        dto.setNome(genero.getNome());
        return dto;
    }
}
