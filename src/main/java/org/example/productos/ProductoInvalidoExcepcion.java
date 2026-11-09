package org.example.productos;

public class ProductoInvalidoExcepcion extends RuntimeException{

    public ProductoInvalidoExcepcion(String mensaje){
        super(mensaje);
    }
}
