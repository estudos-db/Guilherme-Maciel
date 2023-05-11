package com.example.biblioteca.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Data
@Entity
@Table(name = "livro")
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String dataPublicacao;
}
