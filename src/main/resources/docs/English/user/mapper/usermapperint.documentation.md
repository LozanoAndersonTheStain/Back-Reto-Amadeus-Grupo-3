# UserMapper Interface

## Description
The `UserMapper` interface is a mapper used to convert between different user-related objects. It provides methods to map between user objects, user responses, user requests, and user entities.

## Annotations

- `@Mapper(componentModel = "spring"):` MapStruct annotation indicating that the interface is a mapper and uses the Spring component model.

## Methods

- `mapUserRequestToUserEntity()`
  - **Description:** Converts a user request (`UserRequest`) to a user entity (`UserEntity`).
  - **Parameters:**
     - `userRequest:` User request (`UserRequest`) to be converted
  - **Return:** Converted user entity (`UserEntity`)


- `mapUserToUserEntity()`
  - **Description:** Converts a user object (`User`) to a user entity (`UserEntity`).
  - **Parameters:**
     - `user:` User object (`User`) to be converted
  - **Return:** Converted user entity (`UserEntity`)


- `mapUserEntityToUser()`
  - **Description:** Converts a user entity (`UserEntity`) to a user object (`User`).
  - **Parameters:**
     - `userEntity:` User entity (`UserEntity`) to be converted
  - **Return:** Converted user object (`User`)


- `mapUserRequestToUser()`
  - **Description:** Converts a user request (`UserRequest`) to a user object (`User`).
  - **Parameters:**
     - `userRequest:` User request (`UserRequest`) to be converted
  - **Return:** Converted user object (`User`)


- `mapUserToUserRequest()`
  - **Description:** Converts a user object (`User`) to a user request (`UserRequest`).
  - **Parameters:**
     - `user:` User object (`User`) to be converted
  - **Return:** Converted user request (`UserRequest`)


- `mapUserToUserResponse()`
  - **Description:** Converts a user object (`User`) to a user response (`UserResponse`).
  - **Parameters:**
     - `user:` User object (`User`) to be converted
  - **Return:** Converted user response (`UserResponse`)


- `mapUserModelListToUserResponseList()`
  - **Description:** Converts a list of user objects (`List<User>`) to a list of user responses (`List<UserResponse>`).
  - **Parameters:**
     - `users:` List of user objects (`List<User>`) to be converted
  - **Return:** Converted list of user responses (`List<UserResponse>`)

## Usage

The `UserMapper` interface is used to convert between different user-related objects. For example, when you need to convert a user request to a user entity, you can use the `mapUserRequestToUserEntity()` method.

```java
UserRequest userRequest = UserRequest.builder()
        .name("Juan Pérez")
        .email("juan.perez@example.com")
        .birthdate(new Date())
        .DNI("123456789")
        .build();

UserEntity userEntity = UserMapper.mapUserRequestToUserEntity(userRequest);
```
Similarly, when you need to convert a user object to a user response, you can use the mapUserToUserResponse() method.

