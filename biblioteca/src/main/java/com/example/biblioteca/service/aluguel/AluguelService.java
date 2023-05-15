package com.example.biblioteca.service.aluguel;

import com.example.biblioteca.dto.request.CadastroAluguel;
import com.example.biblioteca.dto.response.AluguelDet;
import com.example.biblioteca.model.Aluguel;
import com.example.biblioteca.model.Livro;
import com.example.biblioteca.model.Locatario;
import com.example.biblioteca.repository.AluguelRepository;
import com.example.biblioteca.repository.LivroRepository;
import com.example.biblioteca.repository.LocatarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.biblioteca.map.AluguelMapper.toAluguel;
import static com.example.biblioteca.map.AluguelMapper.toAluguelDet;

@Service
public class AluguelService implements AluguelServiceInterface{
    private static final String MESSAGE_NOT_FOUND = "Locatario não encontrado";
    private final AluguelRepository aluguelRepository;
    private final LocatarioRepository locatarioRepository;
    private final LivroRepository livroRepository;

    @Autowired

    public AluguelService(AluguelRepository aluguelRepository, LocatarioRepository locatarioRepository, LivroRepository livroRepository) {
        this.aluguelRepository = aluguelRepository;
        this.locatarioRepository = locatarioRepository;
        this.livroRepository = livroRepository;
    }

    @Override
    public Aluguel salvarAluguel(CadastroAluguel cadastroAluguel) {
        List<Livro> livros = livroRepository.findAllById(cadastroAluguel.getIdLivros());

        if (livros.isEmpty()){
            throw new RuntimeException("Livro não disponível");
        }

        livros.forEach(v -> v.setStatusAluguel(true));

        Locatario locatarioEncontrado = locatarioRepository.findById(cadastroAluguel.getIdLocatario())
                .orElseThrow(() -> new RuntimeException(MESSAGE_NOT_FOUND));

        Aluguel aluguel = toAluguel(livros, locatarioEncontrado);
        aluguelRepository.save(aluguel);

        return aluguel;
    }

    @Override
    public AluguelDet buscarAluguelPorId(Long id) {
        Aluguel aluguel = aluguelRepository.findById(1L).orElseThrow(() -> new RuntimeException("Aluguel não encontrado"));
        return toAluguelDet(aluguel);
    }

    @Override
    public AluguelDet buscarAluguelPorNomeDeLocador(String nome) {
        Aluguel aluguel = aluguelRepository.findAluguelByLocatario(nome)
                .orElseThrow(() -> new RuntimeException(MESSAGE_NOT_FOUND));
        return toAluguelDet(aluguel);
    }

    @Override
    public void excluirAluguelPorId(Long id) {
        Aluguel aluguel = aluguelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(MESSAGE_NOT_FOUND));

        aluguel.getLivros().forEach(v -> v.setStatusAluguel(false));

        aluguelRepository.delete(aluguel);
    }
}
