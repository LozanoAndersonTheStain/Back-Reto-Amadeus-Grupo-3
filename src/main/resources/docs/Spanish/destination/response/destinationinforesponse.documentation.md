# Clase DestinationInfoResponse

## Descripción
La clase `DestinationInfoResponse` es un objeto de transferencia de datos (DTO) que representa una respuesta que contiene información sobre un destino. Contiene los campos necesarios para devolver información del destino a través de la API.

## Anotaciones

- **@Data:** Anotación de Lombok que genera automáticamente los métodos getter y setter para los campos de la clase.
- **@NoArgsConstructor:** Anotación de Lombok que genera un constructor sin argumentos para la clase.
- **@AllArgsConstructor:** Anotación de Lombok que genera un constructor con todos los argumentos para la clase.
- **@Builder:** Anotación de Lombok que permite crear una instancia de la clase utilizando el patrón de diseño de construcción (builder).

## Campos

- `nombreDestino:` El nombre del destino.
- `pais:` El país del destino.
- `idioma:` El idioma hablado en el destino.
- `lugarImperdible:` Un lugar imperdible en el destino.
- `comidaTipica:` La comida típica del destino.
- `img:` Una imagen representativa del destino.
- `continente:` El continente en el que se encuentra el destino.

## Uso

La clase `DestinationInfoResponse` se utiliza para devolver información sobre un destino a través de la API. Por ejemplo, cuando se realiza una solicitud GET para recuperar la información de un destino, se puede crear una instancia de `DestinationInfoResponse` y devolverla como respuesta.

```java
DestinationInfoResponse destinationInfoResponse = DestinationInfoResponse.builder()
        .nombreDestino("Medellín")
        .pais("Colombia")
        .idioma("Español")
        .lugarImperdible("Pueblito Paisa")
        .comidaTipica("Bandeja Paisa")
        .img("url_imagen")
        .continente("América del Sur")
        .build();
```

## Ejemplo de uso en un servicio

```java
@Service
public class DestinationService {

    public DestinationInfoResponse getDestinationInfo(String nombreDestino) {
        // Recupera la información del destino desde la base de datos y devuelve una instancia de DestinationInfoResponse
    }
}
```

En este ejemplo, el método `getDestinationInfo` de la clase `DestinationService` devuelve un objeto `DestinationInfoResponse` con la información del destino obtenida de la base de datos.

## Example of usage in a controller

```java
@RestController
@RequestMapping("/destinations")
public class DestinationController {

    @GetMapping("/{nombreDestino}")
    public DestinationInfoResponse getDestinationInfo(@PathVariable String nombreDestino) {
        // Recupera la información del destino desde la base de datos y devuelve una instancia de DestinationInfoResponse
    }
}
```

En este ejemplo, el método `getDestinationInfo` de la clase `DestinationController` devuelve un objeto `DestinationInfoResponse` con la información del destino obtenida de la base de datos. El nombre del destino se recibe como un parámetro en la URL de la solicitud GET.