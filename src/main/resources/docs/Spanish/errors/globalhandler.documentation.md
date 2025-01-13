# Clase GlobalExceptionHandler

## Descripción
La clase `GlobalExceptionHandler` es un manejador de excepciones global que maneja las excepciones lanzadas por la aplicación. Proporciona métodos para manejar excepciones específicas y devolver respuestas HTTP apropiadas.

## Anotaciones

- **@ControllerAdvice:** Anotación de Spring que indica que la clase proporciona manejo global de excepciones para todos los controladores.

## Métodos

- **`handleUserNotFoundException(UserNotFoundException ex)`**
    - **Descripción:** Maneja la excepción `UserNotFoundException` y devuelve un `ResponseEntity` con un estado `NOT_FOUND`.
    - **Parámetros:**
        - `ex:` La excepción `UserNotFoundException` a manejar.
    - **Retorno:** `ResponseEntity<String>` con el mensaje de la excepción y `HttpStatus.NOT_FOUND`.

- **`handleInvalidUserDataException(InvalidUserDataException ex)`**
    - **Descripción:** Maneja la excepción `InvalidUserDataException` y devuelve un `ResponseEntity` con un estado `BAD_REQUEST`.
    - **Parámetros:**
        - `ex:` La excepción `InvalidUserDataException` a manejar.
    - **Retorno:** `ResponseEntity<String>` con el mensaje de la excepción y `HttpStatus.BAD_REQUEST`.

- **`handleGeneralException(Exception ex)`**
    - **Descripción:** Maneja excepciones generales y devuelve un `ResponseEntity` con un estado `INTERNAL_SERVER_ERROR`.
    - **Parámetros:**
        - `ex:` La excepción general a manejar.
    - **Retorno:** `ResponseEntity<String>` con un mensaje de error genérico y `HttpStatus.INTERNAL_SERVER_ERROR`.

## Uso

La clase `GlobalExceptionHandler` se utiliza para manejar excepciones globalmente en la aplicación. Por ejemplo, cuando se lanza una `UserNotFoundException`, se invoca el método `handleUserNotFoundException` para devolver una respuesta `NOT_FOUND`.

```java
// Ejemplo de lanzar una UserNotFoundException
throw new UserNotFoundException("Usuario no encontrado");

```

En este ejemplo, cuando se lanza la `UserNotFoundException`, se invoca el método `handleUserNotFoundException` de la clase `GlobalExceptionHandler` para manejar la excepción y devolver una respuesta `NOT_FOUND`.