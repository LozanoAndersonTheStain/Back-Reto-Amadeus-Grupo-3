# Clase InvalidUserDataException

## Descripción
La clase `InvalidUserDataException` es una excepción personalizada que se lanza cuando se encuentra datos de usuario inválidos. Esta clase extiende la clase `RuntimeException`.

## Constructor

- **`InvalidUserDataException(String message)`**
    - **Descripción:** Construye una nueva `InvalidUserDataException` con el mensaje detallado especificado.
    - **Parámetros:**
        - `message:` El mensaje detallado.

## Uso

La clase `InvalidUserDataException` se utiliza para indicar que se han encontrado datos de usuario inválidos. Por ejemplo, cuando se valida la entrada del usuario, esta excepción puede ser lanzada si la entrada es inválida.

```java
if (user.getEmail() == null || user.getEmail().isEmpty()) {
    throw new InvalidUserDataException("El correo electrónico no puede ser nulo o vacío");
}
```

En este ejemplo, si el correo electrónico del usuario es nulo o vacío, se lanza una `InvalidUserDataException` con un mensaje específico.