package com.gabriel.biblioteca.service;

import com.gabriel.biblioteca.entity.Livros;
import com.gabriel.biblioteca.entity.Usuario;
import com.gabriel.biblioteca.exception.LivroNotFoundException;
import com.gabriel.biblioteca.repository.LivroRepository;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    private final LivroRepository livroRepository;

    public LivroService (LivroRepository livroRepository){
        this.livroRepository = livroRepository;

    }
    //Listar todos livros
    public List<Livros> buscarTodosLivros (){
        return livroRepository.findAll();
    }


    //Buscar por id

    public Optional<Livros> buscarLivros(Long id){
        return livroRepository.findById(id);
    }

    //Criar ou atualizar
    public Livros salvar(Livros livro){
        return livroRepository.save(livro);
    }
    //Deletar livro por id sempre usa void
    public void deletarLivro(Long id){
        livroRepository.deleteById(id);
    }
}
