package com.equant.practice.controller;

import com.equant.practice.ResponseView;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@RestControllerAdvice
public class RestControllerAdviceForExceptionAndWrapper implements ResponseBodyAdvice {

    @ExceptionHandler(Exception.class)
    public ResponseMsg onExeption(Exception e) {
        ResponseMsg responseMsg = new ResponseMsg(e.getMessage());
        return responseMsg;
    }


    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        if (o instanceof ResponseView|| o instanceof ResponseMsg) {
            return o;
        }
        return new Wrapper(o);
    }

    @lombok.Data
    @NoArgsConstructor
    @AllArgsConstructor
    private static class Wrapper {
        Object data;

    }
    @lombok.Data
    @NoArgsConstructor
    @AllArgsConstructor
    private class ResponseMsg {
        private String error;
    }
    }
