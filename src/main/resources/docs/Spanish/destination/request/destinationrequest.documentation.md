# Clase DestinationRequest

## Descripción
La clase `DestinationRequest` es un objeto de transferencia de datos (DTO) que representa una solicitud de información de destino. Contiene los campos necesarios para enviar información de destino a través de la API.

## Anotaciones

- **@Data:** Anotación de Lombok que genera automáticamente los métodos getter y setter para los campos de la clase.
- **@NoArgsConstructor:** Anotación de Lombok que genera un constructor sin argumentos para la clase.
- **@AllArgsConstructor:** Anotación de Lombok que genera un constructor con todos los argumentos para la clase.
- **@Builder:** Anotación de Lombok que permite crear una instancia de la clase utilizando el patrón de diseño de construcción (builder).

## Campos

- `destino:` El nombre del destino.
- `climatica:` La información climática del destino.
- `actividad:` Las actividades disponibles en el destino.
- `alojamiento:` Las opciones de alojamiento en el destino.
- `viaje:` La información de viaje para el destino.
- `edad:` La idoneidad por edad para el destino.

## Uso

La clase `DestinationRequest` se utiliza para enviar información de destino a través de la API. Por ejemplo, al crear o actualizar información de destino, se puede crear una instancia de `DestinationRequest` y pasarla como parámetro al método correspondiente.

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

## Ejemplo de uso en un servicio

```java
@Service
public class DestinationService {

    public void createDestination(DestinationRequest destinationRequest) {
        // Crea un nuevo destino en la base de datos utilizando los datos de destinationRequest
    }
}
```

En este ejemplo, el método `createDestination` de la clase `DestinationService` recibe un objeto `DestinationRequest` como parámetro y utiliza los datos del objeto para crear un nuevo destino en la base de datos.

## Ejemplo de uso en un controlador

```java
@RestController
@RequestMapping("/destinations")
public class DestinationController {

    @PostMapping
    public void createDestination(@RequestBody DestinationRequest destinationRequest) {
        // Crea un nuevo destino en la base de datos utilizando los datos de destinationRequest
    }
}
```

En este ejemplo, el método `createDestination` de la clase `DestinationController` recibe un objeto `DestinationRequest` como parámetro y utiliza los datos del objeto para crear un nuevo destino en la base de datos.