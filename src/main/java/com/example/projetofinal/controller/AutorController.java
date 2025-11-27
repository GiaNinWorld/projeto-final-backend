package com.example.projetofinal.controller;

import com.example.projetofinal.dto.AutorCreateDTO;
import com.example.projetofinal.dto.AutorDTO;
import com.example.projetofinal.service.AutorService;
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
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    private AutorService autorService;

    @GetMapping
    public Page<AutorDTO> findAll(@RequestParam(defaultValue = "0") int page,
                                  @RequestParam(defaultValue = "10") int size,
                                  @RequestParam(defaultValue = "nome") String sort) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sort));
        return autorService.findAll(pageable);
    }

    @GetMapping("/{id}")
    public AutorDTO findById(@PathVariable UUID id) {
        return autorService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AutorDTO create(@RequestBody @Valid AutorCreateDTO dto) {
        return autorService.create(dto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public AutorDTO update(@PathVariable UUID id, @RequestBody @Valid AutorDTO dto) {
        return autorService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id) {
        autorService.delete(id);
    }
}
