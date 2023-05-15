package com.example.biblioteca.controller;

import com.example.biblioteca.dto.request.CadastroAutor;
import com.example.biblioteca.model.Autor;
import com.example.biblioteca.service.autor.AutorService;
import com.example.biblioteca.service.autor.AutorServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/autor")
@RestController
public class AutorController {

    private final AutorService autorService;

    @Autowired
    public AutorController(AutorService autorService){
        this.autorService = autorService;
    }

    @PostMapping
    public ResponseEntity<Autor> salvar(@RequestBody CadastroAutor autorCadastrado){
        return new ResponseEntity<>(autorService.salvarAutor(autorCadastrado), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Autor> buscarAutorPorNome(@RequestParam String nome){
        return new ResponseEntity<>(autorService.buscarAutorPorNome(nome), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> excluiAutorPorId(@PathVariable Long id){
        autorService.excluirAutorPorId(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
