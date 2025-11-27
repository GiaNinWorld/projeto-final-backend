package com.example.projetofinal.service;

import com.example.projetofinal.dto.AutorCreateDTO;
import com.example.projetofinal.dto.AutorDTO;
import com.example.projetofinal.exception.NotFoundException;
import com.example.projetofinal.model.Autor;
import com.example.projetofinal.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    public Page<AutorDTO> findAll(Pageable pageable) {
        Page<Autor> page = autorRepository.findAll(pageable);
        return new PageImpl<>(page.getContent().stream().map(this::toDTO).toList(), pageable, page.getTotalElements());
    }

    public AutorDTO findById(UUID id) {
        return autorRepository.findById(id)
                .map(this::toDTO)
                .orElseThrow(() -> new NotFoundException("Não foi possível encontrar o autor com o ID informado"));
    }

    public AutorDTO create(AutorCreateDTO dto) {
        Autor autor = new Autor();
        autor.setNome(dto.getNome());
        autor.setNacionalidade(dto.getNacionalidade());

        autor = autorRepository.save(autor);
        return toDTO(autor);
    }

    public AutorDTO update(UUID id, AutorDTO dto) {
        Autor autor = autorRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Não foi possível encontrar o autor com o ID informado"));

        autor.setNome(dto.getNome());
        autor.setNacionalidade(dto.getNacionalidade());

        autor = autorRepository.save(autor);
        return toDTO(autor);
    }

    public void delete(UUID id) {
        Autor autor = autorRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Não foi possível encontrar o autor com o ID informado"));

        autorRepository.delete(autor);
    }

    private AutorDTO toDTO(Autor autor) {
        AutorDTO dto = new AutorDTO();
        dto.setId(autor.getId());
        dto.setNome(autor.getNome());
        dto.setNacionalidade(autor.getNacionalidade());
        return dto;
    }
}
