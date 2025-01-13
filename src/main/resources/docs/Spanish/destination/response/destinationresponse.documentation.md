# Clase DestinationResponse

## Descripción
La clase `DestinationResponse` es un objeto de transferencia de datos (DTO) que representa una respuesta que contiene información sobre un destino. Contiene los campos necesarios para devolver información del destino a través de la API.

## Anotaciones

- **@Data:** Anotación de Lombok que genera automáticamente los métodos getter y setter para los campos de la clase.
- **@NoArgsConstructor:** Anotación de Lombok que genera un constructor sin argumentos para la clase.
- **@AllArgsConstructor:** Anotación de Lombok que genera un constructor con todos los argumentos para la clase.
- **@Builder:** Anotación de Lombok que permite crear una instancia de la clase utilizando el patrón de diseño de construcción (builder).

## Campos

- `nombreDestino:` El nombre del destino.
- `descripcion:` Una descripción del destino.
- `ubicacion:` La ubicación del destino.
- `actividades:` Una lista de actividades disponibles en el destino.
- `mejorEpoca:` La mejor época para visitar el destino.
- `imagen:` Una imagen representativa del destino.

## Uso

La clase `DestinationResponse` se utiliza para devolver información sobre un destino a través de la API. Por ejemplo, cuando se realiza una solicitud GET para recuperar la información de un destino, se puede crear una instancia de `DestinationResponse` y devolverla como respuesta.

```java
DestinationResponse destinationResponse = DestinationResponse.builder()
        .nombreDestino("Medellín")
        .descripcion("Una ciudad vibrante en Colombia conocida por su clima agradable y gente amigable.")
        .ubicacion("Colombia")
        .actividades(Arrays.asList("Senderismo", "Visitas a museos", "Recorridos por la ciudad"))
        .mejorEpoca("De diciembre a marzo")
        .imagen("url_imagen")
        .build();

```

## Ejemplo de uso en un servicio

```java
@Service
public class DestinationService {

    public DestinationResponse getDestination(String nombreDestino) {
        // Recupera la información del destino desde la base de datos y devuelve una instancia de DestinationResponse
    }
}
```
En este ejemplo, el método `getDestination` de la clase `DestinationService` devuelve un objeto `DestinationResponse` con la información del destino obtenida de la base de datos.

## Ejemplo de uso en un controlador

```java
@RestController
@RequestMapping("/destinations")
public class DestinationController {

    @GetMapping("/{nombreDestino}")
    public DestinationResponse getDestination(@PathVariable String nombreDestino) {
        // Recupera la información del destino desde la base de datos y devuelve una instancia de DestinationResponse
    }
}
```

En este ejemplo, el método `getDestination` de la clase `DestinationController` devuelve un objeto `DestinationResponse` con la información del destino obtenida de la base de datos. El nombre del destino se recibe como un parámetro en la URL de la solicitud GET.