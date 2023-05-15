package com.example.biblioteca.service.livro;

import com.example.biblioteca.dto.request.CadastroLivro;
import com.example.biblioteca.dto.response.LivroDet;
import com.example.biblioteca.model.Livro;

import java.util.List;

public interface LivroServiceInterface {
    Livro salvar(CadastroLivro cadastroLivro);
    List<LivroDet> buscarLivrosDisponiveisParaAlugar();
    List<LivroDet> buscarLivrosAlugados();
    Livro buscarLivroPorId(Long id);
    List<LivroDet> buscarLivroPorAutor(String nome);
    void deletarLivroPorId(Long id);
}
