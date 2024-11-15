# Class User

## Description
The `User` class is a data model that represents a user in the application. It contains the necessary fields to store user information.

## Annotations

- `@Data:` Lombok annotation that automatically generates getter and setter methods for the class fields.
- `@NoArgsConstructor:` Lombok annotation that generates a no-argument constructor for the class.
- `@AllArgsConstructor:` Lombok annotation that generates an all-argument constructor for the class.
- `@Builder:` Lombok annotation that allows creating an instance of the class using the builder design pattern.
- `@Getter:` Lombok annotation that generates getter methods for the class fields.
- `@Setter:` Lombok annotation that generates setter methods for the class fields.

## Fields

- `id:` The unique ID of the user.
- `name:` The name of the user.
- `email:` The email of the user.
- `birthdate:` The birthdate of the user.
- `role:` The role of the user.

## Usage

The `User` class is used to store user information in the application. For example, when creating a new user, an instance of `User` can be created and saved in the database.

```java
User user = User.builder()
        .name("Juan Pérez")
        .email("juan.perez@example.com")
        .birthdate(new Date())
        .role(RoleUser.user)
        .build();
```

## Notas

* The User class does not have business methods, it is only a data model.
* The User class does not have validations at the moment, it is the developer's responsibility to validate the data before saving it to the database.