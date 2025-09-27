package com.gabriel.biblioteca.controller;


import com.gabriel.biblioteca.entity.Livros;
import com.gabriel.biblioteca.entity.Usuario;
import com.gabriel.biblioteca.repository.LivroRepository;
import com.gabriel.biblioteca.service.LivroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping ("/livros")
public class LivroController {
    private final LivroService livroService;

    public LivroController(LivroService livroService){
        this.livroService = livroService;
    }

    @GetMapping
    public List<Livros> listarTodosLivros(){
        return livroService.buscarTodosLivros();
    }


    @PostMapping
    public Livros criarLivro(@RequestBody Livros livro){
        return livroService.salvar(livro);

    }

    @PutMapping("/{id}")
    public Livros atualizarLivro(@PathVariable Long id, @RequestBody Livros livroAtualizado) {
        // Buscar livro existente
        Livros livroExistente = livroService.buscarLivros(id)
                .orElseThrow(() -> new RuntimeException("Livro não encontrado"));

        // Atualizar campos
        livroExistente.setTitulo(livroAtualizado.getTitulo());
        livroExistente.setAutor(livroAtualizado.getAutor());
        livroExistente.setAno(livroAtualizado.getAno());
        livroExistente.setQuantidade(livroAtualizado.getQuantidade());

        // Salvar no banco
        return livroService.salvar(livroExistente);
    }

    @DeleteMapping ("/{id}")
    public void deletaLivro(@PathVariable Long id){
        livroService.deletarLivro(id);

}
}
