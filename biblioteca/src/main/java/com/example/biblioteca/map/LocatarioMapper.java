package com.example.biblioteca.map;

import com.example.biblioteca.dto.request.CadastroLocatario;
import com.example.biblioteca.dto.response.LocatarioDet;
import com.example.biblioteca.model.Locatario;

public interface LocatarioMapper {

    static Locatario toLocatario(CadastroLocatario cadastroLocatario){
        return Locatario.builder()
                .nome(cadastroLocatario.getNome())
                .sexo(cadastroLocatario.getSexo())
                .telefone(cadastroLocatario.getTelefone())
                .email(cadastroLocatario.getEmail())
                .dataNascimento(cadastroLocatario.getDataNascimento())
                .cpf(cadastroLocatario.getCpf())
                .build();
    }
    static LocatarioDet toLocatarioDetails(Locatario locatario){
        return LocatarioDet.builder()
                .nome(locatario.getNome())
                .genero(locatario.getSexo())
                .telefone(locatario.getTelefone())
                .dataNascimento(locatario.getDataNascimento())
                .build();
    }
}
