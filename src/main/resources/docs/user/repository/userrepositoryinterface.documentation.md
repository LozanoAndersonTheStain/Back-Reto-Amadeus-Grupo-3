# Interface UserRepository

## Description
The `UserRepository` interface is a repository used to interact with the database and perform CRUD (Create, Read, Update, Delete) operations on the `UserEntity` entity.

## Annotations

- **@Repository:** Spring annotation indicating that the interface is a repository.
- **JpaRepository:** Spring Data JPA interface providing methods to perform CRUD operations on the entity.

## Methods

- **`findByEmail(String email)`**
  - **Description:** Finds a user by their email and returns an `Optional` containing the user if found, or an empty `Optional` if not found.
  - **Parameters:**
    - `email:` The email of the user to find.
  - **Return:** `Optional<UserEntity>`

    
- **`findByNameAndEmail(String name, String email)`**
  - **Description:** Finds a user by their name and email and returns an `Optional` containing the user if found, or an empty `Optional` if not found.
  - **Parameters:**
    - `name:` The name of the user to find.
    - `email:` The email of the user to find.
  - **Return:** `Optional<UserEntity>`

## Usage

The `UserRepository` interface is used to interact with the database and perform CRUD operations on the `UserEntity` entity. For example, to find a user by their email, you can use the `findByEmail()` method.

```java
Optional<UserEntity> userEntityOptional = userRepository.findByEmail("juan.perez@example.com");
if (userEntityOptional.isPresent()) {
    UserEntity userEntity = userEntityOptional.get();
    System.out.println("User found: " + userEntity.getName());
} else {
    System.out.println("User not found");
}
```