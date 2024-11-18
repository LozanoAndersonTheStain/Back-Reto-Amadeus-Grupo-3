# Enum RoleUser

## Description
The `RoleUser` enum represents the different roles a user can have in the application. It is used to define and manage user roles.

## Values

- `admin:` Represents an administrative user with elevated privileges.
- `user:` Represents a regular user with standard privileges.

## Usage

The `RoleUser` enum can be used to assign and check user roles within the application.

```java
public enum RoleUser {
    admin,
    user
}
```

## Example of usage in a user entity

```java
@Entity
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RoleUser role;

    // Getters and setters
}
```

In this example, the UserEntity class uses the RoleUser enum to define the role of a user.