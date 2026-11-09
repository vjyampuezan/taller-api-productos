package org.example.productos;

public class ProductoNoEncontradoExcepcion extends RuntimeException{

    public ProductoNoEncontradoExcepcion(String mensaje) {
        super(mensaje);
    }
}
