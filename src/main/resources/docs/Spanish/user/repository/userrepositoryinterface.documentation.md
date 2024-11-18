# Interface UserRepository

## Descripción
La interfaz `UserRepository` es un repositorio utilizado para interactuar con la base de datos y realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) sobre la entidad `UserEntity`.

## Anotaciones

- **@Repository:** Anotación de Spring que indica que la interfaz es un repositorio.
- **JpaRepository:** Interfaz de Spring Data JPA que proporciona métodos para realizar operaciones CRUD sobre la entidad.

## Métodos

- **`findByEmail(String email)`**
  - **Descripción:** Busca un usuario por su correo electrónico y retorna un `Optional` que contiene al usuario si se encuentra, o un `Optional` vacío si no se encuentra.
  - **Parámetros:**
    - `email:` El correo electrónico del usuario a buscar.
  - **Retorno:** `Optional<UserEntity>`

- **`findByNameAndEmail(String name, String email)`**
  - **Descripción:** Busca un usuario por su nombre y correo electrónico, y retorna un `Optional` que contiene al usuario si se encuentra, o un `Optional` vacío si no se encuentra.
  - **Parámetros:**
    - `name:` El nombre del usuario a buscar.
    - `email:` El correo electrónico del usuario a buscar.
  - **Retorno:** `Optional<UserEntity>`

## Uso

La interfaz `UserRepository` se utiliza para interactuar con la base de datos y realizar operaciones CRUD sobre la entidad `UserEntity`. Por ejemplo, para encontrar un usuario por su correo electrónico, se puede usar el método `findByEmail()`.

```java
Optional<UserEntity> userEntityOptional = userRepository.findByEmail("juan.perez@example.com");
if (userEntityOptional.isPresent()) {
    UserEntity userEntity = userEntityOptional.get();
    System.out.println("User found: " + userEntity.getName());
} else {
    System.out.println("User not found");
}
```