package com.example.biblioteca.service.locatario;

import com.example.biblioteca.dto.request.CadastroLocatario;
import com.example.biblioteca.model.Autor;
import com.example.biblioteca.model.Livro;
import com.example.biblioteca.model.Locatario;
import com.example.biblioteca.repository.AluguelRepository;
import com.example.biblioteca.repository.LocatarioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class LocatarioServiceTest {
    @InjectMocks
    private LocatarioService locatarioService;
    @Mock
    private LocatarioRepository locatarioRepository;
    @Mock
    private AluguelRepository aluguelRepository;
    private Locatario locatario;

    @BeforeEach
    void init(){
        iniciarAtributos();
    }
    void iniciarAtributos(){
        locatario = Locatario.builder()
                .id(1L)
                .nome("Guilherme")
                .sexo("Masculino")
                .telefone("984236496")
                .email("gui.almaciel@gmail.com")
                .dataNascimento(LocalDate.of(2000,12,28))
                .cpf("60000730033")
                .build();
    }

    @Test
    void salvarLocatarioComSucesso(){
        when(locatarioRepository.save(any(Locatario.class))).thenReturn(locatario);

        locatarioService.salvar(CadastroLocatario.builder().nome("Guilherme")
                .sexo("Masculino")
                .telefone("984236496")
                .email("gui.almaciel@gmail.com")
                .dataNascimento(LocalDate.of(2000,12,28))
                .cpf("60000730033")
                .build());
    }

    @Test
    void buscarLocatarioPorIdComSucesso(){
        when(locatarioRepository.findById(anyLong())).thenReturn(Optional.of(locatario));

        locatarioService.buscarLocatarioPorId(1L);

        verify(locatarioRepository, times(1)).findById(1L);
    }

    @Test
    void buscarLocatarioPeloNomeComSucesso(){
        when(locatarioRepository.findLocatarioByNome(anyString())).thenReturn(Optional.of(locatario));

        locatarioService.buscarLocatarioPeloNome("Guilherme");

        verify(locatarioRepository, times(1)).findLocatarioByNome("Guilherme");
    }

    @Test
    void deletarLocatarioComSucesso(){
        when(locatarioRepository.findById(anyLong())).thenReturn(Optional.of(locatario));
        when(aluguelRepository.findAluguelByLocatario(anyString())).thenReturn(Optional.empty());

        locatarioService.deletar(1L);

        verify(locatarioRepository, times(1)).findById(1L);
    }

}