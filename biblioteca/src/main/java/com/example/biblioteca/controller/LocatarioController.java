package com.example.biblioteca.controller;

import com.example.biblioteca.dto.request.CadastroLocatario;
import com.example.biblioteca.model.Locatario;
import com.example.biblioteca.service.locatario.LocatarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/locatario")
public class LocatarioController {

    private final LocatarioService locatarioService;
    @Autowired
    public LocatarioController(LocatarioService locatarioService) {
        this.locatarioService = locatarioService;
    }

    @PostMapping
    public ResponseEntity<Locatario> salvarLocatorio(@RequestBody CadastroLocatario locatarioCadastrado){
        return new ResponseEntity<>(locatarioService.salvar(locatarioCadastrado), HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Locatario> buscarLocatarioPorId(@PathVariable Long id){
        return new ResponseEntity<>(locatarioService.buscarLocatarioPorId(id), HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<Locatario> buscarLocatarioPeloNome(@RequestParam String nome){
        return new ResponseEntity<>(locatarioService.buscarLocatarioPeloNome(nome),HttpStatus.OK);
    }
    /*@PutMapping("/{id}")
    public ResponseEntity<Locatario> editarLocatario(@PathVariable Long id, @RequestBody AtualizarLocatario locatario){
        return new ResponseEntity<>(locatarioService.editar(id, locatario), HttpStatus.OK);
    }*/
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deletarLocatario(@PathVariable Long id){
        locatarioService.deletar(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}