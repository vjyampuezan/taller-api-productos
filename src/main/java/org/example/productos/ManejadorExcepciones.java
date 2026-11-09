package org.example.productos;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ManejadorExcepciones {

    @ExceptionHandler (ProductoNoEncontradoExcepcion.class)
    public ResponseEntity<Map<String, Object>> manejarNoEncontrado(ProductoNoEncontradoExcepcion excepcion) {

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(Map.of(
                        "mensaje", excepcion.getMessage(),
                        "codigo", 404
                        ));
    }

    @ExceptionHandler(ProductoInvalidoExcepcion.class)
    public ResponseEntity<Map<String, Object>> manejarInvalido(ProductoInvalidoExcepcion excepcion) {

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(Map.of(
                        "mensaje", excepcion.getMessage(),
                        "codigo", 400
                ));
    }
}
