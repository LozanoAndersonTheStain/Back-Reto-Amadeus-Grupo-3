# Class User

## Descripción
La clase `User` es un modelo de datos que representa a un usuario en la aplicación. Contiene los campos necesarios para almacenar la información del usuario.

## Anotaciones

- `@Data:` Anotación de Lombok que genera automáticamente los métodos getter y setter para los campos de la clase.
- `@NoArgsConstructor:` Anotación de Lombok que genera un constructor sin argumentos para la clase.
- `@AllArgsConstructor:` Anotación de Lombok que genera un constructor con todos los argumentos para la clase.
- `@Builder:` Anotación de Lombok que permite crear una instancia de la clase utilizando el patrón de diseño builder.
- `@Getter:` Anotación de Lombok que genera los métodos getter para los campos de la clase.
- `@Setter:` Anotación de Lombok que genera los métodos setter para los campos de la clase.

## Campos

- `id:` El ID único del usuario.
- `name:` El nombre del usuario.
- `email:` El correo electrónico del usuario.
- `birthdate:` La fecha de nacimiento del usuario.
- `role:` El rol del usuario.

## Uso

La clase `User` se utiliza para almacenar la información del usuario en la aplicación. Por ejemplo, al crear un nuevo usuario, se puede crear una instancia de `User` y guardarla en la base de datos.

```java
User user = User.builder()
        .name("Juan Pérez")
        .email("juan.perez@example.com")
        .birthdate(new Date())
        .role(RoleUser.user)
        .build();
```

## Notas

* La clase `User` no tiene métodos de negocio, es solo un modelo de datos.
* La clase `User` no tiene validaciones en este momento, es responsabilidad del desarrollador validar los datos antes de guardarlos en la base de datos.