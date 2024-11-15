# UserMapper Implementation

## Description
The `UserMapper` class is a mapper used to convert between different user-related objects. It provides methods to map between user objects, user responses, and user requests.

## Methods

- **`mapUserModelToUser()`**
    - **Description:** Converts a user object (`User`) to another user object (`User`) using the builder design pattern.
    - **Parameters:**
      - `model:` User object (`User`) to be converted
    - **Return:** Converted user object (`User`)

- **`mapUserToUserModel()`**
    - **Description:** Converts a user object (`User`) to another user object (`User`) using the builder design pattern.
    - **Parameters:**
      - `entity:` User object (`User`) to be converted
    - **Return:** Converted user object (`User`)

- **`mapUserToUserResponse()`**
   - **Description:** Converts a user object (`User`) to a user response (`UserResponse`) using the builder design pattern.
   - **Parameters:**
     - `model:` User object (`User`) to be converted
   - **Return:** Converted user response (`UserResponse`)

- **`mapUserToUserRequest()`**
   - **Description:** Converts a user request (`UserRequest`) to another user request (`UserRequest`) using the builder design pattern.
   - **Parameters:**
      - `userRequest:` User request (`UserRequest`) to be converted
   - **Return:** Converted user request (`UserRequest`)

## Usage

The `UserMapper` class is used to convert between different user-related objects. For example, when you need to convert a user object to a user response, you can use the `mapUserToUserResponse()` method.

```java
User user = User.builder()
        .name("Juan Pérez")
        .email("juan.perez@example.com")
        .birthdate(new Date())
        .DNI("123456789")
        .build();

UserResponse userResponse = UserMapper.mapUserToUserResponse(user);