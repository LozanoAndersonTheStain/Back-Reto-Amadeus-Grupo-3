# Clase ReportsModel

## Descripción
La clase `ReportsModel` es un modelo que representa un informe. Se utiliza para transferir datos entre diferentes capas de la aplicación.

## Anotaciones

- **@Data**: Anotación de Lombok que genera automáticamente los métodos getter y setter para los campos de la clase.
- **@NoArgsConstructor**: Anotación de Lombok que genera un constructor sin argumentos para la clase.
- **@AllArgsConstructor**: Anotación de Lombok que genera un constructor con todos los argumentos para la clase.
- **@Builder**: Anotación de Lombok que permite crear una instancia de la clase utilizando el patrón de diseño de constructor.
- **@Getter**: Anotación de Lombok que genera los métodos getter para los campos de la clase.
- **@Setter**: Anotación de Lombok que genera los métodos setter para los campos de la clase.

## Campos

- `id:` El identificador único del informe.
- `reportTime:` El tiempo cuando se creó el informe.
- `reportData:` Los datos contenidos en el informe.
- `user:` El usuario asociado con el informe.

## Uso

La clase `ReportsModel` se utiliza para transferir los datos del informe entre las diferentes capas de la aplicación. Puede ser utilizada en las clases de servicio y controlador para manejar la información del informe.

```java
ReportsModel reportsModel = ReportsModel.builder()
        .id(1L)
        .reportTime("2023-10-01T10:00:00")
        .reportData("Datos del informe de ejemplo")
        .user(new User(1L, "John Doe"))
        .build();

```

## Ejemplo de uso en un servicio

```java
@Service
public class ReportsService {

    public ReportsModel getReport(Long id) {
        // Recuperar información del informe desde la base de datos y devolver una instancia de ReportsModel
    }
}
```

En este ejemplo, el método `getReport` de `ReportsService` devuelve un objeto `ReportsModel` con la información del informe obtenida desde la base de datos.

## Ejemplo de uso en un controlador

```java
@RestController
@RequestMapping("/reports")
public class ReportsController {

    @GetMapping("/{id}")
    public ReportsModel getReport(@PathVariable Long id) {
        // Recuperar información del informe desde la base de datos y devolver una instancia de ReportsModel
    }
}
```

En este ejemplo, el método `getReport` de `ReportsController` devuelve un objeto `ReportsModel` con la información del informe obtenida desde la base de datos. El ID del informe se recibe como un parámetro en la URL de la solicitud GET.