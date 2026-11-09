# Taller Individual 1.1: Desarrollo de una API REST con Inyección de Dependencias y Manejo de Excepciones

Este proyecto consiste en el desarrollo de una API REST básica utilizando **Spring Boot** y **Spring Web** para la gestión en memoria de productos de una tienda. Aplica de manera estricta los conceptos de Inversión de Control (IoC), inyección de dependencias por constructor y manejo centralizado de excepciones.

## 🚀 Características del Proyecto

- **Arquitectura Limpia**: Separación de responsabilidades clara entre la capa de presentación (`@RestController`) y la capa de negocio (`@Service`).
- **Inyección por Constructor**: Acoplamiento débil garantizado sin el uso de instancias manuales mediante el operador `new`.
- **Persistencia en Memoria**: Almacenamiento seguro y eficiente utilizando colecciones concurrentes (`ConcurrentHashMap`) y secuencias numéricas atómicas (`AtomicLong`).
- **Manejo Global de Excepciones**: Respuestas estructuradas utilizando un controlador de consejos (`@RestControllerAdvice`) y `@ExceptionHandler`.

## 🛠️ Tecnologías Utilizadas

- **Java 17**
- **Spring Boot 4.1.2** (Spring Web)
- **Apache Maven**
- **IntelliJ IDEA**

## 📌 Endpoints de la API

| Método | Endpoint | Descripción | Código HTTP |
| :--- | :--- | :--- | :--- |
| **GET** | `/api/productos` | Obtiene la lista completa de productos. | `200 OK` |
| **GET** | `/api/productos/{id}` | Busca un producto por su identificador único. | `200 OK` / `404 Not Found` |
| **POST** | `/api/productos` | Registra un nuevo producto en el sistema. | `201 Created` / `400 Bad Request` |
| **DELETE** | `/api/productos/{id}` | Elimina un producto del inventario. | `204 No Content` / `404 Not Found` |

## 📐 Reglas de Negocio Implementadas

1. **Validación de Precio**: No se permite el registro de un producto con precio menor o igual a cero (`ProductoInvalidoExcepcion`).
2. **Validación de Stock**: No se permite el registro de un producto con existencias negativas (`ProductoInvalidoExcepcion`).
3. **Control de Existencia**: Cualquier consulta o eliminación de un ID no registrado lanza un error controlado de recurso no encontrado (`ProductoNoEncontradoExcepcion`).

## 📋 Formato Estructurado de Errores

Cuando la API intercepta una excepción, el manejador centralizado responde con un objeto JSON uniforme:

```json
{
  "codigo": 404,
  "mensaje": "no existe el producto 999"
}
```

---
**Desarrollado por:** Yampuezan
