package com.example.biblioteca.service.autor;

import com.example.biblioteca.model.Autor;
import org.springframework.http.ResponseEntity;

public interface AutorServiceInterface {

    ResponseEntity<Autor> save (Autor autor);
    ResponseEntity<Autor> get (String nome);
}
