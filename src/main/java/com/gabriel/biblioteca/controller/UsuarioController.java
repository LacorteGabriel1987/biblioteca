package com.gabriel.biblioteca.controller;


import com.gabriel.biblioteca.entity.Usuario;
import com.gabriel.biblioteca.repository.UsuarioRepository;
import com.gabriel.biblioteca.service.UsuarioService;
import jakarta.persistence.Id;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public List<Usuario> listarTodos() {
        return usuarioService.listarUsuarios();
    }

    @PostMapping //Criar usuario
    public Usuario criarUsuario(@RequestBody Usuario usuario){
        return usuarioService.salvarUsuario(usuario);
    }

    @PutMapping ("/{id}")
    public Usuario atualizarUsuario(@RequestBody Usuario usuario, @PathVariable Long id){
        return usuarioService.atualizarUsuario(id,usuario);
    }

    @DeleteMapping("/{id}")
    public void deletarUsuario (@PathVariable Long id){
        usuarioService.deletarUsuario(id);
    }

}
