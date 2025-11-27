package com.example.projetofinal.controller;

import com.example.projetofinal.dto.GeneroLivroCreateDTO;
import com.example.projetofinal.dto.GeneroLivroDTO;
import com.example.projetofinal.service.GeneroLivroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/generos-livro")
public class GeneroLivroController {

    @Autowired
    private GeneroLivroService generoLivroService;

    @GetMapping
    public Page<GeneroLivroDTO> findAll(@RequestParam(required = false) String nome,
                                        @RequestParam(defaultValue = "0") int page,
                                        @RequestParam(defaultValue = "10") int size,
                                        @RequestParam(defaultValue = "nome") String sort) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sort));

        if (nome != null && !nome.isBlank()) {
            return generoLivroService.findByNome(nome, pageable);
        }

        return generoLivroService.findAll(pageable);
    }

    @GetMapping("/{id}")
    public GeneroLivroDTO findById(@PathVariable UUID id) {
        return generoLivroService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public GeneroLivroDTO create(@RequestBody @Valid GeneroLivroCreateDTO dto) {
        return generoLivroService.create(dto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public GeneroLivroDTO update(@PathVariable UUID id, @RequestBody @Valid GeneroLivroDTO dto) {
        return generoLivroService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id) {
        generoLivroService.delete(id);
    }
}
