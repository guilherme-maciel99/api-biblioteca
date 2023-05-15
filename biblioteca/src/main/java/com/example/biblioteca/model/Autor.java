package com.example.biblioteca.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.Year;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    private String sexo;

    @Column(nullable = false)
    private int anoNascimento;

    @Column(nullable = false)
    private String cpf;

    @OneToMany(mappedBy="autor")
    private List<Livro> livros;
}
