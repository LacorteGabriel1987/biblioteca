package com.gabriel.biblioteca.exception;

public class LivroNotFoundException extends RuntimeException {
    public LivroNotFoundException(Long id) {

      super("Usuario com Id" + id + "Não encontrado");
    }
}
