package com.example.projetofinal.repository;

import com.example.projetofinal.model.Livro;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LivroRepository extends JpaRepository<Livro, UUID> {

    Page<Livro> findByTituloContainingIgnoreCase(String titulo, Pageable pageable);
}