# Interfaz DestinationRepository

## Descripción
La interfaz `DestinationRepository` es un repositorio de Spring Data JPA para gestionar entidades de tipo `DestinationEntity`. Proporciona métodos para realizar operaciones CRUD en la tabla `DestinationEntity` de la base de datos.

## Anotaciones

- **@Repository:** Indica que la interfaz es un repositorio de Spring Data.

## Métodos

- `searchName(String destino1, String destino2):` Busca destinos cuyos nombres coincidan con los parámetros proporcionados.

## Uso

La interfaz `DestinationRepository` se utiliza para interactuar con la tabla `DestinationEntity` en la base de datos. Puede ser usada en clases de servicio para realizar operaciones CRUD sobre la información de los destinos.

```java
@Repository
public interface DestinationRepository extends JpaRepository<DestinationEntity, Long> {
    @Query(
            nativeQuery = true,
            value = "SELECT * FROM destino_info WHERE nombre_destino LIKE %:destino1% OR nombre_destino LIKE %:destino2%"
    )
    List<DestinationEntity> searchName(String destino1, String destino2);
}
```

## Ejemplo de uso en un servicio

```java
@Service
public class DestinationService {

    @Autowired
    private DestinationRepository destinationRepository;

    public List<DestinationEntity> searchDestinations(String destino1, String destino2) {
        return destinationRepository.searchName(destino1, destino2);
    }
}
```

En este ejemplo, el método `searchDestinations` de la clase `DestinationService` busca objetos `DestinationEntity` en la base de datos cuyos nombres coincidan con los parámetros proporcionados.

## Ejemplo de uso en un controlador

```java
@RestController
@RequestMapping("/destinations")
public class DestinationController {

    @Autowired
    private DestinationService destinationService;

    @GetMapping("/search")
    public List<DestinationEntity> searchDestinations(@RequestParam String destino1, @RequestParam String destino2) {
        return destinationService.searchDestinations(destino1, destino2);
    }
}
```

En este ejemplo, el método `searchDestinations` de la clase `DestinationController` busca objetos `DestinationEntity` en la base de datos cuyos nombres coincidan con los parámetros proporcionados. Los nombres de los destinos se reciben como parámetros en la URL de la solicitud GET.
