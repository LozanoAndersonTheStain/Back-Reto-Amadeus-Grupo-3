# Class UserRequest

## Description
The `UserRequest` class is a data transfer object (DTO) that represents a user request. It contains the necessary fields to create or update a user.

## Annotations

- **@Data:** Lombok annotation that automatically generates getter and setter methods for the class fields.
- **@NoArgsConstructor:** Lombok annotation that generates a no-argument constructor for the class.
- **@AllArgsConstructor:** Lombok annotation that generates an all-argument constructor for the class.
- **@Builder:** Lombok annotation that allows creating an instance of the class using the builder design pattern.
- **@JsonFormat:** Jackson annotation that specifies the format for date fields.

## Fields

- `name:` The name of the user.
- `email:` The email of the user.
- `birthdate:` The birthdate of the user, formatted as `yyyy-MM-dd`.
- `role:` The role of the user.

## Usage
The `UserRequest` class is used to send user data through the API. For example, when creating a new user, an instance of `UserRequest` can be created and passed as a parameter to the user creation method.

```java
UserRequest userRequest = UserRequest.builder()
        .name("Juan Pérez")
        .email("juan.perez@example.com")
        .birthdate(new Date())
        .role(RoleUser.USER)
        .build();
```

## Example of usage in a service

```java
@Service
public class UserService {

    public void createUser(UserRequest userRequest) {
        // Creates a new user in the database using the data from userRequest
    }
}
```

- In this example, the createUser method of the UserService receives a UserRequest object as a parameter and uses the data from the object to create a new user in the database.

## Ejemplo de uso en un controlador

```java
@RestController
@RequestMapping("/users")
public class UserController {

    @PostMapping
    public void createUser(@RequestBody UserRequest userRequest) {
        // Creates a new user in the database using the data from userRequest
    }
}
```

- In this example, the createUser method of the UserController receives a UserRequest object as a parameter and uses the data from the object to create a new user in the database.