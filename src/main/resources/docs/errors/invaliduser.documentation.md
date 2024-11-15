# Class InvalidUserDataException

## Description
The `InvalidUserDataException` class is a custom exception that is thrown when invalid user data is encountered. It extends the `RuntimeException` class.

## Constructor

- **`InvalidUserDataException(String message)`**
  - **Description:** Constructs a new `InvalidUserDataException` with the specified detail message.
  - **Parameters:**
    - `message:` The detail message.

## Usage

The `InvalidUserDataException` class is used to indicate that invalid user data has been encountered. For example, when validating user input, this exception can be thrown if the input is invalid.

```java
if (user.getEmail() == null || user.getEmail().isEmpty()) {
    throw new InvalidUserDataException("Email cannot be null or empty");
}
```
In this example, if the user's email is null or empty, an InvalidUserDataException is thrown with a specific message.