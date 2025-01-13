# Clase UserController

## Descripción
La clase `UserController` es un controlador API que maneja las solicitudes relacionadas con los usuarios. Proporciona métodos para listar usuarios, crear usuarios, autenticar usuarios, obtener un usuario por ID, actualizar usuarios y eliminar usuarios.

## Anotaciones

- **@RestController**: Indica que la clase es un controlador API.
- **@RequestMapping("/user")**: Especifica la ruta base para las solicitudes manejadas por el controlador.
- **@RequiredArgsConstructor**: Anotación de Lombok que genera un constructor con los campos finales de la clase.

## Campos

- `userService:` Instancia de `UserService` utilizada para realizar operaciones con los usuarios.
- `userMapper:` Instancia de `UserMapper` utilizada para convertir entre objetos de usuario y respuestas de usuario.

## Métodos

* **`listarUsers()`**
    - **Descripción:** Devuelve una lista de respuestas de usuarios representando todos los usuarios en la base de datos.
    - **Parámetros:** Ninguno
    - **Retorno:** Lista de `UserResponse`

* **`crearUser()`**
    - **Descripción:** Crea un nuevo usuario en la base de datos y devuelve su ID.
    - **Parámetros:**
        - `userRequest:` Objeto `UserRequest` que contiene los datos del usuario a crear.
    - **Retorno:** ID del usuario creado

* **`authenticate()`**
    - **Descripción:** Autentica a un usuario en la base de datos y devuelve su respuesta de usuario si es válido.
    - **Parámetros:**
        - `name:` Nombre del usuario
        - `email:` Correo electrónico del usuario
    - **Retorno:** Mapa con los datos del usuario autenticado y un indicador de éxito

* **`getUser()`**
    - **Descripción:** Devuelve la respuesta de usuario que representa al usuario con el ID especificado.
    - **Parámetros:**
        - `id:` ID del usuario
    - **Retorno:** `UserResponse`

* **`updateUser()`**
    - **Descripción:** Actualiza los datos de un usuario existente en la base de datos.
    - **Parámetros:**
        - `id:` ID del usuario a actualizar
        - `userRequest:` Objeto `UserRequest` que contiene los nuevos datos del usuario
    - **Retorno:** ID del usuario actualizado

* **`deleteUser()`**
    - **Descripción:** Elimina un usuario de la base de datos.
    - **Parámetros:**
        - `id:` ID del usuario a eliminar
    - **Retorno:** ID del usuario eliminado

## Uso

La clase `UserController` se utiliza para manejar las solicitudes API relacionadas con los usuarios. Por ejemplo, para crear un nuevo usuario, se puede realizar una solicitud POST a la ruta `/user/create` con los datos del usuario en el cuerpo de la solicitud. Para autenticar a un usuario, se puede realizar una solicitud POST a la ruta `/user/authenticate` con los parámetros `name` y `email`. Para obtener un usuario por ID, se puede realizar una solicitud GET a la ruta `/user/get/{id}`. Para actualizar un usuario, se puede realizar una solicitud PUT a la ruta `/user/update/{id}` con los nuevos datos del usuario en el cuerpo de la solicitud. Para eliminar un usuario, se puede realizar una solicitud DELETE a la ruta `/user/delete/{id}`.

```bash
curl -X POST \
  http://localhost:8080/user/create \
  -H 'Content-Type: application/json' \
  -d '{"name":"Juan Pérez","email":"juan.perez@example.com","birthdate":"1990-01-01"}'
```