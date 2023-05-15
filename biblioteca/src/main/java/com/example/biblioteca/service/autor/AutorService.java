package com.example.biblioteca.service.autor;

import com.example.biblioteca.excecoes.AutorComLivroEx;
import com.example.biblioteca.dto.request.CadastroAutor;
import com.example.biblioteca.model.Autor;
import com.example.biblioteca.repository.AutorRepository;
import com.example.biblioteca.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.example.biblioteca.map.AutorMapper.toAutor;


@Service
public class AutorService implements AutorServiceInterface{
    private static  final String MESSAGE_NOT_FOUND = "Autor não encontrado";
    private final AutorRepository autorRepository;
    private final LivroRepository livroRepository;

    @Autowired
    public AutorService(AutorRepository autorRepository, LivroRepository livroRepository) {
        this.autorRepository = autorRepository;
        this.livroRepository = livroRepository;
    }

    @Override
    public Autor salvarAutor(CadastroAutor autorCadastrado) {
        Autor autorEntity = toAutor(autorCadastrado);
        autorRepository.save(autorEntity);
        return autorEntity;
    }

    @Override
    public Autor buscarAutorPorNome(String nome) {
        return autorRepository.findByNome(nome).orElseThrow(() -> new RuntimeException(MESSAGE_NOT_FOUND));
    }

    @Override
    public void excluirAutorPorId(Long id) {
        Autor autor = autorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(MESSAGE_NOT_FOUND));

        livroRepository.findLivroByNome(autor.getNome())
                .ifPresent(v -> {throw new AutorComLivroEx("O autor possui livro em sua autoria, só será possível excluir o autor se não possuir livros em sua autoria");});

        autorRepository.deleteById(id);
    }
}
