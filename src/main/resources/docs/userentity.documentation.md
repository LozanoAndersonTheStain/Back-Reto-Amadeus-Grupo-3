# Clase UserEntity

## Descripción
La clase UserEntity es una entidad de JPA que representa un usuario en la base de datos. Contiene los campos necesarios para almacenar información de un usuario.

## ***Anotaciones***

- `@Entity(name = "users"):` anotación que indica que la clase es una entidad de JPA y especifica el nombre de la tabla en la base de datos.
- `@Data:` anotación de Lombok que genera automáticamente los métodos getter y setter para los campos de la clase.
- `@NoArgsConstructor:` anotación de Lombok que genera un constructor sin parámetros para la clase.
- `@AllArgsConstructor:` anotación de Lombok que genera un constructor con parámetros para la clase.
- `@Builder:` anotación de Lombok que permite crear una instancia de la clase utilizando un patrón de diseño de constructor.
- `@Getter:` anotación de Lombok que genera los métodos getter para los campos de la clase. 
- `@Setter:` anotación de Lombok que genera los métodos setter para los campos de la clase.

## Campos

* `id:` el ID único del usuario.
* `name:` el nombre del usuario.
* `email:` el correo electrónico del usuario.
* `password:` la contraseña del usuario.
* `birthdate:` la fecha de nacimiento del usuario.
* `DNI:` el número de identificación del usuario.

## Uso

La clase UserEntity se utiliza para almacenar información de usuario en la base de datos. Por ejemplo, cuando se crea un nuevo usuario, se puede crear una instancia de UserEntity y guardarla en la base de datos.

```java
UserEntity userEntity = UserEntity.builder()
        .name("Juan Pérez")
        .email("juan.perez@example.com")
        .password("password123")
        .birthdate(new Date())
        .DNI("123456789")
        .build();
userService.save(userEntity);
```

## Recomendaciones

* Asegúrate de que los campos de la clase `UserEntity` sean consistentes con los campos de la tabla de usuarios en la base de datos.
* Utiliza la clase `UserEntity` para almacenar información de usuario en la base de datos en lugar de utilizar un mapa o una lista de parámetros.
* Asegúrate de que la clase `UserEntity` sea mapeada correctamente con la tabla de usuarios en la base de datos utilizando las anotaciones de JPA.