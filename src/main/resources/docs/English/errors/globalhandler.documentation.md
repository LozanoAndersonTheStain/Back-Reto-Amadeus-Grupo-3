# Class GlobalExceptionHandler

## Description
The `GlobalExceptionHandler` class is a global exception handler that handles exceptions thrown by the application. It provides methods to handle specific exceptions and return appropriate HTTP responses.

## Annotations

- **@ControllerAdvice:** Spring annotation indicating that the class provides global exception handling for all controllers.

## Methods

- **`handleUserNotFoundException(UserNotFoundException ex)`**
    - **Description:** Handles `UserNotFoundException` and returns a `ResponseEntity` with a `NOT_FOUND` status.
    - **Parameters:**
        - `ex:` The `UserNotFoundException` to handle.
    - **Return:** `ResponseEntity<String>` with the exception message and `HttpStatus.NOT_FOUND`.


- **`handleInvalidUserDataException(InvalidUserDataException ex)`**
    - **Description:** Handles `InvalidUserDataException` and returns a `ResponseEntity` with a `BAD_REQUEST` status.
    - **Parameters:**
        - `ex:` The `InvalidUserDataException` to handle.
    - **Return:** `ResponseEntity<String>` with the exception message and `HttpStatus.BAD_REQUEST`.


- **`handleGeneralException(Exception ex)`**
    - **Description:** Handles general exceptions and returns a `ResponseEntity` with an `INTERNAL_SERVER_ERROR` status.
    - **Parameters:**
        - `ex:` The general `Exception` to handle.
    - **Return:** `ResponseEntity<String>` with a generic error message and `HttpStatus.INTERNAL_SERVER_ERROR`.

## Usage

The `GlobalExceptionHandler` class is used to handle exceptions globally in the application. For example, when a `UserNotFoundException` is thrown, the `handleUserNotFoundException` method is invoked to return a `NOT_FOUND` response.

```java
// Example of throwing a UserNotFoundException
throw new UserNotFoundException("User not found");
```

In this example, when the UserNotFoundException is thrown, the handleUserNotFoundException method of the GlobalExceptionHandler class is invoked to handle the exception and return a NOT_FOUND response.