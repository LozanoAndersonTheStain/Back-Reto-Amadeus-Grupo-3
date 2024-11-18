# Class UserService

## Description
The `UserService` class is a service used to interact with the `UserEntity` entity and perform CRUD (Create, Read, Update, Delete) operations on it. It is also used to authenticate users.

## Annotations

- **@Service:** Spring annotation indicating that the class is a service.
- **@Autowired:** Spring annotation used to inject dependencies into the class.

## Dependencies

- **UserRepository:** Repository used to interact with the database and perform CRUD operations on the `UserEntity` entity.
- **UserMapper:** Mapper used to convert between `UserEntity` objects and `User` objects.

## Methods

- **authenticate(UserRequest userRequest)**
    - **Description:** Authenticates a user using their email and name.
    - **Parameters:**
        - `userRequest:` Object containing the user's information to authenticate.
    - **Return:** `User` object representing the authenticated user, or throws `UserNotFoundException` if not found.


- **create(User user)**
    - **Description:** Creates a new user in the database.
    - **Parameters:**
        - `user:` Object containing the user's information to create.
    - **Return:** `User` object representing the created user, or throws `InvalidUserDataException` or `UserAlreadyExistsException`.


- **findAll()**
    - **Description:** Retrieves a list of all users in the database.
    - **Return:** List of `User` objects representing the users, or throws `UserNotFoundException` if no users are found.


- **findById(Long id)**
    - **Description:** Retrieves a user by their ID.
    - **Parameters:**
        - `id:` ID of the user to retrieve.
    - **Return:** `User` object representing the user, or throws `UserNotFoundException` if not found.


- **update(Long id, User user)**
    - **Description:** Updates an existing user in the database.
    - **Parameters:**
        - `id:` ID of the user to update.
        - `user:` Object containing the updated user's information.
    - **Return:** `User` object representing the updated user, or throws `UserNotFoundException` if not found.


- **delete(Long id)**
    - **Description:** Deletes a user by their ID.
    - **Parameters:**
        - `id:` ID of the user to delete.
    - **Return:** ID of the deleted user, or throws `UserNotFoundException` if not found.

## Usage

The `UserService` class is used to interact with the `UserEntity` entity and perform CRUD operations on it. It is also used to authenticate users.

```java
UserService userService = new UserService();
User user = userService.authenticate(new UserRequest("juan.perez@example.com", "Juan Pérez", new Date(), "123456789"));
if (user != null) {
    System.out.println("Authenticated user: " + user.getName());
} else {
    System.out.println("User not authenticated");
}
```

## Notes
* The UserService class uses the @Service annotation to indicate that it is a service.
* The UserService class uses the @Autowired annotation to inject dependencies into the class.
* The UserService class uses the UserMapper to convert between UserEntity objects and User objects.