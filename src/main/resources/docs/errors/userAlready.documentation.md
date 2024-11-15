# Class UserAlreadyExistsException

## Description
The `UserAlreadyExistsException` class is a custom exception that is thrown when a user already exists in the database. It extends the `RuntimeException` class.

## Constructor

- **`UserAlreadyExistsException(String message)`**
  - **Description:** Constructs a new `UserAlreadyExistsException` with the specified detail message.
  - **Parameters:**
    - `message:` The detail message.

## Usage

The `UserAlreadyExistsException` class is used to indicate that a user already exists in the database. For example, when creating a new user, this exception can be thrown if the user already exists.

```java
if (userRepository.findByEmail(user.getEmail()).isPresent()) {
    throw new UserAlreadyExistsException("User with email " + user.getEmail() + " already exists");
}
```

In this example, if a user with the specified email already exists in the database, a UserAlreadyExistsException is thrown with a specific message.