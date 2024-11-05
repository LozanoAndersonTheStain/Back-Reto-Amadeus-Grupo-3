# Back Amadeus Grupo 3

## Descripción

Este proyecto es una aplicación backend desarrollada con Spring Boot que proporciona una API REST para gestionar usuarios. La aplicación incluye funcionalidades para crear, autenticar y listar usuarios.

## Estructura del Proyecto

El proyecto está estructurado de la siguiente manera:

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

## Configuración

### ***Variables de Entorno***

Asegúrate de configurar las siguientes variables de entorno en un archivo `.env`, este mismo debe estar ubicado en la raíz del proyecto:

```shell
DB_URL=jdbc:postgresql://localhost:5432/yourdatabase 
DB_USERNAME=yourusername 
DB_PASSWORD=yourpassword
```

## Dependencias

Las dependencias del proyecto están gestionadas por Gradle. Aquí están algunas de las principales dependencias utilizadas:

- **Spring Boot Starter**
- **Spring Boot Starter JDBC**
- **Spring Boot Starter Data JPA**
- **PostgreSQL Driver**
- **Hibernate ORM**
- **Lombok**
- **MapStruct**
- **Java Dotenv**

## Ejecución del Proyecto

### Requisitos Previos

- **Java 17**
- **Gradle**

## Construcción y Ejecución

Para construir y ejecutar el proyecto, utiliza los siguientes comandos:

```shell
./gradlew build
./gradlew bootRun
```

## Endpoints de la API

### ***Crear Usuario***

- **URL:** **`/api/create`**
- **Método:** **`POST`**

### ***Parámetros:***

- `name (String)`
- `email (String)`
- `password (String)`
- `birthdate (Date)`
- `DNI (String)`

### ***Autenticar Usuario***

- **URL:** `/api/authenticate`
- **Método:** `POST`

### ***Parámetros:***

- `email (String)`
- `password (String)`

### ***Listar Usuarios***

- **URL:** `/api/list`
- **Método:** `GET`

## Estructura del Código

## ***Configuración de la Base de Datos***

- **Archivo:** `DataBaseConfig.java`
- **Descripción:** Configura las propiedades de la base de datos utilizando variables de entorno y proporciona métodos para obtener una conexión a la base de datos.

## ***Entidades***

- **Archivo:** `UserEntity.java`
- **Descripción:** Define la entidad UserEntity que mapea a la tabla users en la base de datos.

## ***Repositorios***

- **Archivo:** `UserRepository.java`
- **Descripción:** Interfaz que extiende JpaRepository para realizar operaciones CRUD en la entidad UserEntity.

## ***Modelos***

- **Archivo:** `User.java`
- **Descripción:** Define el modelo User que se utiliza en la lógica de negocio.

## ***Contratos (Requests y Responses)***

- **Archivos:** `UserRequest.java` - `UserResponse.java`
- **Descripción:** Define las clases UserRequest y UserResponse para manejar las solicitudes y respuestas de la API.

## ***Mapeadores***

- **Archivos:** `interfaces/UserMapper.java` - `implementation/UserMapper.java`
- **Descripción:** Define los métodos para mapear entre *UserEntity*, *User*, *UserRequest* y *UserResponse*.

## ***Servicios***

- **Archivo:** `UserService.java`
- **Descripción:** Contiene la lógica de negocio para crear, autenticar y listar usuarios.

## ***Controladores***
- **Archivo:** `UserController.java`
- **Descripción:** Define los endpoints de la API para crear, autenticar y listar usuarios.

## ***Pruebas***
- **Archivo:** BackAmadeusGrupo3ApplicationTests.java
- **Descripción:** Asegúrate de que las pruebas unitarias estén configuradas y ejecutándose correctamente.

## ***Documentación***

**Archivo:** `README.md`
* En el proyecto se encuentra una carpeta llamada **`docs`** en la cual se encuentra una documentación más detallada de los archivos, su funcionalidad y más, esta se encuentra en la carpeta **`resources`**.

## **Instalación**

Para instalar el proyecto, sigue estos pasos:

1. Clona el repositorio en tu máquina local: Lo puedes hacer con la ruta https o ssh.

```shell
git clone https://github.com/LozanoAndersonTheStain/Back-Reto-Amadeus-Grupo-3.git
```

2. Configura las variables de entorno en un archivo `.env`.

3. Construye y ejecuta el proyecto con Gradle.

```shell
./gradlew build
./gradlew bootRun
```

4. Accede a la API REST utilizando Postman o cualquier otra herramienta de prueba de API.

5. ¡Listo! Ya puedes empezar a utilizar la aplicación.

## Contribuciones
Las contribuciones son bienvenidas. Para contribuir, sigue estos pasos:

Haz un fork del repositorio.
Crea una nueva rama:
   ```bash
   git checkout -b nombre-rama
   ```

Realiza tus cambios.
Haz un commit:
   ```bash
   git add .
   git commit -m "Comentario" 
   ```

Sube tus cambios:
   ```bash
   git push origin nombre-rama
   ```

Crea una solicitud de pull:
   ```bash
   git pull origin master
   ```
