package com.example.biblioteca.service.autor;

import com.example.biblioteca.dto.request.CadastroAutor;
import com.example.biblioteca.model.Autor;
import com.example.biblioteca.model.Livro;
import com.example.biblioteca.repository.AutorRepository;
import com.example.biblioteca.repository.LivroRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)

class AutorServiceTest {
    @InjectMocks
    private AutorService autorService;
    @Mock
    private AutorRepository autorRepository;
    @Mock
    private LivroRepository livroRepository;
    private Autor autor;
    private Livro livro;

    @BeforeEach
    void init(){
        iniciarAtributos();
    }

    void iniciarAtributos() {
            autor = Autor.builder()
                    .id(1L)
                    .nome("Machado de Assis")
                    .sexo("Masculino")
                    .anoNascimento(1839)
                    .cpf("11111111")
                    .build();
            livro = Livro.builder()
                    .id(1L)
                    .nome("Dom Casmurro")
                    .isbn("9788567097688")
                    .dataPublicacao(LocalDate.of(1899,12,28))
                    .statusAluguel(false)
                    .autor(autor)
                    .build();
    }

    @Test
    void salvarAutorComSucesso() {
        when(autorRepository.save(any(Autor.class))).thenReturn(autor);

        Autor autorSalvo = autorService.salvarAutor(CadastroAutor.builder()
                .nome("Machado de Assis")
                .sexo("Masculino")
                .anoNascimento(1839)
                .cpf("11111111")
                .build());

        assertNotNull(autorSalvo);
    }

    @Test
    void buscarAutorPorNomeComSucesso() {
        when(autorRepository.findByNome("Machado de Assis")).thenReturn(Optional.of(autor));

        Autor autorEncontrado = autorService.buscarAutorPorNome("Machado de Assis");

        Assertions.assertEquals(autorEncontrado.getNome(), autor.getNome());
    }

    @Test
    void excluirAutorPorIdComSucesso() {
        when(autorRepository.findById(any())).thenReturn(Optional.of(autor));

        autorService.excluirAutorPorId(1L);

        verify(autorRepository,times(1)).findById(1L);
    }
}