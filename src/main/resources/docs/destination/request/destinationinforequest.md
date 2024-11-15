# Class DestinationInfoRequest

## Description
The `DestinationInfoRequest` class is a data transfer object (DTO) that represents a request for destination information. It contains the necessary fields to send destination information through the API.

## Annotations

- **@Data:** Lombok annotation that automatically generates getter and setter methods for the class fields.
- **@NoArgsConstructor:** Lombok annotation that generates a no-argument constructor for the class.
- **@AllArgsConstructor:** Lombok annotation that generates an all-argument constructor for the class.

## Fields

- `nombreDestino:` The name of the destination.
- `destinoInfoEntities:` A list of `DestinationInfoEntity` objects representing detailed information about the destination.

## Usage

The `DestinationInfoRequest` class is used to send destination information through the API. For example, when creating or updating destination information, an instance of `DestinationInfoRequest` can be created and passed as a parameter to the corresponding method.

```java
DestinationInfoRequest destinationInfoRequest = new DestinationInfoRequest();
destinationInfoRequest.setNombreDestino("Medellín");
destinationInfoRequest.setDestinoInfoEntities(destinationInfoEntitiesList);
```

## Example of usage in a service

```java
@Service
public class DestinationService {

    public void createDestination(DestinationInfoRequest destinationInfoRequest) {
        // Creates a new destination in the database using the data from destinationInfoRequest
    }
}
```

In this example, the createDestination method of the DestinationService receives a DestinationInfoRequest object as a parameter and uses the data from the object to create a new destination in the database.

## Example of usage in a controller

```java
@RestController
@RequestMapping("/destinations")
public class DestinationController {

    @PostMapping
    public void createDestination(@RequestBody DestinationInfoRequest destinationInfoRequest) {
        // Creates a new destination in the database using the data from destinationInfoRequest
    }
}
```

In this example, the createDestination method of the DestinationController receives a DestinationInfoRequest object as a parameter and uses the data from the object to create a new destination in the database.