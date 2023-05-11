package com.example.biblioteca.service.autor;

import com.example.biblioteca.model.Autor;
import com.example.biblioteca.repository.AutorRepository;
import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class AutorService implements AutorServiceInterface{
    private final AutorRepository autorRepository;

    public AutorService(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    @Transactional
    @Override
    public ResponseEntity<Autor> save(Autor autor) {
        Autor autorSalvo = autorRepository.save(autor);
        return ResponseEntity.ok(autorSalvo);
    }

    @Override
    public ResponseEntity<Autor> get(String nome) {
        return null;
    }
}
