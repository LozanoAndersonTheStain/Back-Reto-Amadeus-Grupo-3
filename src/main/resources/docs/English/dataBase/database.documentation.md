# DataBaseConfig Class

### Description
The `DataBaseConfig` class is responsible for configuring and establishing the connection to the database. It uses the `dotenv` library to load database properties from a `.env` file.

## Methods

- **`loadDatabaseProperties()`**
  - **Description:** Sets the database properties in the system using the environment variables defined in the `.env` file.
  - **Parameters:** None
  - **Return:** None

This method loads database properties from the `.env` file and sets them as system properties. The loaded properties are:
    - **DB_URL:** The database URL.
    - **DB_USERNAME:** The database username.
    - **DB_PASSWORD:** The database password.

- **`getConnection()`**
  - **Description:** Establishes a connection to the database using the properties loaded by the `loadDatabaseProperties()` method.
  - **Parameters:** None
  - **Return:** An instance of Connection representing the `database` connection.
    This method uses `DriverManager.getConnection()` to establish a connection to the database. If the connection is successful, it prints a confirmation message to the console. If the connection fails, it prints an error message to the console.

## Error Handling

The `DataBaseConfig` class handles errors as follows:

* If the database does not exist, it prints an error message to the console with the database URL.
* If an error occurs while establishing the connection, it prints an error message to the console with the error details.

## Uso
To use the `DataBaseConfig` class, simply call the `loadDatabaseProperties()` method to load the database properties, and then call the `getConnection()` method to establish a connection to the database.

```java
DataBaseConfig.loadDatabaseProperties();
Connection connection = DataBaseConfig.getConnection();
```

## **Recommendations**

* Ensure the `.env` file is located in the root directory of the project and contains the database properties.
* Verify that the database is correctly configured and accessible by the application.
* Use the `DataBaseConfig` class to establish the database connection instead of doing it manually.