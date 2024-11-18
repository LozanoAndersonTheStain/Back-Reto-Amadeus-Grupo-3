# Class UserNotFoundException

## Description
The `UserNotFoundException` class is a custom exception that is thrown when a user is not found in the database. It extends the `RuntimeException` class.

## Constructor

- **`UserNotFoundException(String message)`**
  - **Description:** Constructs a new `UserNotFoundException` with the specified detail message.
  - **Parameters:**
    - `message:` The detail message.

## Usage

The `UserNotFoundException` class is used to indicate that a user was not found in the database. For example, when retrieving a user by their ID, this exception can be thrown if the user does not exist.

```java
if (!userRepository.findById(id).isPresent()) {
    throw new UserNotFoundException("User with ID " + id + " not found");
}
```

In this example, if a user with the specified ID is not found in the database, a UserNotFoundException is thrown with a specific message.