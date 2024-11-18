# Clase DestinoInfoModel

## Descripción
La clase `DestinoInfoModel` es un modelo que representa información detallada sobre un destino. Se utiliza para transferir datos entre las diferentes capas de la aplicación.

## Anotaciones

- **@Data:** Anotación de Lombok que genera automáticamente los métodos *getter* y *setter* para los campos de la clase.
- **@NoArgsConstructor:** Anotación de Lombok que genera un constructor sin argumentos para la clase.
- **@AllArgsConstructor:** Anotación de Lombok que genera un constructor con todos los argumentos para la clase.
- **@Builder:** Anotación de Lombok que permite crear una instancia de la clase utilizando el patrón de diseño *builder*.
- **@Getter:** Anotación de Lombok que genera métodos *getter* para los campos de la clase.
- **@Setter:** Anotación de Lombok que genera métodos *setter* para los campos de la clase.

## Campos

- `id:` El identificador único de la información del destino.
- `nombreDestino:` El nombre del destino.
- `pais:` El país del destino.
- `idioma:` El idioma hablado en el destino.
- `lugarImperdible:` Un lugar imprescindible en el destino.
- `comidaTipica:` La comida típica del destino.
- `img:` Una imagen que representa el destino.
- `continente:` El continente donde se encuentra el destino.

## Uso

La clase `DestinoInfoModel` se utiliza para transferir información detallada sobre un destino entre las diferentes capas de la aplicación. Puede ser utilizada en servicios y controladores para manejar la información del destino.

```java
DestinoInfoModel destinoInfoModel = DestinoInfoModel.builder()
        .id(1L)
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
public class DestinoInfoService {

    public DestinoInfoModel getDestinoInfo(Long id) {
        // Recupera la información del destino desde la base de datos y devuelve una instancia de DestinoInfoModel
    }
}

```

En este ejemplo, el método `getDestinoInfo` de la clase `DestinoInfoService` devuelve un objeto `DestinoInfoModel` con la información del destino obtenida desde la base de datos.

## Ejemplo de uso en un controlador

```java
@RestController
@RequestMapping("/destino-info")
public class DestinoInfoController {

    @GetMapping("/{id}")
    public DestinoInfoModel getDestinoInfo(@PathVariable Long id) {
        // Recupera la información del destino desde la base de datos y devuelve una instancia de DestinoInfoModel
    }
}

```

En este ejemplo, el método `getDestinoInfo` de la clase `DestinoInfoController` devuelve un objeto `DestinoInfoModel` con la información del destino obtenida desde la base de datos. El ID del destino se recibe como un parámetro en la URL de la solicitud GET.