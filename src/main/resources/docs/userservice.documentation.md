# Clase UserService

## Descripción
La clase UserService es un servicio que se utiliza para interactuar con la entidad UserEntity y realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) sobre ella. También se utiliza para autenticar usuarios.

## ***Anotaciones***

- `@Service:` anotación de Spring que indica que la clase es un servicio.
- `@Autowired:` anotación de Spring que se utiliza para inyectar dependencias en la clase.

## Dependencias

- `UserRepository:` repositorio que se utiliza para interactuar con la base de datos y realizar operaciones CRUD sobre la entidad `UserEntity`.
- `UserMapper:` mapeador que se utiliza para convertir entre objetos de la entidad `UserEntity` y objetos de la clase `User`.

## Métodos

- `authenticate(UserRequest userRequest)`
    - **Descripción:** Autentica un usuario utilizando su correo electrónico, nombre, fecha de nacimiento y DNI.
    - **Parámetros:**
      - `userRequest:` objeto que contiene la información del usuario a autenticar.
    - **Retorno:** objeto `User` que representa el usuario autenticado, o `null` si no se encuentra.

- `create(User user)`
   - **Descripción:** Crea un nuevo usuario en la base de datos.
   - **Parámetros:**
     - `user:` objeto que contiene la información del usuario a crear.
   - **Retorno:** objeto `User` que representa el usuario creado.

- `findAll()`
  - **Descripción:** Obtiene una lista de todos los usuarios en la base de datos.
  - **Retorno:** lista de objetos `User` que representan los usuarios.

- `findById(Long id)`
   - **Descripción:** Obtiene un usuario por su ID.
   - **Parámetros:**
       - `id:` ID del usuario a obtener.
   - **Retorno:** objeto `User` que representa el usuario, o `null` si no se encuentra.

## Uso

La clase UserService se utiliza para interactuar con la entidad `UserEntity` y realizar operaciones CRUD sobre ella. También se utiliza para autenticar usuarios.

```java
UserService userService = new UserService();
User user = userService.authenticate(new UserRequest("juan.perez@example.com", "Juan Pérez", new Date(), "123456789"));
if (user != null) {
    System.out.println("Usuario autenticado: " + user.getName());
} else {
    System.out.println("Usuario no autenticado");
}
```

## Recomendaciones

* Asegúrate de que la clase `UserService` sea configurada correctamente en la aplicación para que se pueda acceder a sus métodos.
* Utiliza la clase `UserService` para interactuar con la entidad `UserEntity` y realizar operaciones CRUD sobre ella.
* Asegúrate de que los métodos de la clase UserService sean consistentes con los campos de la entidad `UserEntity`.

## Notas

* La clase `UserService` utiliza la anotación `@Service` para indicar que es un servicio.
* La clase `UserService` utiliza la anotación `@Autowired` para inyectar dependencias en la clase.
* La clase `UserService` utiliza el mapeador `UserMapper` para convertir entre objetos de la entidad `UserEntity` y objetos de la clase `User`.