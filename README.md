# Back Amadeus Grupo 3

## Description

This project is a backend application developed with Spring Boot that provides a REST API for managing users. The application includes functionalities to create, authenticate, and list users.

## Project Structure

The project is structured as follows:

* `.env`
* `.gitignore`
* `.gradle/`
* `.idea/`
* `.vscode/`
* `build/`
* `build.gradle`
* `gradle/`
* `gradlew`
* `gradlew.bat`
* `README.md`
* `settings.gradle`
* `src/`
    + `main/`
        - `java/`
            - `com/`
                - `eafit/`
                    - `nodo/`
                        - `backamadeusgrupo3/`
                            - `configs/`
                            - `contracts/`
                            - `request/`
                            - `responses/`
                            - `controllers/`
                            - `entities/`
                            - `mappers/`
                            - `implementation/`
                            - `interfaces/`
                            - `models/`
                            - `repositories/`
                            - `services/`
        - `resources/`
    + `test/`
        - `java/`
            - `com/`
                - `eafit/`
                    - `nodo/`
                        - `backamadeusgrupo3/`

## Configuration

### Environment Variables

Make sure to configure the following environment variables in a `.env` file located at the root of the project:

```shell
# Database Configuration
DB_URL=jdbc:postgresql://localhost:5432/yourdatabase
DB_USERNAME=yourusername
DB_PASSWORD=yourpassword

# Google OAuth Configuration
GOOGLE_CLIENT_ID=your_google_client_id
GOOGLE_CLIENT_SECRET=your_google_client_secret
GOOGLE_SCOPE=https://www.googleapis.com/auth/gmail.send
GOOGLE_AUTHORIZATION_URI=https://accounts.google.com/o/oauth2/auth
GOOGLE_TOKEN_URI=https://oauth2.googleapis.com/token
GOOGLE_USER_INFO_URI=https://www.googleapis.com/oauth2/v3/userinfo
GOOGLE_USER_NAME_ATTRIBUTE=sub

# Email Configuration
MAIL_USERNAME=your_email@example.com
APP_PASSWORD=your_app_password
```

## Dependencies

The project dependencies are managed by Gradle. Here are some of the main dependencies used:

- **Spring Boot Starter**
- **Spring Boot Starter JDBC**
- **Spring Boot Starter Data JPA**
- **PostgreSQL Driver**
- **Hibernate ORM**
- **Lombok**
- **MapStruct**
- **Java Dotenv**

## Running the Project

### Prerequisites

- **Java 17**
- **Gradle**

## Build and Run

To build and run the project, use the following commands:

```shell
./gradlew build
./gradlew bootRun
```

## API Endpoints

### ***Create User***

- **URL:** **`/api/create`**
- **Method:** **`POST`**

### ***Parameters:***

- `name (String)`
- `email (String)`
- `password (String)`
- `birthdate (Date)`
- `DNI (String)`

### ***Authenticate User:***

- **URL:** `/api/authenticate`
- **Method:** `POST`

### ***Parameters:***

- `email (String)`
- `password (String)`

### ***List Users***

- **URL:** `/api/list`
- **Method:** `GET`

## Code Structure

## ***Database Configuration***

- **File:** `DataBaseConfig.java`
- **Description:** Configures the database properties using environment variables and provides methods to obtain a database connection.

## ***Entities***

- **File:** `UserEntity.java`
- **Description:** Defines the UserEntity that maps to the users table in the database.

## ***Repositories***

- **File:** `UserRepository.java`
- **Description:** IInterface extending JpaRepository to perform CRUD operations on the UserEntity.

## ***Models***

- **File:** `User.java`
- **Description:** Defines the User model used in the business logic.

## ***Contracts (Requests and Responses)***

- **File:** `UserRequest.java` - `UserResponse.java`
- **Description:** Defines the UserRequest and UserResponse classes to handle API requests and responses.

## ***Mappers***

- **File:** `interfaces/UserMapper.java` - `implementation/UserMapper.java`
- **Description:** Defines methods to map between UserEntity, User, UserRequest, and UserResponse.

## ***Services***

- **File:** `UserService.java`
- **Description:** Contains the business logic to create, authenticate, and list users.

## ***Controladores***
- **File:** `UserController.java`
- **Description:** Defines the API endpoints to create, authenticate, and list users.

## ***Tests***
- **File:** BackAmadeusGrupo3ApplicationTests.java
- **Description:** Ensure that unit tests are configured and running correctly.

## ***Documentation***

**File:** `README.md`
* The project includes a folder named docs which contains more detailed documentation of the files, their functionality, and more. This is located in the resources folder.

## **Installation**

To install the project, follow these steps:

1. Clone the repository to your local machine: You can do this with the HTTPS or SSH URL.

    ```shell
      git clone https://github.com/LozanoAndersonTheStain/Back-Reto-Amadeus-Grupo-3.git
    ```

2. Configure the environment variables in a `.env` file.

3. Build and run the project with Gradle.

    ```shell
    ./gradlew build
    ./gradlew bootRun
    ```

4. Access the REST API using Postman or any other API testing tool.

5. Done! You can now start using the application.

## Contributions
Contributions are welcome. To contribute, follow these steps:

1. Fork the repository.
2. Create a new branch:
   ```bash
   git checkout -b nombre-rama
   ```

3. Make your changes.
4. Commit your changes:
   ```bash
   git add .
   git commit -m "Comment" 
   ```

5. Push your changes:
   ```bash
   git push origin nombre-rama
   ```

6. Create a pull request: Describe your changes and submit your pull request.
   ```bash
   git pull origin master
   ```
