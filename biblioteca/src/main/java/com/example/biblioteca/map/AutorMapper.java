package com.example.biblioteca.map;

import com.example.biblioteca.dto.request.CadastroAutor;
import com.example.biblioteca.dto.response.AutorDet;
import com.example.biblioteca.model.Autor;

public interface AutorMapper {

    static Autor toAutor(CadastroAutor autorCadastrado){
        return Autor.builder()
                .nome(autorCadastrado.getNome())
                .sexo(autorCadastrado.getSexo())
                .anoNascimento(autorCadastrado.getAnoNascimento())
                .cpf(autorCadastrado.getCpf())
                .build();
    }
    static AutorDet toAutor(Autor autor){
        return AutorDet.builder()
                .nome(autor.getNome())
                .sexo(autor.getSexo())
                .anoNascimento(autor.getAnoNascimento())
                .build();
    }
}