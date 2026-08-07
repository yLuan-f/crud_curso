package br.com.luan.crud_curso.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> criarCurso(MethodArgumentNotValidException ex) {
        Map<String, String> errorMap = new java.util.HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(error -> {;
            errorMap.put(error.getField(), error.getDefaultMessage());

        });
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(errorMap);
    }
}
