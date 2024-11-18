# Class DestinoInfoModel

## Description
The `DestinoInfoModel` class is a model that represents detailed information about a destination. It is used to transfer data between different layers of the application.

## Annotations

- **@Data:** Lombok annotation that automatically generates getter and setter methods for the class fields.
- **@NoArgsConstructor:** Lombok annotation that generates a no-argument constructor for the class.
- **@AllArgsConstructor:** Lombok annotation that generates an all-argument constructor for the class.
- **@Builder:** Lombok annotation that allows creating an instance of the class using the builder design pattern.
- **@Getter:** Lombok annotation that generates getter methods for the class fields.
- **@Setter:** Lombok annotation that generates setter methods for the class fields.

## Fields

- `id:` The unique identifier of the destination information.
- `nombreDestino:` The name of the destination.
- `pais:` The country of the destination.
- `idioma:` The language spoken at the destination.
- `lugarImperdible:` A must-see place at the destination.
- `comidaTipica:` The typical food of the destination.
- `img:` An image representing the destination.
- `continente:` The continent where the destination is located.

## Usage

The `DestinoInfoModel` class is used to transfer detailed information about a destination between different layers of the application. It can be used in service and controller classes to handle destination information.

```java
DestinoInfoModel destinoInfoModel = DestinoInfoModel.builder()
        .id(1L)
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
public class DestinoInfoService {

    public DestinoInfoModel getDestinoInfo(Long id) {
        // Retrieve destination information from the database and return an instance of DestinoInfoModel
    }
}
```

In this example, the getDestinoInfo method of the DestinoInfoService returns a DestinoInfoModel object with the destination information obtained from the database.

## Example of usage in a controller

```java
@RestController
@RequestMapping("/destino-info")
public class DestinoInfoController {

    @GetMapping("/{id}")
    public DestinoInfoModel getDestinoInfo(@PathVariable Long id) {
        // Retrieve destination information from the database and return an instance of DestinoInfoModel
    }
}
```

In this example, the getDestinoInfo method of the DestinoInfoController returns a DestinoInfoModel object with the destination information obtained from the database. The ID of the destination is received as a parameter in the URL of the GET request.