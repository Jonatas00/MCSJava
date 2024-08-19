package com.teste.introducaospringboot.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.teste.introducaospringboot.models.error.ErrorMessage;
import com.teste.introducaospringboot.models.exception.ResourceNotFoundException;

@ControllerAdvice
public class RestExceptionHandler {

  @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException ex) {

    ErrorMessage error = new ErrorMessage("Not Found", 404, ex.getMessage());

    return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
  }
}
