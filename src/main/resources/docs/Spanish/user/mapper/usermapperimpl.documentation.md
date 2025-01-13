# Implementación de UserMapper

## Descripción
La clase `UserMapper` es un mapeador utilizado para convertir entre diferentes objetos relacionados con usuarios. Proporciona métodos para mapear entre objetos de usuario, respuestas de usuario y solicitudes de usuario.

## Métodos

- **`mapUserModelToUser()`**
    - **Descripción:** Convierte un objeto de usuario (`User`) a otro objeto de usuario (`User`) utilizando el patrón de diseño builder.
    - **Parámetros:**
        - `model:` Objeto `User` que se va a convertir
    - **Retorno:** Objeto `User` convertido

- **`mapUserToUserModel()`**
    - **Descripción:** Convierte un objeto de usuario (`User`) a otro objeto de usuario (`User`) utilizando el patrón de diseño builder.
    - **Parámetros:**
        - `entity:` Objeto `User` que se va a convertir
    - **Retorno:** Objeto `User` convertido

- **`mapUserToUserResponse()`**
    - **Descripción:** Convierte un objeto de usuario (`User`) a una respuesta de usuario (`UserResponse`) utilizando el patrón de diseño builder.
    - **Parámetros:**
        - `model:` Objeto `User` que se va a convertir
    - **Retorno:** Respuesta de usuario (`UserResponse`) convertida

- **`mapUserToUserRequest()`**
    - **Descripción:** Convierte una solicitud de usuario (`UserRequest`) a otra solicitud de usuario (`UserRequest`) utilizando el patrón de diseño builder.
    - **Parámetros:**
        - `userRequest:` Solicitud de usuario (`UserRequest`) que se va a convertir
    - **Retorno:** Solicitud de usuario (`UserRequest`) convertida

## Uso

La clase `UserMapper` se utiliza para convertir entre diferentes objetos relacionados con usuarios. Por ejemplo, cuando necesitas convertir un objeto de usuario en una respuesta de usuario, puedes usar el método `mapUserToUserResponse()`.

```java
User user = User.builder()
        .name("Juan Pérez")
        .email("juan.perez@example.com")
        .birthdate(new Date())
        .DNI("123456789")
        .build();

UserResponse userResponse = UserMapper.mapUserToUserResponse(user);
```