package dev.patika.batuhanunverdi.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;


/**
 * @author Mert Batuhan UNVERDI
 * @since 12.04.2022
 */
@RestControllerAdvice
@Slf4j
public class RestServiceControllerAdvice extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String message = ex.getMessage();
        return ResponseEntity.badRequest().body(message);
    }
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<?> onConstraintViolationExceptionHandle(ConstraintViolationException exception) {
        return ResponseEntity.badRequest().body(exception.getConstraintViolations().stream().map(ConstraintViolation::getMessage).toArray());
    }
    @ExceptionHandler(HttpClientErrorException.class)
    public ResponseEntity<?> onHttpClientErrorException(HttpClientErrorException ex){
        return ResponseEntity.badRequest().body("City not found. Please check the city name that you wrote");
    }
}

