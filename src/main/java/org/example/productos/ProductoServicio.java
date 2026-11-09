package org.example.productos;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

@Service
public class ProductoServicio {

    private final Map<Long, Producto> productos = new ConcurrentHashMap<>();

    private final AtomicLong secuencia = new AtomicLong(0);

    public List<Producto> listar() {

        return new ArrayList<>(productos.values());
    }

    public Producto buscarPorId(Long id) {
        Producto producto = productos.get(id);

        if (producto == null) {
            throw new ProductoNoEncontradoExcepcion(
                    "no existe el producto " + id
            );
        }
        return producto;
    }

    public Producto registrar(Producto producto) {
        if (producto.getPrecio() == null || producto.getPrecio().compareTo(BigDecimal.ZERO) <= 0)  {

            throw new ProductoInvalidoExcepcion(
                    "El precio debe ser mayor que cero "
            );
        }
        if (producto.getStock() == null || producto.getStock() < 0) {
            throw new ProductoInvalidoExcepcion(
                    "El stock es obligatorio y no es negativo "
            );
        }

        Long id = secuencia.incrementAndGet();
        producto.setId(id);
        productos.put(id, producto);

        return producto;
    }

    public void eliminar(Long id) {
        Producto eliminado = productos.remove(id);

        if (eliminado == null) {
            throw new ProductoNoEncontradoExcepcion(
                    "no existe el producto " + id
            );
        }
    }
}
