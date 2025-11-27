package com.example.projetofinal.repository;

import com.example.projetofinal.model.GeneroLivro;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GeneroLivroRepository extends JpaRepository<GeneroLivro, UUID> {

    Page<GeneroLivro> findByNomeContainingIgnoreCase(String nome, Pageable pageable);
}
