package com.example.biblioteca.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;

import java.time.Year;

@Getter
@Builder
public class CadastroAutor {
    @NotBlank

    private String nome;
    private String sexo;
    private int anoNascimento;

    private String cpf;
}