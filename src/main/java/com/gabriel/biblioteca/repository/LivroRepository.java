package com.gabriel.biblioteca.repository;

import com.gabriel.biblioteca.entity.Livros;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livros, Long> {
}
