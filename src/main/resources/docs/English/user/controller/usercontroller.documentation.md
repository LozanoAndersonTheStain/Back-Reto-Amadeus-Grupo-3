# Class UserController

## Description
The `UserController` class is an API controller that handles user-related requests. It provides methods to list users, create users, authenticate users, get a user by ID, update users, and delete users.

## Annotations

- **@RestController:** Indicates that the class is an API controller.
- **@RequestMapping("/user"):** Specifies the base path for the requests handled by the controller.
- **@RequiredArgsConstructor:** Lombok annotation that generates a constructor with the final fields of the class.

## Fields

- `userService:` Instance of the `UserService` used to perform operations with users.
- `userMapper:` Instance of the `UserMapper` used to convert between user objects and user responses.

## Methods

* **`listarUsers()`**
    - **Description:** Returns a list of user responses representing all users in the database.
    - **Parameters:** None
    - **Return:** List of `UserResponse`

* **`crearUser()`**
    - **Description:** Creates a new user in the database and returns its ID.
    - **Parameters:**
        - `userRequest:` `UserRequest` object containing the user's data to create.
    - **Return:** ID of the created user

* **`authenticate()`**
    - **Description:** Authenticates a user in the database and returns their user response if valid.
    - **Parameters:**
        - `name:` User's name
        - `email:` User's email
    - **Return:** Map with the authenticated user's data and a success indicator

* **`getUser()`**
    - **Description:** Returns the user response representing the user with the specified ID.
    - **Parameters:**
        - `id:` User's ID
    - **Return:** `UserResponse`

* **`updateUser()`**
    - **Description:** Updates the data of an existing user in the database.
    - **Parameters:**
        - `id:` ID of the user to update
        - `userRequest:` `UserRequest` object containing the user's new data
    - **Return:** ID of the updated user

* **`deleteUser()`**
    - **Description:** Deletes a user from the database.
    - **Parameters:**
        - `id:` ID of the user to delete
    - **Return:** ID of the deleted user

## Usage

The `UserController` class is used to handle API requests related to users. For example, to create a new user, a POST request can be made to the `/user/create` path with the user's data in the request body. To authenticate a user, a POST request can be made to the `/user/authenticate` path with the `name` and `email` parameters. To get a user by ID, a GET request can be made to the `/user/get/{id}` path. To update a user, a PUT request can be made to the `/user/update/{id}` path with the user's new data in the request body. To delete a user, a DELETE request can be made to the `/user/delete/{id}` path.

`````bash
curl -X POST \
  http://localhost:8080/user/create \
  -H 'Content-Type: application/json' \
  -d '{"name":"Juan Pérez","email":"juan.perez@example.com","birthdate":"1990-01-01"}'
`````