package com.example.demo.exception;

import javax.persistence.EntityNotFoundException;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class CustomExceptionHandler {

	@ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handlerNotFoundException(NotFoundException ex, WebRequest req) {
        // Log err

        return new ErrorResponse(HttpStatus.NOT_FOUND, ex.getMessage());
    }
	
	@ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handlerIllegalArgumentException(IllegalArgumentException ex, WebRequest req) {
        // Log err
        return new ErrorResponse(HttpStatus.BAD_REQUEST, ex.getMessage());
    }
	
	@ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handlerEntityNotFoundException(EntityNotFoundException ex, WebRequest req) {
        // Log err
        return new ErrorResponse(HttpStatus.NOT_FOUND, ex.getMessage());
    }
	
	@ExceptionHandler(EmptyResultDataAccessException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handlerEntityNotFoundException(EmptyResultDataAccessException ex, WebRequest req) {
        // Log err
        return new ErrorResponse(HttpStatus.NOT_FOUND, ex.getMessage());
    }

    // Handle all undeclared exceptions 
	@ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handlerException(Exception ex, WebRequest req) {
        // Log err

        return new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, ex +": "+ex.getMessage());
    }
}
