package com.example.biblioteca.service.autor;

import com.example.biblioteca.dto.request.CadastroAutor;
import com.example.biblioteca.model.Autor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;

public interface AutorServiceInterface {

    Autor salvarAutor(CadastroAutor autorCadastrado);
    Autor buscarAutorPorNome(String nome);
    void excluirAutorPorId (Long id);
}
