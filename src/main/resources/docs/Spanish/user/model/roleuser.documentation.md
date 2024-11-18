# Enum RoleUser

## Descripción
El enum `RoleUser` representa los diferentes roles que un usuario puede tener en la aplicación. Se utiliza para definir y gestionar los roles de los usuarios.

## Valores

- `admin:` Representa a un usuario administrativo con privilegios elevados.
- `user:` Representa a un usuario regular con privilegios estándar.

## Uso

El enum `RoleUser` se puede utilizar para asignar y verificar los roles de los usuarios dentro de la aplicación.

```java
public enum RoleUser {
    admin,
    user
}
```

## Ejemplo de uso en una entidad de usuario

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

En este ejemplo, la clase `UserEntity` usa el enum `RoleUser` para definir el rol de un usuario.