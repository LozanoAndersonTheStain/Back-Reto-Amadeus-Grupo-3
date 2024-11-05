# UserMapper Implementation

## Descripción
La clase UserMapper es un mapeador que se utiliza para convertir entre diferentes objetos relacionados con usuarios. Proporciona métodos para mapear entre objetos de usuario, respuestas de usuario y solicitudes de usuario.

## Métodos

- `mapUserModelToUser()`
    - **Descripción:** Convierte un objeto de usuario (`User`) en un objeto de usuario (`User`) utilizando el patrón de diseño de constructor.
    - **Parámetros:*
      - `model:` objeto de usuario (`User`) que se va a convertir
    - **Retorno:** objeto de usuario (`User`) convertido

- `mapUserToUserModel()`
    - **Descripción:** Convierte un objeto de usuario (`User`) en un objeto de usuario (`User`) utilizando el patrón de diseño de constructor.
    - **Parámetros:**
      - `entity:` objeto de usuario (`User`) que se va a convertir
    - **Retorno:** objeto de usuario (`User`) convertido

- `mapUserToUserResponse()`
   - **Descripción:** Convierte un objeto de usuario (`User`) en una respuesta de usuario (`UserResponse`) utilizando el patrón de diseño de constructor.
   - **Parámetros:**
     - `model:` objeto de usuario (`User`) que se va a convertir
   - **Retorno:** respuesta de usuario (`UserResponse`) convertida

- `mapUserToUserRequest()`
   - **Descripción:** Convierte una solicitud de usuario (`UserRequest`) en una solicitud de usuario (`UserRequest`) utilizando el patrón de diseño de constructor.
   - **Parámetros:**
      - `userRequest:` solicitud de usuario (`UserRequest`) que se va a convertir
   - **Retorno:** solicitud de usuario (`UserRequest`) convertida

## Uso

La clase `UserMapper` se utiliza para convertir entre diferentes objetos relacionados con usuarios. Por ejemplo, cuando se necesita convertir un objeto de usuario en una respuesta de usuario, se puede utilizar el método `mapUserToUserResponse()`.

```java
User user = User.builder()
        .name("Juan Pérez")
        .email("juan.perez@example.com")
        .birthdate(new Date())
        .DNI("123456789")
        .build();

UserResponse userResponse = UserMapper.mapUserToUserResponse(user);
```

En este ejemplo, se crea un objeto de usuario (`User`) y se convierte en una respuesta de usuario (`UserResponse`) utilizando el método `mapUserToUserResponse()` de la clase `UserMapper`.

## Recomendaciones

* Asegúrate de que los métodos de la clase UserMapper sean consistentes con los campos de los objetos que se están convirtiendo.
* Utiliza la clase `UserMapper` para convertir entre objetos relacionados con usuarios en lugar de utilizar un mapa o una lista de parámetros.
* Asegúrate de que la clase `UserMapper` sea configurada correctamente en la aplicación para que se pueda acceder a sus métodos.