# Class UserResponse

## Descripción
La clase `UserResponse` es un objeto de transferencia de datos (DTO) que representa una respuesta de usuario. Contiene los campos necesarios para devolver la información de un usuario.

## Anotaciones

- **@Data:** Anotación de Lombok que genera automáticamente los métodos getter y setter para los campos de la clase.
- **@NoArgsConstructor:** Anotación de Lombok que genera un constructor sin argumentos para la clase.
- **@AllArgsConstructor:** Anotación de Lombok que genera un constructor con todos los argumentos para la clase.
- **@Builder:** Anotación de Lombok que permite crear una instancia de la clase utilizando el patrón de diseño builder.

## Campos

- `id:` El ID único del usuario.
- `name:` El nombre del usuario.
- `email:` El correo electrónico del usuario.
- `birthdate:` La fecha de nacimiento del usuario.
- `role:` El rol del usuario.

## Método `toString()`

El método `toString()` se utiliza para devolver una representación en cadena de la instancia `UserResponse`. La cadena incluye los valores de los campos `id`, `name`, `email`, `birthdate` y `role`.

## Uso

La clase `UserResponse` se utiliza para devolver la información de un usuario a través de la API. Por ejemplo, cuando se realiza una solicitud GET para obtener un usuario, se puede crear una instancia de `UserResponse` y devolverla como respuesta.

```java
UserResponse userResponse = UserResponse.builder()
        .id(1L)
        .name("Juan Pérez")
        .email("juan.perez@example.com")
        .birthdate(new Date())
        .role(RoleUser.USER)
        .build();
```

## Ejemplo de uso en un servicio

```java
@Service
public class UserService {

    public UserResponse getUser(Long id) {
        // Recupera un usuario desde la base de datos y devuelve una instancia de UserResponse
    }
}
```
}

En este ejemplo, el método `getUser` de `UserService` devuelve un objeto `UserResponse` con la información de un usuario obtenida desde la base de datos.

## Ejemplo de uso en un controlador

```java
@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping("/{id}")
    public UserResponse getUser(@PathVariable Long id) {
        // Recupera un usuario desde la base de datos y devuelve una instancia de UserResponse
    }
}
```

En este ejemplo, el método `getUser` del `UserController` devuelve un objeto `UserResponse` con la información de un usuario obtenida desde la base de datos.