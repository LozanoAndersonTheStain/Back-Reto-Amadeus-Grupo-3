# Interfaz DestinationInfoRepository

## Descripción
La interfaz `DestinationInfoRepository` es un repositorio de Spring Data JPA para gestionar entidades de tipo `DestinationInfoEntity`. Proporciona métodos para realizar operaciones CRUD en la tabla `DestinationInfoEntity` de la base de datos.

## Anotaciones

- **@Repository:** Indica que la interfaz es un repositorio de Spring Data.

## Métodos

- `saveAndFlush(DestinationInfoEntity destinoInfo):` Guarda la entidad proporcionada y aplica los cambios de forma inmediata.

## Uso

La interfaz `DestinationInfoRepository` se utiliza para interactuar con la tabla `DestinationInfoEntity` en la base de datos. Puede ser usada en clases de servicio para realizar operaciones CRUD sobre la información de los destinos.

```java
@Repository
public interface DestinationInfoRepository extends JpaRepository<DestinationInfoEntity, Long> {

    DestinationInfoEntity saveAndFlush(DestinationInfoEntity destinoInfo);
}
```

## Ejemplo de uso en un servicio

```java
@Service
public class DestinationInfoService {

    @Autowired
    private DestinationInfoRepository destinationInfoRepository;

    public DestinationInfoEntity saveDestinationInfo(DestinationInfoEntity destinoInfo) {
        return destinationInfoRepository.saveAndFlush(destinoInfo);
    }
}
```
En este ejemplo, el método `saveDestinationInfo` de la clase `DestinationInfoService` guarda un objeto `DestinationInfoEntity` en la base de datos y aplica los cambios de forma inmediata.

## Ejemplo de uso en un controlador

```java
@RestController
@RequestMapping("/destination-info")
public class DestinationInfoController {

    @Autowired
    private DestinationInfoService destinationInfoService;

    @PostMapping
    public DestinationInfoEntity saveDestinationInfo(@RequestBody DestinationInfoEntity destinoInfo) {
        return destinationInfoService.saveDestinationInfo(destinoInfo);
    }
}
```

En este ejemplo, el método `saveDestinationInfo` de la clase `DestinationInfoController` guarda un objeto `DestinationInfoEntity` en la base de datos. La información del destino se recibe como un objeto JSON en el cuerpo de la solicitud POST.