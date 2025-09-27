package com.gabriel.biblioteca.repository;

import com.gabriel.biblioteca.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
