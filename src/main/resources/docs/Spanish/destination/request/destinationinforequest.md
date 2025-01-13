# Clase DestinationInfoRequest

## Descripción
La clase `DestinationInfoRequest` es un objeto de transferencia de datos (DTO) que representa una solicitud de información de destino. Contiene los campos necesarios para enviar información de destino a través de la API.

## Anotaciones

- **@Data:** Anotación de Lombok que genera automáticamente los métodos getter y setter para los campos de la clase.
- **@NoArgsConstructor:** Anotación de Lombok que genera un constructor sin argumentos para la clase.
- **@AllArgsConstructor:** Anotación de Lombok que genera un constructor con todos los argumentos para la clase.

## Campos

- `nombreDestino:` El nombre del destino.
- `destinoInfoEntities:` Una lista de objetos `DestinationInfoEntity` que representan información detallada del destino.

## Uso

La clase `DestinationInfoRequest` se utiliza para enviar información de destino a través de la API. Por ejemplo, al crear o actualizar información de destino, se puede crear una instancia de `DestinationInfoRequest` y pasarla como parámetro al método correspondiente.

```java
DestinationInfoRequest destinationInfoRequest = new DestinationInfoRequest();
destinationInfoRequest.setNombreDestino("Medellín");
destinationInfoRequest.setDestinoInfoEntities(destinationInfoEntitiesList);
```

## Ejemplo de uso en un servicio

```java
@Service
public class DestinationService {

    public void createDestination(DestinationInfoRequest destinationInfoRequest) {
        // Crea un nuevo destino en la base de datos utilizando los datos de destinationInfoRequest
    }
}
```

En este ejemplo, el método `createDestination` de la clase `DestinationService` recibe un objeto `DestinationInfoRequest` como parámetro y utiliza los datos del objeto para crear un nuevo destino en la base de datos.

## Ejemplo de uso en un controlador

```java
@RestController
@RequestMapping("/destinations")
public class DestinationController {

    @PostMapping
    public void createDestination(@RequestBody DestinationInfoRequest destinationInfoRequest) {
        // Crea un nuevo destino en la base de datos utilizando los datos de destinationInfoRequest
    }
}
```

En este ejemplo, el método `createDestination` de la clase `DestinationController` recibe un objeto `DestinationInfoRequest` como parámetro y utiliza los datos del objeto para crear un nuevo destino en la base de datos.