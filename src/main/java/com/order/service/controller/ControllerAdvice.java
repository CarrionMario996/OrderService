package com.order.service.controller;

import com.order.service.exception.RequestException;
import com.order.service.model.dto.ErrorDto;
import feign.FeignException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(value= RequestException.class)
    public ResponseEntity<ErrorDto> runtimeExceptionHandler(RequestException ex){
        ErrorDto error=ErrorDto.builder().message(ex.getMessage()).build();
        return new ResponseEntity<>(error, ex.getStatus());
    }
}
