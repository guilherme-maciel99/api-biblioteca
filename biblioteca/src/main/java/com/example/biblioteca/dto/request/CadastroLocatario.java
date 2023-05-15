package com.example.biblioteca.dto.request;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class CadastroLocatario {
    private String nome;
    private String sexo;
    private String telefone;
    @Column(unique = true)
    private String email;
    private LocalDate dataNascimento;
    @Column(unique = true)
    private String cpf;
}