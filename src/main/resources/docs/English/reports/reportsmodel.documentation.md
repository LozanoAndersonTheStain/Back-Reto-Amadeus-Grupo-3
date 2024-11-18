# Class ReportsModel

## Description
The `ReportsModel` class is a model that represents a report. It is used to transfer data between different layers of the application.

## Annotations

- **@Data:** Lombok annotation that automatically generates getter and setter methods for the class fields.
- **@NoArgsConstructor:** Lombok annotation that generates a no-argument constructor for the class.
- **@AllArgsConstructor:** Lombok annotation that generates an all-argument constructor for the class.
- **@Builder:** Lombok annotation that allows creating an instance of the class using the builder design pattern.
- **@Getter:** Lombok annotation that generates getter methods for the class fields.
- **@Setter:** Lombok annotation that generates setter methods for the class fields.

## Fields

- `id:` The unique identifier of the report.
- `reportTime:` The time when the report was created.
- `reportData:` The data contained in the report.
- `user:` The user associated with the report.

## Usage

The `ReportsModel` class is used to transfer report data between different layers of the application. It can be used in service and controller classes to handle report information.

```java
ReportsModel reportsModel = ReportsModel.builder()
        .id(1L)
        .reportTime("2023-10-01T10:00:00")
        .reportData("Sample report data")
        .user(new User(1L, "John Doe"))
        .build();
```

## Example of usage in a service

```java
@Service
public class ReportsService {

    public ReportsModel getReport(Long id) {
        // Retrieve report information from the database and return an instance of ReportsModel
    }
}
```

In this example, the getReport method of the ReportsService returns a ReportsModel object with the report information obtained from the database.

## Example of usage in a controller

```java
@RestController
@RequestMapping("/reports")
public class ReportsController {

    @GetMapping("/{id}")
    public ReportsModel getReport(@PathVariable Long id) {
        // Retrieve report information from the database and return an instance of ReportsModel
    }
}
```

In this example, the getReport method of the ReportsController returns a ReportsModel object with the report information obtained from the database. The ID of the report is received as a parameter in the URL of the GET request.