# Class UserQuerysModel

## Description
The `UserQuerysModel` class is a model that represents a user's query. It is used to transfer data between different layers of the application.

## Annotations

- **@Data:** Lombok annotation that automatically generates getter and setter methods for the class fields.
- **@NoArgsConstructor:** Lombok annotation that generates a no-argument constructor for the class.
- **@AllArgsConstructor:** Lombok annotation that generates an all-argument constructor for the class.
- **@Builder:** Lombok annotation that allows creating an instance of the class using the builder design pattern.
- **@Getter:** Lombok annotation that generates getter methods for the class fields.
- **@Setter:** Lombok annotation that generates setter methods for the class fields.

## Fields

- `id:` The unique identifier of the user's query.
- `query:` The query string.
- `queryTime:` The time when the query was made.
- `queryData:` The data associated with the query.
- `user:` The user associated with the query.

## Usage

The `UserQuerysModel` class is used to transfer user query data between different layers of the application. It can be used in service and controller classes to handle user query information.

```java
UserQuerysModel userQuerysModel = UserQuerysModel.builder()
        .id(1L)
        .query("Sample query")
        .queryTime("2023-10-01T10:00:00")
        .queryData("Sample query data")
        .user(new User(1L, "John Doe"))
        .build();
```

## Example of usage in a service

```java
@Service
public class UserQuerysService {

    public UserQuerysModel getUserQuery(Long id) {
        // Retrieve user query information from the database and return an instance of UserQuerysModel
    }
}
```

In this example, the getUserQuery method of the UserQuerysService returns a UserQuerysModel object with the user query information obtained from the database.

## Example of usage in a controller

```java
@RestController
@RequestMapping("/user-querys")
public class UserQuerysController {

    @GetMapping("/{id}")
    public UserQuerysModel getUserQuery(@PathVariable Long id) {
        // Retrieve user query information from the database and return an instance of UserQuerysModel
    }
}
```

In this example, the getUserQuery method of the UserQuerysController returns a UserQuerysModel object with the user query information obtained from the database. The ID of the user query is received as a parameter in the URL of the GET request.