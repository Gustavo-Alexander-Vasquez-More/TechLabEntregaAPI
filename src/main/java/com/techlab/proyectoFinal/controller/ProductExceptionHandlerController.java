package com.techlab.proyectoFinal.controller;

import com.techlab.proyectoFinal.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ProductExceptionHandlerController {


    //Esta clase maneja las excepciones de validación y devuelve un mensaje de error adecuado al cliente.
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getAllErrors().forEach((error) -> {
            String fieldName = ((org.springframework.validation.FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }

    //Manejo de errores de deserialización JSON (como valores de enum inválidos)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Map<String, String>> handleHttpMessageNotReadable(HttpMessageNotReadableException ex) {
        Map<String, String> errors = new HashMap<>();

        String message = ex.getMessage();

        // Detectar si es un error de enum
        if (message != null && message.contains("Category")) {
            errors.put("category", "Categoría inválida. Valores permitidos: CELULARES, NOTEBOOKS, TABLETS, AUDIO, CONSOLAS, PERIFERICOS, MONITORES, TELEVISORES");
        } else {
            errors.put("error", "Error en el formato de los datos enviados. Verifica que todos los campos tengan el tipo correcto.");
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }


    //Errores de servidor
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGeneralException(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno en el servidor: " + ex.getMessage());
    }

    //Manejo de excepciones NotFoundException
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> handleNotFoundException(NotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

}
