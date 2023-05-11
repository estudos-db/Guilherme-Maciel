package com.example.biblioteca.controller;

import com.example.biblioteca.model.Autor;
import com.example.biblioteca.service.autor.AutorServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/autor")
@RestController
public class AutorController {

    private final AutorServiceInterface autorServiceInterface;

    @Autowired
    public AutorController(AutorServiceInterface autorServiceInterface){
        this.autorServiceInterface = autorServiceInterface;
    }

    @GetMapping(path = "/{nome}")
    public ResponseEntity<Autor> buscarAutorPorNome(@PathVariable("nome") String nome){
        return autorServiceInterface.get(nome);
    }

    @PostMapping
    public ResponseEntity<Autor> cadastrarAutor (@RequestBody Autor autor){
        return autorServiceInterface.save(autor);
    }
}
