package com.example.projetofinal.service;

import com.example.projetofinal.dto.LivroCreateDTO;
import com.example.projetofinal.dto.LivroDTO;
import com.example.projetofinal.dto.LivroUpdateDTO;
import com.example.projetofinal.exception.NotFoundException;
import com.example.projetofinal.model.Autor;
import com.example.projetofinal.model.GeneroLivro;
import com.example.projetofinal.model.Livro;
import com.example.projetofinal.repository.AutorRepository;
import com.example.projetofinal.repository.GeneroLivroRepository;
import com.example.projetofinal.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private GeneroLivroRepository generoLivroRepository;

    public Page<LivroDTO> findAll(Pageable pageable) {
        Page<Livro> page = livroRepository.findAll(pageable);
        return new PageImpl<>(page.getContent().stream().map(this::toDTO).toList(), pageable, page.getTotalElements());
    }

    public Page<LivroDTO> findByTitulo(String titulo, Pageable pageable) {
        Page<Livro> page = livroRepository.findByTituloContainingIgnoreCase(titulo, pageable);
        return new PageImpl<>(page.getContent().stream().map(this::toDTO).toList(), pageable, page.getTotalElements());
    }

    public LivroDTO findById(UUID id) {
        return livroRepository.findById(id)
                .map(this::toDTO)
                .orElseThrow(() -> new NotFoundException("Não foi possível encontrar o livro com o ID informado"));
    }

    public LivroDTO create(LivroCreateDTO dto) {
        Livro livro = toEntity(dto);
        livro = livroRepository.save(livro);
        return toDTO(livro);
    }

    public LivroDTO update(UUID id, LivroUpdateDTO dto) {
        Livro livro = livroRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Não foi possível encontrar o livro com o ID informado"));

        livro.setTitulo(dto.getTitulo());
        livro.setAnoPublicacao(dto.getAnoPublicacao());

        if (!livro.getAutor().getId().equals(dto.getAutorId())) {
            Autor autor = autorRepository.findById(dto.getAutorId())
                    .orElseThrow(() -> new NotFoundException("Não foi possível encontrar o autor com o ID informado"));
            livro.setAutor(autor);
        }

        if (!livro.getGenero().getId().equals(dto.getGeneroId())) {
            GeneroLivro genero = generoLivroRepository.findById(dto.getGeneroId())
                    .orElseThrow(() -> new NotFoundException("Não foi possível encontrar o gênero do livro com o ID informado"));
            livro.setGenero(genero);
        }

        livro = livroRepository.save(livro);
        return toDTO(livro);
    }

    public void delete(UUID id) {
        Livro livro = livroRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Não foi possível encontrar o livro com o ID informado"));
        livroRepository.delete(livro);
    }

    private LivroDTO toDTO(Livro livro) {
        LivroDTO dto = new LivroDTO();
        dto.setId(livro.getId());
        dto.setTitulo(livro.getTitulo());
        dto.setAnoPublicacao(livro.getAnoPublicacao());
        dto.setAutorId(livro.getAutor().getId());
        dto.setGeneroId(livro.getGenero().getId());
        return dto;
    }

    private Livro toEntity(LivroCreateDTO dto) {
        Livro livro = new Livro();
        livro.setTitulo(dto.getTitulo());
        livro.setAnoPublicacao(dto.getAnoPublicacao());

        Autor autor = autorRepository.findById(dto.getAutorId())
                .orElseThrow(() -> new NotFoundException("Não foi possível encontrar o autor com o ID informado"));
        livro.setAutor(autor);

        GeneroLivro genero = generoLivroRepository.findById(dto.getGeneroId())
                .orElseThrow(() -> new NotFoundException("Não foi possível encontrar o gênero do livro com o ID informado"));
        livro.setGenero(genero);

        return livro;
    }
}
