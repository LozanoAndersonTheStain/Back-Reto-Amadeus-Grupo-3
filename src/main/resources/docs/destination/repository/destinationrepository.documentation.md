# Interface DestinationRepository

## Description
The `DestinationRepository` interface is a Spring Data JPA repository for managing `DestinationEntity` entities. It provides methods for performing CRUD operations on the `DestinationEntity` table in the database.

## Annotations

- **@Repository:** Indicates that the interface is a Spring Data repository.

## Methods

- `searchName(String destino1, String destino2):` Searches for destinations where the name matches the given parameters.

## Usage

The `DestinationRepository` interface is used to interact with the `DestinationEntity` table in the database. It can be used in service classes to perform CRUD operations on destination information.

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

## Example of usage in a service

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

In this example, the searchDestinations method of the DestinationService searches for DestinationEntity objects in the database where the name matches the given parameters.

## Example of usage in a controller

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

In this example, the searchDestinations method of the DestinationController searches for DestinationEntity objects in the database where the name matches the given parameters. The destination names are received as parameters in the URL of the GET request.