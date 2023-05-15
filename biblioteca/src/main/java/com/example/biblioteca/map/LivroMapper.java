package com.example.biblioteca.map;

import com.example.biblioteca.dto.request.CadastroLivro;
import com.example.biblioteca.dto.response.LivroDet;
import com.example.biblioteca.model.Autor;
import com.example.biblioteca.model.Livro;

import java.util.Optional;

public interface LivroMapper {
    static Livro toLivro(CadastroLivro cadastroLivro, Optional<Autor> entidadesId) {
        return Livro.builder()
                .nome(cadastroLivro.getNome())
                .isbn(cadastroLivro.getIsbn())
                .autor(entidadesId.get())
                .dataPublicacao(cadastroLivro.getDataPublicacao())
                .build();
    }

    static LivroDet toLivroDet(Livro livro){
        return LivroDet
                .builder()
                .nome(livro.getNome())
                .statusAluguel(livro.isStatusAluguel())
                .autor(livro.getAutor())
                .build();
    }
}
