package com.example.biblioteca.excecoes;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT)
public class AutorComLivroEx extends RuntimeException{

    public AutorComLivroEx(String msg){
        super(msg);
    }
}