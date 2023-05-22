package com.example.biblioteca.service.aluguel;

import com.example.biblioteca.dto.request.CadastroAluguel;
import com.example.biblioteca.model.Aluguel;
import com.example.biblioteca.model.Autor;
import com.example.biblioteca.model.Livro;
import com.example.biblioteca.model.Locatario;
import com.example.biblioteca.repository.AluguelRepository;
import com.example.biblioteca.repository.LivroRepository;
import com.example.biblioteca.repository.LocatarioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AluguelServiceTest {
    @InjectMocks
    private AluguelService aluguelService;
    @Mock
    private AluguelRepository aluguelRepository;
    @Mock
    private LocatarioRepository locatarioRepository;
    @Mock
    private LivroRepository livroRepository;
    private Aluguel aluguel;
    private Livro livro;
    private Autor autor;
    private Locatario locatario;

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

        locatario = Locatario.builder()
                .id(1L)
                .nome("Guilherme")
                .sexo("Masculino")
                .telefone("984236496")
                .email("gui.almaciel@gmail.com")
                .dataNascimento(LocalDate.of(2000,12,28))
                .cpf("60000730033")
                .build();

        aluguel = Aluguel.builder()
                .id(1L)
                .dataRetirada(LocalDateTime.now())
                .dataDevolucao(LocalDateTime.now().withHour(22))
                .livros(List.of(livro))
                .locatario(locatario)
                .build();
    }

    @Test
    void salvarAluguelComSucesso(){
        when(livroRepository.findAllById(List.of(1L))).thenReturn(List.of(livro));
        when(locatarioRepository.findById(1L)).thenReturn(Optional.of(locatario));

        aluguelService.salvarAluguel(CadastroAluguel.builder()
                .idLivros(List.of(1L))
                .idLocatario(1L)
                .build());
    }

    @Test
    void buscarAluguelPorIdComSucesso(){
        when(aluguelRepository.findById(1L)).thenReturn(Optional.of(aluguel));

        aluguelService.buscarAluguelPorId(1L);
        verify(aluguelRepository, times(1)).findById(1L);
    }

    @Test
    void buscarAluguelPorNomeDeLocadorComSucesso(){
        when(aluguelRepository.findAluguelByLocatario(anyString())).thenReturn(Optional.of(aluguel));

        aluguelService.buscarAluguelPorNomeDeLocador("Guilherme");
        verify(aluguelRepository, times(1)).findAluguelByLocatario("Guilherme");
    }

    @Test
    void excluirAluguelPorIdComSucesso(){
        when(aluguelRepository.findById(1L)).thenReturn(Optional.of(aluguel));

        aluguelService.excluirAluguelPorId(1L);
        verify(aluguelRepository, times(1)).findById(1L);
    }


}
