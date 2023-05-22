package com.example.biblioteca.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Objects;

@Data
@Entity
@Builder
@NoArgsConstructor
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String isbn;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataPublicacao;
    private boolean statusAluguel;
    @ManyToOne
    @JoinColumn(name="autor_id", nullable=false)
    private Autor autor;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Livro livro)) return false;
        return isStatusAluguel() == livro.isStatusAluguel() && getId().equals(livro.getId()) && getNome().equals(livro.getNome()) && getIsbn().equals(livro.getIsbn()) && getDataPublicacao().equals(livro.getDataPublicacao()) && getAutor().equals(livro.getAutor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNome(), getIsbn(), getDataPublicacao(), isStatusAluguel(), getAutor());
    }

    public Livro(Long id, String nome, String isbn, LocalDate dataPublicacao, boolean statusAluguel, Autor autor) {
        this.id = id;
        this.nome = nome;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
        this.statusAluguel = false;
        this.autor = autor;
    }
}
