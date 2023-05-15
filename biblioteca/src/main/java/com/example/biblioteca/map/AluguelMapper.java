package com.example.biblioteca.map;

import com.example.biblioteca.dto.response.AluguelDet;
import com.example.biblioteca.model.Aluguel;
import com.example.biblioteca.model.Livro;
import com.example.biblioteca.model.Locatario;

import java.util.List;

public interface AluguelMapper {

    static Aluguel toAluguel(List<Livro> livros, Locatario locatarioEncontrado){
        return Aluguel.builder()
                .livros(livros)
                .locatario(locatarioEncontrado)
                .build();
    }


    static AluguelDet toAluguelDet(Aluguel aluguel) {
        return AluguelDet.builder()
                .dataRetirada(aluguel.getDataRetirada())
                .dataDevolucao(aluguel.getDataDevolucao())
                .livros(aluguel.getLivros().stream().map(LivroMapper::toLivroDet).toList())
                .locatario(LocatarioMapper.toLocatarioDetails(aluguel.getLocatario()))
                .build();
    }
}
