# Class DestinoModel

## Description
The `DestinoModel` class is a model that represents a destination. It is used to transfer data between different layers of the application.

## Annotations

- **@Data:** Lombok annotation that automatically generates getter and setter methods for the class fields.
- **@NoArgsConstructor:** Lombok annotation that generates a no-argument constructor for the class.
- **@AllArgsConstructor:** Lombok annotation that generates an all-argument constructor for the class.
- **@Builder:** Lombok annotation that allows creating an instance of the class using the builder design pattern.
- **@Getter:** Lombok annotation that generates getter methods for the class fields.
- **@Setter:** Lombok annotation that generates setter methods for the class fields.

## Fields

- `id:` The unique identifier of the destination.
- `destino:` The name of the destination.
- `climatica:` The climate information of the destination.
- `actividad:` The activities available at the destination.
- `alojamiento:` The accommodation options at the destination.
- `viaje:` The travel information for the destination.
- `edad:` The age suitability for the destination.

## Usage

The `DestinoModel` class is used to transfer destination data between different layers of the application. It can be used in service and controller classes to handle destination information.

```java
DestinoModel destinoModel = DestinoModel.builder()
        .id(1L)
        .destino("Medellín")
        .climatica("Tropical")
        .actividad("Hiking")
        .alojamiento("Hotel")
        .viaje("Flight")
        .edad("All ages")
        .build();
```

## Example of usage in a service

```java
@Service
public class DestinoService {

    public DestinoModel getDestino(Long id) {
        // Retrieve destination information from the database and return an instance of DestinoModel
    }
}
```

In this example, the getDestino method of the DestinoService returns a DestinoModel object with the destination information obtained from the database.

## Example of usage in a controller

```java
@RestController
@RequestMapping("/destino")
public class DestinoController {

    @GetMapping("/{id}")
    public DestinoModel getDestino(@PathVariable Long id) {
        // Retrieve destination information from the database and return an instance of DestinoModel
    }
}
```

In this example, the getDestino method of the DestinoController returns a DestinoModel object with the destination information obtained from the database. The ID of the destination is received as a parameter in the URL of the GET request.
