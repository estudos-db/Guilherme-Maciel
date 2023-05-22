package com.example.biblioteca.service.livro;

import com.example.biblioteca.dto.request.CadastroLivro;
import com.example.biblioteca.model.Autor;
import com.example.biblioteca.model.Livro;
import com.example.biblioteca.repository.AutorRepository;
import com.example.biblioteca.repository.LivroRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class LivroServiceTest {
    @InjectMocks
    private LivroService livroService;
    @Mock
    private LivroRepository livroRepository;
    @Mock
    private AutorRepository autorRepository;
    private Livro livro;
    private Autor autor;

    @BeforeEach
    void init(){
        iniciarAtributos();
    }
    void iniciarAtributos(){
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
    void salvarLivroComSucesso(){
        when(autorRepository.findAllById(List.of(1L))).thenReturn(List.of(autor));
        when(livroRepository.save(any(Livro.class))).thenReturn(livro);

        livroService.salvar(CadastroLivro.builder()
                .nome("Dom Casmurro")
                .isbn("9788567097688")
                .dataPublicacao(LocalDate.of(1899,12,28))
                .autorId(autor.getId())
                .build());
    }
    @Test
    void buscarLivroPorAutorComSucesso(){
        when(livroRepository.findLivroByNome(anyString())).thenReturn(Optional.of(livro));

        livroService.buscarLivroPorAutor("Machado de Assis");
        verify(livroRepository, times(1)).findLivroByNome("Machado de Assis");
    }

    @Test
    void buscarLivroPorIdComSucesso(){
        when(livroRepository.findById(anyLong())).thenReturn(Optional.of(livro));

        livroService.buscarLivroPorId(1L);
    }

    @Test
    void excluirLivroPorIdComSucesso(){
        when(livroRepository.findById(anyLong())).thenReturn(Optional.of(livro));

        livroService.excluirLivroPorId(1L);
    }

}