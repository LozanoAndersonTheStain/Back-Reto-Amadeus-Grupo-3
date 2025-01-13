# Class UserQueryModel

## Descripción
La clase `UserQuerysModel` es un modelo que representa una consulta de un usuario. Se utiliza para transferir datos entre las diferentes capas de la aplicación.

## Anotaciones

- **@Data:** Anotación de Lombok que genera automáticamente los métodos getter y setter para los campos de la clase.
- **@NoArgsConstructor:** Anotación de Lombok que genera un constructor sin argumentos para la clase.
- **@AllArgsConstructor:** Anotación de Lombok que genera un constructor con todos los argumentos para la clase.
- **@Builder:** Anotación de Lombok que permite crear una instancia de la clase utilizando el patrón de diseño builder.
- **@Getter:** Anotación de Lombok que genera los métodos getter para los campos de la clase.
- **@Setter:** Anotación de Lombok que genera los métodos setter para los campos de la clase.

## Campos

- `id:` El identificador único de la consulta del usuario.
- `query:` La cadena de la consulta.
- `queryTime:` El momento en que se realizó la consulta.
- `queryData:` Los datos asociados con la consulta.
- `user:` El usuario asociado con la consulta.

## Uso

La clase `UserQuerysModel` se utiliza para transferir datos de la consulta de un usuario entre las diferentes capas de la aplicación. Se puede usar en clases de servicio y controlador para manejar la información de la consulta del usuario.

```java
UserQuerysModel userQuerysModel = UserQuerysModel.builder()
        .id(1L)
        .query("Consulta de ejemplo")
        .queryTime("2023-10-01T10:00:00")
        .queryData("Datos de consulta de ejemplo")
        .user(new User(1L, "John Doe"))
        .build();
```

## Ejemplo de uso en un servicio

```java
@Service
public class UserQuerysService {

    public UserQuerysModel getUserQuery(Long id) {
        // Recupera la información de la consulta del usuario desde la base de datos y retorna una instancia de UserQuerysModel
    }
}
```

En este ejemplo, el método `getUserQuery` de `UserQuerysService` retorna un objeto `UserQuerysModel` con la información de la consulta del usuario obtenida de la base de datos.

## Ejemplo de uso en un controlador

```java
@RestController
@RequestMapping("/user-querys")
public class UserQuerysController {

    @GetMapping("/{id}")
    public UserQuerysModel getUserQuery(@PathVariable Long id) {
        // Recupera la información de la consulta del usuario desde la base de datos y retorna una instancia de UserQuerysModel
    }
}
```

En este ejemplo, el método `getUserQuery` de `UserQuerysController` retorna un objeto `UserQuerysModel` con la información de la consulta del usuario obtenida de la base de datos. El ID de la consulta del usuario se recibe como parámetro en la URL de la solicitud GET.