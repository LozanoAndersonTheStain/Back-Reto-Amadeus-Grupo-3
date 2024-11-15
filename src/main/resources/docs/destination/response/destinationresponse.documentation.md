# Class DestinationResponse

## Description
The `DestinationResponse` class is a data transfer object (DTO) that represents a response containing destination information. It contains the necessary fields to return destination information through the API.

## Annotations

- **@Data:** Lombok annotation that automatically generates getter and setter methods for the class fields.
- **@NoArgsConstructor:** Lombok annotation that generates a no-argument constructor for the class.
- **@AllArgsConstructor:** Lombok annotation that generates an all-argument constructor for the class.
- **@Builder:** Lombok annotation that allows creating an instance of the class using the builder design pattern.

## Fields

- `nombreDestino:` The name of the destination.
- `descripcion:` A description of the destination.
- `ubicacion:` The location of the destination.
- `actividades:` A list of activities available at the destination.
- `mejorEpoca:` The best time to visit the destination.
- `imagen:` An image representing the destination.

## Usage

The `DestinationResponse` class is used to return destination information through the API. For example, when a GET request is made to retrieve destination information, an instance of `DestinationResponse` can be created and returned as the response.

```java
DestinationResponse destinationResponse = DestinationResponse.builder()
        .nombreDestino("Medellín")
        .descripcion("A vibrant city in Colombia known for its pleasant weather and friendly people.")
        .ubicacion("Colombia")
        .actividades(Arrays.asList("Hiking", "Museum visits", "City tours"))
        .mejorEpoca("December to March")
        .imagen("image_url")
        .build();
```

## Example of usage in a service

```java
@Service
public class DestinationService {

    public DestinationResponse getDestination(String nombreDestino) {
        // Retrieve destination information from the database and return an instance of DestinationResponse
    }
}
```

In this example, the getDestination method of the DestinationService returns a DestinationResponse object with the destination information obtained from the database.

## Example of usage in a controller

```java
@RestController
@RequestMapping("/destinations")
public class DestinationController {

    @GetMapping("/{nombreDestino}")
    public DestinationResponse getDestination(@PathVariable String nombreDestino) {
        // Retrieve destination information from the database and return an instance of DestinationResponse
    }
}
```

In this example, the getDestination method of the DestinationController returns a DestinationResponse object with the destination information obtained from the database. The name of the destination is received as a parameter in the URL of the GET request.