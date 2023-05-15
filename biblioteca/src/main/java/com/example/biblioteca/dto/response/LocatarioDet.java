package com.example.biblioteca.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class LocatarioDet {
    private String nome;
    private String genero;
    private String telefone;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;
}
