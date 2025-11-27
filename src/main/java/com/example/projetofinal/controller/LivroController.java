package com.example.projetofinal.controller;

import com.example.projetofinal.dto.LivroCreateDTO;
import com.example.projetofinal.dto.LivroDTO;
import com.example.projetofinal.dto.LivroUpdateDTO;
import com.example.projetofinal.service.LivroService;
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
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @GetMapping
    public Page<LivroDTO> findAll(@RequestParam(required = false) String titulo,
                                  @RequestParam(defaultValue = "0") int page,
                                  @RequestParam(defaultValue = "10") int size,
                                  @RequestParam(defaultValue = "titulo") String sort) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sort));

        if (titulo != null && !titulo.isBlank()) {
            return livroService.findByTitulo(titulo, pageable);
        }

        return livroService.findAll(pageable);
    }

    @GetMapping("/{id}")
    public LivroDTO findById(@PathVariable UUID id) {
        return livroService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LivroDTO create(@RequestBody @Valid LivroCreateDTO dto) {
        return livroService.create(dto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public LivroDTO update(@PathVariable UUID id, @RequestBody @Valid LivroUpdateDTO dto) {
        return livroService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id) {
        livroService.delete(id);
    }
}
