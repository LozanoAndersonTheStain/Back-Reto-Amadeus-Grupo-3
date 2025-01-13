# Clase UserAlreadyExistsException

## Descripción
La clase `UserAlreadyExistsException` es una excepción personalizada que se lanza cuando un usuario ya existe en la base de datos. Esta clase extiende la clase `RuntimeException`.

## Constructor

- **`UserAlreadyExistsException(String message)`**
    - **Descripción:** Construye una nueva `UserAlreadyExistsException` con el mensaje detallado especificado.
    - **Parámetros:**
        - `message:` El mensaje detallado.

## Uso

La clase `UserAlreadyExistsException` se utiliza para indicar que un usuario ya existe en la base de datos. Por ejemplo, al crear un nuevo usuario, esta excepción puede ser lanzada si el usuario ya existe.

```java
if (userRepository.findByEmail(user.getEmail()).isPresent()) {
    throw new UserAlreadyExistsException("El usuario con el correo electrónico " + user.getEmail() + " ya existe");
}
```

En este ejemplo, si un usuario con el correo electrónico especificado ya existe en la base de datos, se lanza una `UserAlreadyExistsException` con un mensaje específico.
