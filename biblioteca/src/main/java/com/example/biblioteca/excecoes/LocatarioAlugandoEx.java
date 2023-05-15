package com.example.biblioteca.excecoes;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT)
public class LocatarioAlugandoEx extends RuntimeException{
    public LocatarioAlugandoEx(String msg){
        super(msg);
    }
}
