# Interface DestinationInfoRepository

## Description
The `DestinationInfoRepository` interface is a Spring Data JPA repository for managing `DestinationInfoEntity` entities. It provides methods for performing CRUD operations on the `DestinationInfoEntity` table in the database.

## Annotations

- **@Repository:** Indicates that the interface is a Spring Data repository.

## Methods

- `saveAndFlush(DestinationInfoEntity destinoInfo):` Saves the given entity and flushes changes instantly.

## Usage

The `DestinationInfoRepository` interface is used to interact with the `DestinationInfoEntity` table in the database. It can be used in service classes to perform CRUD operations on destination information.

```java
@Repository
public interface DestinationInfoRepository extends JpaRepository<DestinationInfoEntity, Long> {

    DestinationInfoEntity saveAndFlush(DestinationInfoEntity destinoInfo);
}
```

## Example of usage in a service

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

In this example, the saveDestinationInfo method of the DestinationInfoService saves a DestinationInfoEntity object to the database and flushes the changes instantly.

## Example of usage in a controller

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

In this example, the saveDestinationInfo method of the DestinationInfoController saves a DestinationInfoEntity object to the database. The destination information is received as a JSON object in the body of the POST request.