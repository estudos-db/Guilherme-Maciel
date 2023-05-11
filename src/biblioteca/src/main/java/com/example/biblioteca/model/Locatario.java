package com.example.biblioteca.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "locatario")
public class Locatario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    private String sexo;

    @Column(nullable = false)
    private String telegone;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String dataNascimento;

    @Column(nullable = false)
    private String cpf;
}
