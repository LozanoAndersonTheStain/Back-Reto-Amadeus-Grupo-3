# Class UserService

## Descripción
La clase `UserService` es un servicio utilizado para interactuar con la entidad `UserEntity` y realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) sobre ella. También se utiliza para autenticar a los usuarios.

## Anotaciones

- **@Service:** Anotación de Spring que indica que la clase es un servicio.
- **@Autowired:** Anotación de Spring utilizada para inyectar dependencias en la clase.

## Dependencias

- **UserRepository:** Repositorio utilizado para interactuar con la base de datos y realizar operaciones CRUD sobre la entidad `UserEntity`.
- **UserMapper:** Mapper utilizado para convertir entre los objetos `UserEntity` y `User`.

## Métodos

- **authenticate(UserRequest userRequest)**
    - **Descripción:** Autentica a un usuario utilizando su correo electrónico y nombre.
    - **Parámetros:**
        - `userRequest:` Objeto que contiene la información del usuario para autenticar.
    - **Retorno:** Objeto `User` que representa al usuario autenticado, o lanza `UserNotFoundException` si no se encuentra.

- **create(User user)**
    - **Descripción:** Crea un nuevo usuario en la base de datos.
    - **Parámetros:**
        - `user:` Objeto que contiene la información del usuario a crear.
    - **Retorno:** Objeto `User` que representa al usuario creado, o lanza `InvalidUserDataException` o `UserAlreadyExistsException`.

- **findAll()**
    - **Descripción:** Recupera una lista de todos los usuarios en la base de datos.
    - **Retorno:** Lista de objetos `User` que representan a los usuarios, o lanza `UserNotFoundException` si no se encuentran usuarios.

- **findById(Long id)**
    - **Descripción:** Recupera un usuario por su ID.
    - **Parámetros:**
        - `id:` ID del usuario a recuperar.
    - **Retorno:** Objeto `User` que representa al usuario, o lanza `UserNotFoundException` si no se encuentra.

- **update(Long id, User user)**
    - **Descripción:** Actualiza un usuario existente en la base de datos.
    - **Parámetros:**
        - `id:` ID del usuario a actualizar.
        - `user:` Objeto que contiene la información actualizada del usuario.
    - **Retorno:** Objeto `User` que representa al usuario actualizado, o lanza `UserNotFoundException` si no se encuentra.

- **delete(Long id)**
    - **Descripción:** Elimina un usuario por su ID.
    - **Parámetros:**
        - `id:` ID del usuario a eliminar.
    - **Retorno:** ID del usuario eliminado, o lanza `UserNotFoundException` si no se encuentra.

## Uso

La clase `UserService` se utiliza para interactuar con la entidad `UserEntity` y realizar operaciones CRUD sobre ella. También se utiliza para autenticar a los usuarios.

```java
UserService userService = new UserService();
User user = userService.authenticate(new UserRequest("juan.perez@example.com", "Juan Pérez", new Date(), "123456789"));
if (user != null) {
    System.out.println("Authenticated user: " + user.getName());
} else {
    System.out.println("User not authenticated");
}
```

## Notas

* La clase `UserService` utiliza la anotación @Service para indicar que es un servicio.
* La clase `UserService` utiliza la anotación @Autowired para inyectar dependencias en la clase.
* La clase `UserService` utiliza el `UserMapper` para convertir entre objetos `UserEntity` y `User`.