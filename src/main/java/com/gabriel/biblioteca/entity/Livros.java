package com.gabriel.biblioteca.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Livros {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String autor;
    private Integer ano;
    private Integer quantidade;

    // RELACIONAMENTO COM USUARIO
    @ManyToOne
    @JoinColumn(name = "usuario_id") // coluna que vai armazenar a FK
    private Usuario usuario;


}
