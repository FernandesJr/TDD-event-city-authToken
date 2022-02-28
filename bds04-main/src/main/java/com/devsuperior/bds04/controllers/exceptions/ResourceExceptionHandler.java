package com.devsuperior.bds04.controllers.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice //Escuta as exceptions lançadas nos Controllers
public class ResourceExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class) //Capturando exception específica
    public ResponseEntity<ValidationError> validation(MethodArgumentNotValidException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY; //Significa que a entidade não pôde ser processada 422
        ValidationError error = new ValidationError();
        error.setTimestamp(Instant.now());
        error.setStatus(status.value());
        error.setError("Validation Exception");
        error.setMessage(e.getMessage());
        error.setPath(request.getRequestURI());

        for(FieldError f : e.getBindingResult().getFieldErrors()){
            error.addErros(f.getField(), f.getDefaultMessage());
        }

        return ResponseEntity.status(status).body(error);
    }
}
