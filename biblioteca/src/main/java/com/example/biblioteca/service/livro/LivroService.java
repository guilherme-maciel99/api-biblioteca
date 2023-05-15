package com.example.biblioteca.service.livro;

import com.example.biblioteca.excecoes.LivroAlugadoEx;
import com.example.biblioteca.dto.request.CadastroLivro;
import com.example.biblioteca.dto.response.LivroDet;
import com.example.biblioteca.map.LivroMapper;
import com.example.biblioteca.model.Autor;
import com.example.biblioteca.model.Livro;
import com.example.biblioteca.repository.AutorRepository;
import com.example.biblioteca.repository.LivroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.example.biblioteca.map.LivroMapper.toLivro;

@Service
public class LivroService implements LivroServiceInterface{
    private static final String MESSAGE_NOT_FOUND = "Autor não encontrado";
    private final LivroRepository livroRepository;
    private final AutorRepository autorRepository;

    public LivroService(LivroRepository livroRepository, AutorRepository autorRepository) {
        this.livroRepository = livroRepository;
        this.autorRepository = autorRepository;
    }

    @Override
    public Livro salvar(CadastroLivro cadastroLivro){
        Optional<Autor> entId = autorRepository.findById(cadastroLivro.getAutorId());

        if (entId.isEmpty()){
            throw new RuntimeException(MESSAGE_NOT_FOUND);
        }

        Livro livroEnt = toLivro(cadastroLivro, entId);
        livroRepository.save(livroEnt);

        return livroEnt;
    }
    @Override
    public List<LivroDet> buscarLivrosDisponiveisParaAlugar() {
        return livroRepository.findAll().stream().map(LivroMapper::toLivroDet).toList();
    }

    @Override
    public List<LivroDet> buscarLivrosAlugados() {
        return livroRepository.findAll().stream().map(LivroMapper::toLivroDet).toList();
    }

    @Override
    public Livro buscarLivroPorId(Long id) {
        return livroRepository.findById(id).orElseThrow(() -> new RuntimeException("Livro não encontrado"));
    }

    @Override
    public List<LivroDet> buscarLivroPorAutor(String nome) {
        return livroRepository.findLivroByNome(nome).stream().map(LivroMapper::toLivroDet).toList();
    }

    @Override
    public void deletarLivroPorId(Long id) {
        Livro livroEntity = livroRepository.findById(id).orElseThrow(() -> new RuntimeException(MESSAGE_NOT_FOUND));

        if (livroEntity.isStatusAluguel()){
            throw new LivroAlugadoEx("Livro alugado não pode ser deletado");
        }

        livroRepository.deleteById(id);
    }
}
