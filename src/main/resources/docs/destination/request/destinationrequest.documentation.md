# Class DestinationRequest

## Description
The `DestinationRequest` class is a data transfer object (DTO) that represents a request for destination information. It contains the necessary fields to send destination information through the API.

## Annotations

- **@Data:** Lombok annotation that automatically generates getter and setter methods for the class fields.
- **@NoArgsConstructor:** Lombok annotation that generates a no-argument constructor for the class.
- **@AllArgsConstructor:** Lombok annotation that generates an all-argument constructor for the class.
- **@Builder:** Lombok annotation that allows creating an instance of the class using the builder design pattern.

## Fields

- `destino:` The name of the destination.
- `climatica:` The climate information of the destination.
- `actividad:` The activities available at the destination.
- `alojamiento:` The accommodation options at the destination.
- `viaje:` The travel information for the destination.
- `edad:` The age suitability for the destination.

## Usage

The `DestinationRequest` class is used to send destination information through the API. For example, when creating or updating destination information, an instance of `DestinationRequest` can be created and passed as a parameter to the corresponding method.

```java
DestinationRequest destinationRequest = DestinationRequest.builder()
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
public class DestinationService {

    public void createDestination(DestinationRequest destinationRequest) {
        // Creates a new destination in the database using the data from destinationRequest
    }
}
```

In this example, the createDestination method of the DestinationService receives a DestinationRequest object as a parameter and uses the data from the object to create a new destination in the database.

## Example of usage in a controller

```java
@RestController
@RequestMapping("/destinations")
public class DestinationController {

    @PostMapping
    public void createDestination(@RequestBody DestinationRequest destinationRequest) {
        // Creates a new destination in the database using the data from destinationRequest
    }
}
```

In this example, the createDestination method of the DestinationController receives a DestinationRequest object as a parameter and uses the data from the object to create a new destination in the database.