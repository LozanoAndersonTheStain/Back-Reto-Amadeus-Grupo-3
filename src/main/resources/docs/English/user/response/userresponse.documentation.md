# Class UserResponse

## Description
The `UserResponse` class is a data transfer object (DTO) that represents a user response. It contains the necessary fields to return user information.

## Annotations

- **@Data:** Lombok annotation that automatically generates getter and setter methods for the class fields.
- **@NoArgsConstructor:** Lombok annotation that generates a no-argument constructor for the class.
- **@AllArgsConstructor:** Lombok annotation that generates an all-argument constructor for the class.
- **@Builder:** Lombok annotation that allows creating an instance of the class using the builder design pattern.

## Fields

- `id:` The unique ID of the user.
- `name:` The name of the user.
- `email:` The email of the user.
- `birthdate:` The birthdate of the user.
- `role:` The role of the user.

## Method `toString()`

The `toString()` method is used to return a string representation of the `UserResponse` instance. The string includes the values of the fields `id`, `name`, `email`, `birthdate`, and `role`.

## Usage

The `UserResponse` class is used to return user information through the API. For example, when a GET request is made to retrieve a user, an instance of `UserResponse` can be created and returned as the response.

```java
UserResponse userResponse = UserResponse.builder()
        .id(1L)
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

    public UserResponse getUser(Long id) {
        // Retrieve a user from the database and return an instance of UserResponse
    }
}
```

In this example, the `getUser` method of the `UserService` returns a `UserResponse` object with a user's information obtained from the database.
## Example of usage in a controller

```java
@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping("/{id}")
    public UserResponse getUser(@PathVariable Long id) {
        // Retrieve a user from the database and return an instance of UserResponse
    }
}
```

In this example, the `getUser` method of the `UserController` returns a `UserResponse` object with the information of a user obtained from the database. The user's ID is received as a parameter in the URL of the GET request.