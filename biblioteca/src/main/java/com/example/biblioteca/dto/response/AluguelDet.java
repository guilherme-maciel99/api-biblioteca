package com.example.biblioteca.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
public class AluguelDet {
    @JsonFormat(pattern = "dd/MM/yyyy hh:mm")
    private LocalDateTime dataRetirada;
    @JsonFormat(pattern = "dd/MM/yyyy hh:mm")
    private LocalDateTime dataDevolucao;
    private List<LivroDet> livros;
    private LocatarioDet locatario;
}
