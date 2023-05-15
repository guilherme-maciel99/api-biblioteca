package com.example.biblioteca.dto.response;

import com.example.biblioteca.model.Autor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class LivroDet {
    private String nome;
    private boolean statusAluguel;
    private Autor autor;
}