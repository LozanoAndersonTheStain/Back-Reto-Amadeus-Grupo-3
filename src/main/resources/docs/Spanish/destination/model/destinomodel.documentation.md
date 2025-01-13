# Clase DestinoModel

## Descripción
La clase `DestinoModel` es un modelo que representa un destino. Se utiliza para transferir datos entre las diferentes capas de la aplicación.

## Anotaciones

- **@Data:** Anotación de Lombok que genera automáticamente los métodos *getter* y *setter* para los campos de la clase.
- **@NoArgsConstructor:** Anotación de Lombok que genera un constructor sin argumentos para la clase.
- **@AllArgsConstructor:** Anotación de Lombok que genera un constructor con todos los argumentos para la clase.
- **@Builder:** Anotación de Lombok que permite crear una instancia de la clase utilizando el patrón de diseño *builder*.
- **@Getter:** Anotación de Lombok que genera métodos *getter* para los campos de la clase.
- **@Setter:** Anotación de Lombok que genera métodos *setter* para los campos de la clase.

## Campos

- `id:` El identificador único del destino.
- `destino:` El nombre del destino.
- `climatica:` Información climática del destino.
- `actividad:` Las actividades disponibles en el destino.
- `alojamiento:` Opciones de alojamiento en el destino.
- `viaje:` Información sobre el viaje al destino.
- `edad:` La idoneidad por edades para el destino.

## Uso

La clase `DestinoModel` se utiliza para transferir datos de un destino entre las diferentes capas de la aplicación. Puede ser utilizada en servicios y controladores para manejar la información del destino.

```java
DestinoModel destinoModel = DestinoModel.builder()
        .id(1L)
        .destino("Medellín")
        .climatica("Tropical")
        .actividad("Senderismo")
        .alojamiento("Hotel")
        .viaje("Vuelo")
        .edad("Todas las edades")
        .build();
```

## Ejemplo de uso en un servicio

```java
@Service
public class DestinoService {

    public DestinoModel getDestino(Long id) {
        // Recupera la información del destino desde la base de datos y devuelve una instancia de DestinoModel
    }
}

```

En este ejemplo, el método `getDestino` de la clase `DestinoService` devuelve un objeto `DestinoModel` con la información del destino obtenida desde la base de datos.

## Ejemplo de uso en un controlador

```java
@RestController
@RequestMapping("/destino")
public class DestinoController {

    @GetMapping("/{id}")
    public DestinoModel getDestino(@PathVariable Long id) {
        // Recupera la información del destino desde la base de datos y devuelve una instancia de DestinoModel
    }
}

```

En este ejemplo, el método `getDestino` de la clase `DestinoController` devuelve un objeto `DestinoModel` con la información del destino obtenida desde la base de datos. El ID del destino se recibe como un parámetro en la URL de la solicitud GET.