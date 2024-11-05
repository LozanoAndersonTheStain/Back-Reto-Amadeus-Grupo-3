# Clase UserController

## Descripción
La clase UserController es un controlador de la API que maneja las solicitudes relacionadas con los usuarios. Proporciona métodos para listar usuarios, crear usuarios, autenticar usuarios y obtener un usuario por ID.

## ***Anotaciones***

- **@CrossOrigin(origins = "http://localhost:3000"):** Anotación que permite realizar solicitudes de origen cruzado desde la URL especificada.
- **@RestController:** Anotación que indica que la clase es un controlador de la API.
- **@RequestMapping("/api"):** Anotación que especifica la ruta base para las solicitudes que maneja el controlador.
- **@RequiredArgsConstructor:** Anotación de Lombok que genera un constructor con los parámetros finales de la clase.

# Campos
- `userService:` Instancia del servicio `UserService` que se utiliza para realizar operaciones con los usuarios.
- `userMapper:` Instancia del mapeador `UserMapper` que se utiliza para convertir entre objetos de usuario y respuestas de usuario.

## Métodos

* **`listarUsers()`**
    - **Descripción:** Devuelve una lista de respuestas de usuario que representan todos los usuarios en la base de datos.
    - **Parámetros:** Ninguno
    - **Retorno:** Lista de `UserResponse`


* **`crearUser()`**
    - **Descripción:** Crea un nuevo usuario en la base de datos y devuelve su ID.
    - **Parámetros:**
      - `name:` nombre del usuario
      - `email:` correo electrónico del usuario
      - `password:` contraseña del usuario
      - `birthdate:` fecha de nacimiento del usuario
      - `DNI:` número de identificación del usuario
    - Retorno: ID del usuario creado
      

* **`authenticate()`**
    - **Descripción:** Autentica un usuario en la base de datos y devuelve su respuesta de usuario si es válido.
    - **Parámetros:**
      - `email:` correo electrónico del usuario
      - `password:` contraseña del usuario
    - Retorno: `UserResponse` si el usuario es válido, null en caso contrario
      

* **`getUser()`**
    - **Descripción:** Devuelve la respuesta de usuario que representa el usuario con el ID especificado.
    - **Parámetros:**
      - `id:` ID del usuario
    - Retorno: `UserResponse`

## Uso

La clase UserController se utiliza para manejar las solicitudes de la API relacionadas con los usuarios. Por ejemplo, para crear un nuevo usuario, se puede realizar una solicitud POST a la ruta /api/create con los parámetros name, email, password, birthdate y DNI. Para autenticar un usuario, se puede realizar una solicitud POST a la ruta /api/authenticate con los parámetros email y password. Para obtener un usuario por ID, se puede realizar una solicitud GET a la ruta /api/user/{id}.

```java
curl -X POST \
  http://localhost:8080/api/create \
  -H 'Content-Type: application/json' \
  -d '{"name":"Juan Pérez","email":"juan.perez@example.com","password":"password123","birthdate":"1990-01-01","DNI":"123456789"}'
```

## Recomendaciones

* Asegúrate de que los parámetros de los métodos sean consistentes con los campos de la entidad de usuario en la base de datos.
* Utiliza la clase `UserController` para manejar las solicitudes de la API relacionadas con los usuarios en lugar de utilizar un controlador genérico.
* Asegúrate de que la clase `UserController` sea configurada correctamente en la aplicación para que se pueda acceder a sus métodos.