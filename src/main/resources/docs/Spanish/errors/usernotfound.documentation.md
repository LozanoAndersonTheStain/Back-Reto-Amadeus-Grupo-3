# Clase UserNotFoundException

## Descripción
La clase `UserNotFoundException` es una excepción personalizada que se lanza cuando un usuario no se encuentra en la base de datos. Esta clase extiende la clase `RuntimeException`.

## Constructor

- **`UserNotFoundException(String message)`**
    - **Descripción:** Construye una nueva `UserNotFoundException` con el mensaje detallado especificado.
    - **Parámetros:**
        - `message:` El mensaje detallado.

## Uso

La clase `UserNotFoundException` se utiliza para indicar que un usuario no fue encontrado en la base de datos. Por ejemplo, al recuperar un usuario por su ID, esta excepción puede ser lanzada si el usuario no existe.

```java
if (!userRepository.findById(id).isPresent()) {
    throw new UserNotFoundException("Usuario con el ID " + id + " no encontrado");
}
```

En este ejemplo, si un usuario con el ID especificado no se encuentra en la base de datos, se lanza una `UserNotFoundException` con un mensaje específico.