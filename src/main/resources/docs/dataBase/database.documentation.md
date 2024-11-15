# Clase DataBaseConfig

### Descripción
La clase DataBaseConfig es responsable de configurar y establecer la conexión con la base de datos. Utiliza la biblioteca dotenv para cargar las propiedades de la base de datos desde un archivo .env.

## Métodos

- **`loadDatabaseProperties()`**
  - **Descripción:** Establece las propiedades de la base de datos en el sistema utilizando las variables de entorno definidas en el archivo .env.
  - **Parámetros:** Ninguno
  - **Retorno:** Ninguno
  
  Este método carga las propiedades de la base de datos desde el archivo .env y las establece como propiedades del sistema. Las propiedades cargadas son:

    - **DB_URL:** La URL de la base de datos
    - **DB_USERNAME:** El nombre de usuario para la base de datos
    - **DB_PASSWORD:** La contraseña para la base de datos

- **`getConnection()`**
  - **Descripción:** Establece una conexión con la base de datos utilizando las propiedades cargadas en el método loadDatabaseProperties().
  - **Parámetros:** Ninguno
  - **Retorno:** Una instancia de Connection que representa la conexión con la base de datos.
  Este método utiliza el método DriverManager.getConnection() para establecer una conexión con la base de datos. Si la conexión es exitosa, imprime un mensaje de confirmación en la consola. Si la conexión falla, imprime un mensaje de error en la consola.

## Manejo de errores

La clase DataBaseConfig maneja los errores de la siguiente manera:

Si la base de datos no existe, imprime un mensaje de error en la consola con la URL de la base de datos.
Si ocurre un error al establecer la conexión, imprime un mensaje de error en la consola con el mensaje de error.

## Uso
Para utilizar la clase DataBaseConfig, simplemente llama al método loadDatabaseProperties() para cargar las propiedades de la base de datos, y luego llama al método getConnection() para establecer una conexión con la base de datos.

```java
DataBaseConfig.loadDatabaseProperties();
Connection connection = DataBaseConfig.getConnection();
```

## **Recomendaciones**

* Asegúrate de que el archivo .env esté en el directorio raíz del proyecto y contenga las propiedades de la base de datos.
* Asegúrate de que la base de datos esté configurada correctamente y sea accesible desde la aplicación.
* Utiliza la clase DataBaseConfig para establecer la conexión con la base de datos en lugar de hacerlo manualmente.