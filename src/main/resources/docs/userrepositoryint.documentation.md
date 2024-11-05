# Interfaz UserRepository

## Descripción
La interfaz UserRepository es un repositorio que se utiliza para interactuar con la base de datos y realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) sobre la entidad UserEntity.

## ***Anotaciones***

- `@Repository:` anotación de Spring que indica que la interfaz es un repositorio.
- `JpaRepository:` interfaz de Spring Data JPA que proporciona métodos para realizar operaciones CRUD sobre la entidad.

## Métodos

- `findByEmail(String email):` método que busca un usuario por su correo electrónico y devuelve un Optional que contiene el usuario si se encuentra, o un Optional vacío si no se encuentra.

## Parámetros

- `email:` el correo electrónico del usuario que se busca.

## Retorno

`Optional<UserEntity>:` un Optional que contiene el usuario si se encuentra, o un Optional vacío si no se encuentra.

## Uso

La interfaz `UserRepository` se utiliza para interactuar con la base de datos y realizar operaciones CRUD sobre la entidad `UserEntity`. 
Por ejemplo, cuando se necesita buscar un usuario por su correo electrónico, se puede utilizar el método `findByEmail()`.