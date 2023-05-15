package com.example.biblioteca.controller;

import com.example.biblioteca.dto.request.CadastroAluguel;
import com.example.biblioteca.dto.response.AluguelDet;
import com.example.biblioteca.model.Aluguel;
import com.example.biblioteca.service.aluguel.AluguelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/aluguel")
public class AluguelController {
    private final AluguelService aluguelService;

    @Autowired
    public AluguelController(AluguelService aluguelService) {
        this.aluguelService = aluguelService;
    }

    @PostMapping
    public ResponseEntity<Aluguel> salvarAluguel(@RequestBody CadastroAluguel cadastroAluguel){
        return new ResponseEntity<>(aluguelService.salvarAluguel(cadastroAluguel), HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<AluguelDet> buscarAluguelPorId(@PathVariable Long id){
        return new ResponseEntity<>(aluguelService.buscarAluguelPorId(id), HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<AluguelDet> buscarAluguelPorNomeDeLocador(@RequestParam String nome){
        return new ResponseEntity<>(aluguelService.buscarAluguelPorNomeDeLocador(nome), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> excluirAluguelPorId(@PathVariable Long id){
        aluguelService.excluirAluguelPorId(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
