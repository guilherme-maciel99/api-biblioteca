package com.example.biblioteca.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.time.Year;

@Getter
@Builder
public class AutorDet {
    private String nome;
    private String sexo;
    private int anoNascimento;
}