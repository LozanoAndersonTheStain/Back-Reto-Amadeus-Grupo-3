# Clase UserRequest

## Descripción
La clase UserRequest es un objeto de transferencia de datos (DTO) que representa una solicitud de usuario. Contiene los campos necesarios para crear o actualizar un usuario.

## ***Anotaciones***

- **@Data:** Anotación de Lombok que genera automáticamente los métodos getter y setter para los campos de la clase.
- **@NoArgsConstructor:** Anotación de Lombok que genera un constructor sin parámetros para la clase.
- **@AllArgsConstructor:** Anotación de Lombok que genera un constructor con parámetros para la clase.
- **@Builder:** Anotación de Lombok que permite crear una instancia de la clase utilizando un patrón de diseño de constructor.

## Campos

- `name:` el nombre del usuario.
- `email:` el correo electrónico del usuario.
- `password:` la contraseña del usuario.
- `birthdate:` la fecha de nacimiento del usuario.
- `DNI:` el número de identificación del usuario.

## Uso
La clase UserRequest se utiliza para enviar datos de usuario a través de la API. Por ejemplo, cuando se crea un nuevo usuario, se puede crear una instancia de UserRequest y pasarla como parámetro al método de creación de usuario.

```java
UserRequest userRequest = UserRequest.builder()
        .name("Juan Pérez")
        .email("juan.perez@example.com")
        .password("password123")
        .birthdate(new Date())
        .DNI("123456789")
        .build();
```

## Recomendaciones

* Asegúrate de que los campos de la clase `UserRequest` sean consistentes con los campos de la entidad de usuario en la base de datos.
* Utiliza la clase `UserRequest` para enviar datos de usuario a través de la API en lugar de utilizar un mapa o una lista de parámetros.
* Asegúrate de que la clase `UserRequest` sea serializable para que pueda ser convertida a JSON o XML cuando se envíe a través de la API.

## Ejemplo de uso en un servicio

```java
@Service
public class UserService {
    
    public void createUser(UserRequest userRequest) {
        // Crea un nuevo usuario en la base de datos utilizando los datos de userRequest
    }
}
```

En este ejemplo, el método `createUser` del servicio `UserService` recibe un objeto `UserRequest` como parámetro y utiliza los datos del objeto para crear un nuevo usuario en la base de datos.

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