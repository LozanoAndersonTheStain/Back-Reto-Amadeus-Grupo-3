# Class UserRequest

## Descripción
La clase `UserRequest` es un objeto de transferencia de datos (DTO) que representa una solicitud de usuario. Contiene los campos necesarios para crear o actualizar un usuario.

## Anotaciones

- **@Data:** Anotación de Lombok que genera automáticamente los métodos getter y setter para los campos de la clase.
- **@NoArgsConstructor:** Anotación de Lombok que genera un constructor sin argumentos para la clase.
- **@AllArgsConstructor:** Anotación de Lombok que genera un constructor con todos los argumentos para la clase.
- **@Builder:** Anotación de Lombok que permite crear una instancia de la clase utilizando el patrón de diseño builder.
- **@JsonFormat:** Anotación de Jackson que especifica el formato para los campos de fecha.

## Campos

- `name:` El nombre del usuario.
- `email:` El correo electrónico del usuario.
- `birthdate:` La fecha de nacimiento del usuario, con el formato `yyyy-MM-dd`.
- `role:` El rol del usuario.

## Uso
La clase `UserRequest` se utiliza para enviar datos de usuario a través de la API. Por ejemplo, al crear un nuevo usuario, se puede crear una instancia de `UserRequest` y pasarla como parámetro al método de creación del usuario.

```java
UserRequest userRequest = UserRequest.builder()
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

    public void createUser(UserRequest userRequest) {
        // Crea un nuevo usuario en la base de datos utilizando los datos de userRequest
    }
}
```

En este ejemplo, el método `createUser` de `UserService` recibe un objeto `UserRequest` como parámetro y utiliza los datos del objeto para crear un nuevo usuario en la base de datos.

## Ejemplo de uso en un controlador

```java
@RestController
@RequestMapping("/users")
public class UserController {

    @PostMapping
    public void createUser(@RequestBody UserRequest userRequest) {
        // Crea un nuevo usuario en la base de datos utilizando los datos de userRequest
    }
}
```

En este ejemplo, el método `createUser` del `UserController` recibe un objeto `UserRequest` como parámetro y utiliza los datos del objeto para crear un nuevo usuario en la base de datos.