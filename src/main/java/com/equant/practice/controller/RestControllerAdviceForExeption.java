package com.equant.practice.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestControllerAdviceForExeption {

    @ExceptionHandler(Exception.class)
    public String onExeption(Exception e){
        return e.getMessage();
    }
}
