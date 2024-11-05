# Clase UserResponse

## Descripción
La clase UserResponse es un objeto de transferencia de datos (DTO) que representa una respuesta de usuario. Contiene los campos necesarios para devolver información de un usuario.

## ***Anotaciones***

- **@Data:** Anotación de Lombok que genera automáticamente los métodos getter y setter para los campos de la clase.
- **@NoArgsConstructor:** Anotación de Lombok que genera un constructor sin parámetros para la clase.
- **@AllArgsConstructor:** Anotación de Lombok que genera un constructor con parámetros para la clase.
- **@Builder:** Anotación de Lombok que permite crear una instancia de la clase utilizando un patrón de diseño de constructor.

## Campos

- `name:` el nombre del usuario.
- `email:` el correo electrónico del usuario. 
- `birthdate:` la fecha de nacimiento del usuario.
- `DNI:` el número de identificación del usuario.

## Método `toString()`

El método toString() es utilizado para devolver una representación en cadena de la instancia de UserResponse. La cadena incluye los valores de los campos name, email, birthdate y DNI.

## Uso

La clase UserResponse se utiliza para devolver información de un usuario a través de la API. Por ejemplo, cuando se realiza una solicitud GET para obtener un usuario, se puede crear una instancia de UserResponse y devolverla como respuesta.
    
```java
    UserResponse userResponse = UserResponse.builder()
        .name("Juan Pérez")
        .email("juan.perez@example.com")
        .birthdate(new Date())
        .DNI("123456789")
        .build();
```

## Recomendaciones

- Asegúrate de que los campos de la clase `UserResponse` sean consistentes con los campos de la entidad de usuario en la base de datos.
- Utiliza la clase `UserResponse` para devolver información de un usuario a través de la API en lugar de utilizar un mapa o una lista de parámetros.
- Asegúrate de que la clase `UserResponse` sea serializable para que pueda ser convertida a JSON o XML cuando se devuelva a través de la API.

## Ejemplo de uso en un servicio

```java
@Service
public class UserService {
    
    public UserResponse getUser(Long id) {
        // Obtiene un usuario de la base de datos y devuelve una instancia de UserResponse
    }
}
```

En este ejemplo, el método `getUser` del servicio `UserService` devuelve un objeto `UserResponse` con la información de un usuario obtenida de la base de datos.

## Ejemplo de uso en un controlador

```java
@RestController
@RequestMapping("/users")
public class UserController {
    
    @GetMapping("/{id}")
    public UserResponse getUser(@PathVariable Long id) {
        // Obtiene un usuario de la base de datos y devuelve una instancia de UserResponse
    }
}
```

En este ejemplo, el método `getUser` del controlador `UserController` devuelve un objeto `UserResponse` con la información de un usuario obtenida de la base de datos. El ID del usuario se recibe como parámetro en la URL de la solicitud GET.