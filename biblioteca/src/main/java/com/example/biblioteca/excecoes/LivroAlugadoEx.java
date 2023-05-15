package com.example.biblioteca.excecoes;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT)
public class LivroAlugadoEx extends RuntimeException{

    public LivroAlugadoEx(String msg){
        super(msg);
    }
}