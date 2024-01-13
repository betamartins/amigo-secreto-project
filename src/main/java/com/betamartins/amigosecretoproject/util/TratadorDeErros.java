package com.betamartins.amigosecretoproject.util;

import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailSendException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Arrays;
import java.util.List;

@RestControllerAdvice
public class TratadorDeErros {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> tratarErro400(MethodArgumentNotValidException ex){
        List<FieldError> fieldErrors = ex.getFieldErrors();
        return ResponseEntity.badRequest().body(fieldErrors.stream().map(RetornoErroDadosValidacao::new).toList());
    }

    @ExceptionHandler(MailSendException.class)
    public ResponseEntity<?> tratarErroEmail(MailSendException ex){
        var listExceptions = Arrays.stream(ex.getMessageExceptions()).toList();
        return ResponseEntity.badRequest().body(listExceptions.stream().map(RetornoErroDadosValidacao::new).toList());
    }

    private record RetornoErroDadosValidacao(String campo, String mensagem){
        public RetornoErroDadosValidacao(FieldError fieldError){
            this(fieldError.getField(), fieldError.getDefaultMessage());
        }
        public RetornoErroDadosValidacao(Exception ex){
            this(ex.getClass().getName(), ex.getMessage());
        }
    }

}
