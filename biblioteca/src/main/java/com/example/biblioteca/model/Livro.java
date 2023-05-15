package com.example.biblioteca.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@Builder
@NoArgsConstructor
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String isbn;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataPublicacao;
    private boolean statusAluguel;
    @ManyToOne
    @JoinColumn(name="autor_id", nullable=false)
    private Autor autor;

    public Livro(Long id, String nome, String isbn, LocalDate dataPublicacao, boolean statusAluguel, Autor autor) {
        this.id = id;
        this.nome = nome;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
        this.statusAluguel = false;
        this.autor = autor;
    }
}
