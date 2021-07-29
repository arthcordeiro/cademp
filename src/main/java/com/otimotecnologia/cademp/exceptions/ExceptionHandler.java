package com.otimotecnologia.cademp.exceptions;

import com.otimotecnologia.cademp.dtos.ExceptionHandlerDTO;
import com.otimotecnologia.cademp.dtos.ResponseDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.Date;

@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(ExceptionHandler.class);

    @org.springframework.web.bind.annotation.ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> handlerGenericException(Exception ex, WebRequest request) {

        log.error(ex.toString());

        ExceptionHandlerDTO error = new ExceptionHandlerDTO(new Date(), ex.getLocalizedMessage());
        if (error.getMessage() == null) error.setMessage(ex.toString());

        return new ResponseEntity<>(error, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(value = {WebClientResponseException.class})
    public ResponseEntity<Object> handlerWebClientException(WebClientResponseException webClientException) {
        log.error(webClientException.toString());

        ExceptionHandlerDTO error = new ExceptionHandlerDTO(new Date(), webClientException.getLocalizedMessage());
        if (error.getMessage() == null) error.setMessage(webClientException.toString());

        return new ResponseEntity<>(error, new HttpHeaders(), webClientException.getRawStatusCode());
    }
}
