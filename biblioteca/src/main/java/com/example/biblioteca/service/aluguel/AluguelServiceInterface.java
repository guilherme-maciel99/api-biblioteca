package com.example.biblioteca.service.aluguel;

import com.example.biblioteca.dto.request.CadastroAluguel;
import com.example.biblioteca.dto.response.AluguelDet;
import com.example.biblioteca.model.Aluguel;

public interface AluguelServiceInterface {
    Aluguel salvarAluguel(CadastroAluguel cadastroAluguel);

    AluguelDet buscarAluguelPorId(Long id);

    AluguelDet buscarAluguelPorNomeDeLocador(String nome);

    void excluirAluguelPorId(Long id);
}
