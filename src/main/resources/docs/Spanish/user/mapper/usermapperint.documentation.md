# Interfaz de UserMapper

## Descripción
La interfaz `UserMapper` es un mapeador utilizado para convertir entre diferentes objetos relacionados con usuarios. Proporciona métodos para mapear entre objetos de usuario, respuestas de usuario, solicitudes de usuario y entidades de usuario.

## Annotations

- `@Mapper(componentModel = "spring"):` Anotación de MapStruct que indica que la interfaz es un mapeador y usa el modelo de componente Spring.

## Métodos

- `mapUserRequestToUserEntity()`
    - **Descripción:** Convierte una solicitud de usuario (`UserRequest`) a una entidad de usuario (`UserEntity`).
    - **Parámetros:**
        - `userRequest:` Solicitud de usuario (`UserRequest`) que se va a convertir
    - **Retorno:** Entidad de usuario (`UserEntity`) convertida

- `mapUserToUserEntity()`
    - **Descripción:** Convierte un objeto de usuario (`User`) a una entidad de usuario (`UserEntity`).
    - **Parámetros:**
        - `user:` Objeto de usuario (`User`) que se va a convertir
    - **Retorno:** Entidad de usuario (`UserEntity`) convertida

- `mapUserEntityToUser()`
    - **Descripción:** Convierte una entidad de usuario (`UserEntity`) a un objeto de usuario (`User`).
    - **Parámetros:**
        - `userEntity:` Entidad de usuario (`UserEntity`) que se va a convertir
    - **Retorno:** Objeto de usuario (`User`) convertido

- `mapUserRequestToUser()`
    - **Descripción:** Convierte una solicitud de usuario (`UserRequest`) a un objeto de usuario (`User`).
    - **Parámetros:**
        - `userRequest:` Solicitud de usuario (`UserRequest`) que se va a convertir
    - **Retorno:** Objeto de usuario (`User`) convertido

- `mapUserToUserRequest()`
    - **Descripción:** Convierte un objeto de usuario (`User`) a una solicitud de usuario (`UserRequest`).
    - **Parámetros:**
        - `user:` Objeto de usuario (`User`) que se va a convertir
    - **Retorno:** Solicitud de usuario (`UserRequest`) convertida

- `mapUserToUserResponse()`
    - **Descripción:** Convierte un objeto de usuario (`User`) a una respuesta de usuario (`UserResponse`).
    - **Parámetros:**
        - `user:` Objeto de usuario (`User`) que se va a convertir
    - **Retorno:** Respuesta de usuario (`UserResponse`) convertida

- `mapUserModelListToUserResponseList()`
    - **Descripción:** Convierte una lista de objetos de usuario (`List<User>`) a una lista de respuestas de usuario (`List<UserResponse>`).
    - **Parámetros:**
        - `users:` Lista de objetos de usuario (`List<User>`) que se van a convertir
    - **Retorno:** Lista de respuestas de usuario (`List<UserResponse>`) convertida

## Uso

La interfaz `UserMapper` se utiliza para convertir entre diferentes objetos relacionados con usuarios. Por ejemplo, cuando necesitas convertir una solicitud de usuario en una entidad de usuario, puedes usar el método `mapUserRequestToUserEntity()`.

```java
UserRequest userRequest = UserRequest.builder()
        .name("Juan Pérez")
        .email("juan.perez@example.com")
        .birthdate(new Date())
        .DNI("123456789")
        .build();

UserEntity userEntity = UserMapper.mapUserRequestToUserEntity(userRequest);
```