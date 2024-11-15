# Class DestinationInfoResponse

## Description
The `DestinationInfoResponse` class is a data transfer object (DTO) that represents a response containing destination information. It contains the necessary fields to return destination information through the API.

## Annotations

- **@Data:** Lombok annotation that automatically generates getter and setter methods for the class fields.
- **@NoArgsConstructor:** Lombok annotation that generates a no-argument constructor for the class.
- **@AllArgsConstructor:** Lombok annotation that generates an all-argument constructor for the class.
- **@Builder:** Lombok annotation that allows creating an instance of the class using the builder design pattern.

## Fields

- `nombreDestino:` The name of the destination.
- `pais:` The country of the destination.
- `idioma:` The language spoken at the destination.
- `lugarImperdible:` A must-see place at the destination.
- `comidaTipica:` The typical food of the destination.
- `img:` An image representing the destination.
- `continente:` The continent where the destination is located.

## Usage

The `DestinationInfoResponse` class is used to return destination information through the API. For example, when a GET request is made to retrieve destination information, an instance of `DestinationInfoResponse` can be created and returned as the response.

```java
DestinationInfoResponse destinationInfoResponse = DestinationInfoResponse.builder()
        .nombreDestino("Medellín")
        .pais("Colombia")
        .idioma("Spanish")
        .lugarImperdible("Pueblito Paisa")
        .comidaTipica("Bandeja Paisa")
        .img("image_url")
        .continente("South America")
        .build();
```

## Example of usage in a service

```java
@Service
public class DestinationService {

    public DestinationInfoResponse getDestinationInfo(String nombreDestino) {
        // Retrieve destination information from the database and return an instance of DestinationInfoResponse
    }
}
```

In this example, the getDestinationInfo method of the DestinationService returns a DestinationInfoResponse object with the destination information obtained from the database.

## Example of usage in a controller

```java
@RestController
@RequestMapping("/destinations")
public class DestinationController {

    @GetMapping("/{nombreDestino}")
    public DestinationInfoResponse getDestinationInfo(@PathVariable String nombreDestino) {
        // Retrieve destination information from the database and return an instance of DestinationInfoResponse
    }
}
```

In this example, the getDestinationInfo method of the DestinationController returns a DestinationInfoResponse object with the destination information obtained from the database. The name of the destination is received as a parameter in the URL of the GET request.