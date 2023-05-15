package com.example.biblioteca.controller;

import com.example.biblioteca.dto.request.CadastroLivro;
import com.example.biblioteca.dto.response.LivroDet;
import com.example.biblioteca.model.Livro;
import com.example.biblioteca.service.livro.LivroService;
import com.example.biblioteca.service.livro.LivroServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livro")
public class LivroController {
    private final LivroService livroService;

    @Autowired
    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }
    @PostMapping
    public ResponseEntity<Livro> salvarLivro(@RequestBody CadastroLivro cadastroLivro){
        return new ResponseEntity<>(livroService.salvar(cadastroLivro), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<LivroDet>> buscarLivroDisponiveisParaAlugar(){
        return new ResponseEntity<>(livroService.buscarLivrosDisponiveisParaAlugar(), HttpStatus.OK);
    }
    @GetMapping("/alugado")
    public ResponseEntity<List<LivroDet>> buscarLivrosAlugados(){
        return new ResponseEntity<>(livroService.buscarLivrosAlugados(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livro> buscarLivroPorId(@PathVariable Long id){
        return new ResponseEntity<>(livroService.buscarLivroPorId(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deletarLivroPorId(@PathVariable Long id){
        livroService.deletarLivroPorId(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
