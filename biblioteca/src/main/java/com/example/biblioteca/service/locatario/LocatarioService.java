package com.example.biblioteca.service.locatario;

import com.example.biblioteca.excecoes.LocatarioAlugandoEx;
import com.example.biblioteca.dto.request.CadastroLocatario;
import com.example.biblioteca.model.Locatario;
import com.example.biblioteca.repository.AluguelRepository;
import com.example.biblioteca.repository.LocatarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.example.biblioteca.map.LocatarioMapper.toLocatario;

@Service
public class LocatarioService implements LocatarioServiceInterface {
        private static final String MESSAGE_NOT_FOUND = "Locatario não encontrado";
        private final LocatarioRepository locatarioRepository;
        private final AluguelRepository aluguelRepository;

        @Autowired
        public LocatarioService(LocatarioRepository locatarioRepository, AluguelRepository aluguelRepository) {
            this.locatarioRepository = locatarioRepository;
            this.aluguelRepository = aluguelRepository;
        }

        @Override
        public Locatario salvar(CadastroLocatario locatarioCadastrado) {
            Locatario locatario = toLocatario(locatarioCadastrado);
            locatarioRepository.save(locatario);
            return locatario;
        }

        @Override
        public Locatario buscarLocatarioPorId(Long id) {
            return locatarioRepository.findById(id).orElseThrow(() -> new RuntimeException(MESSAGE_NOT_FOUND));
        }

        @Override
        public Locatario buscarLocatarioPeloNome(String nome) {
            return locatarioRepository.findLocatarioByNome(nome).orElseThrow(() -> new RuntimeException(MESSAGE_NOT_FOUND));
        }



        /*public Locatario editar() {

        }*/

        @Override
        public void deletar(Long id) {
            Locatario locatario = locatarioRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException(MESSAGE_NOT_FOUND));
            aluguelRepository.findAluguelByLocatario(locatario.getNome())
                    .ifPresent(v -> {
                        throw new LocatarioAlugandoEx("Locatario não pode ser excluido pois esta alugando livros");
                    });

            locatarioRepository.deleteById(id);
        }
    }