# UserMapper Interface

## Descripción
La interfaz UserMapper es un mapeador que se utiliza para convertir entre diferentes objetos relacionados con usuarios. Proporciona métodos para mapear entre objetos de usuario, respuestas de usuario, solicitudes de usuario y entidades de usuario.

## ***Anotaciones***

- `@Mapper(componentModel = "spring"):` anotación de MapStruct que indica que la interfaz es un mapeador y que se utiliza el modelo de componente Spring.

## Métodos

- `mapUserRequestToUserEntity()`
  - **Descripción:** Convierte una solicitud de usuario (`UserRequest`) en una entidad de usuario (`UserEntity`).
  - **Parámetros:**
     - `userRequest:` solicitud de usuario (`UserRequest`) que se va a convertir
  - **Retorno:** entidad de usuario (`UserEntity`) convertida

- `mapUserEntityToUser()`
  - **Descripción:** Convierte una entidad de usuario (`UserEntity`) en un objeto de usuario (`User`).
  - **Parámetros:**
        - `userEntity:` entidad de usuario (`UserEntity`) que se va a convertir
  - **Retorno:** objeto de usuario (`User`) convertido

- `mapUserRequestToUser()`
  - **Descripción:** Convierte una solicitud de usuario (`UserRequest`) en un objeto de usuario (`User`).
  - **Parámetros:**
    - **userRequest:** solicitud de usuario (`UserRequest`) que se va a convertir
  - **Retorno:** objeto de usuario (`User`) convertido

- `mapUserToUserRequest()`
  - **Descripción:** Convierte un objeto de usuario (`User`) en una solicitud de usuario (`UserReques`).
  - **Parámetros:**
    - `user:` objeto de usuario (`User`) que se va a convertir
  - **Retorno:* solicitud de usuario (`UserRequest`) convertida

- `mapUserToUserResponse()`
  - **Descripción:** Convierte un objeto de usuario (`User`) en una respuesta de usuario (`UserResponse`).
  - **Parámetros:**
    - `user:` objeto de usuario (`User`) que se va a convertir
  - **Retorno:** respuesta de usuario (`UserResponse`) convertida

    - `mapUserModelListToUserResponseList()`
    - **Descripción:** Convierte una lista de objetos de usuario (`List<User>`) en una lista de respuestas de usuario (`List<UserResponse>`).
    - **Parámetros:**
      - `users:` lista de objetos de usuario (`List<User>`) que se va a convertir
    - **Retorno:** lista de respuestas de usuario (`List<UserResponse>`) convertida

## Uso

La interfaz `UserMapper` se utiliza para convertir entre diferentes objetos relacionados con usuarios. Por ejemplo, cuando se necesita convertir una solicitud de usuario en una entidad de usuario, se puede utilizar el método `mapUserRequestToUserEntity()`.

```java
UserRequest userRequest = UserRequest.builder()
        .name("Juan Pérez")
        .email("juan.perez@example.com")
        .birthdate(new Date())
        .DNI("123456789")
        .build();

UserEntity userEntity = UserMapper.mapUserRequestToUserEntity(userRequest);
```
De manera similar, cuando se necesita convertir un objeto de usuario en una respuesta de usuario, se puede utilizar el método `mapUserToUserResponse()`.

Recomendaciones

* Asegúrate de que los métodos de la interfaz `UserMapper` sean consistentes con los campos de los objetos que se están convirtiendo.
* Utiliza la interfaz `UserMapper` para convertir entre objetos relacionados con usuarios en lugar de utilizar un mapa o una lista de parámetros.
* Asegúrate de que la interfaz `UserMapper` sea configurada correctamente en la aplicación para que se pueda acceder a sus métodos.