package com.gabriel.biblioteca.service;

import com.gabriel.biblioteca.entity.Usuario;
import com.gabriel.biblioteca.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    //@Get
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }
    //@Post
    public Usuario salvarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
    //@Put
    public Usuario atualizarUsuario(Long id, Usuario usuario) {
        return usuarioRepository.findById(id)

                    .map(u -> {
                        u.setNome(usuario.getNome());
                        u.setIdade(usuario.getIdade());
                        return usuarioRepository.save(u);

                    })
                    .orElse(null);
    }

    public void deletarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }
}

