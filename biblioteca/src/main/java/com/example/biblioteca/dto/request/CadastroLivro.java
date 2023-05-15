package com.example.biblioteca.dto.request;

import com.example.biblioteca.model.Autor;
import lombok.Builder;
import lombok.Getter;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Builder
public class CadastroLivro {

    private String nome;
    //@ISBN(message = "ISBN invalido")
    private String isbn;
    private LocalDate dataPublicacao;
    private Long autorId;
}
