package com.example.biblioteca.service.locatario;

import com.example.biblioteca.dto.request.CadastroLocatario;
import com.example.biblioteca.model.Locatario;

public interface LocatarioServiceInterface {
    Locatario salvar(CadastroLocatario locatarioCadastrado);

    Locatario buscarLocatarioPorId(Long id);

    Locatario buscarLocatarioPeloNome(String nome);

    //editar
    void deletar(Long id);
}
