# Class DestinationInfoEntity

## Description
The `DestinationInfoEntity` class is an entity that represents detailed information about a destination in the database. It is mapped to the `destino_info` table in the database and contains fields that store detailed information about the destination.

## Annotations

- **@Entity(name = "destino_info"):** Specifies that the class is an entity and is mapped to the `destino_info` table in the database.
- **@Id:** Specifies the primary key of the entity.
- **@GeneratedValue(strategy = GenerationType.IDENTITY):** Provides the specification of generation strategies for the primary keys.
- **@OneToOne(cascade = CascadeType.ALL):** Specifies a one-to-one relationship with the `DestinationEntity` class.
- **@JoinColumn(name = "destino_id"):** Specifies the foreign key column for the `DestinationEntity` relationship.
- **@NoArgsConstructor:** Lombok annotation that generates a no-argument constructor for the class.
- **@AllArgsConstructor:** Lombok annotation that generates an all-argument constructor for the class.
- **@Builder:** Lombok annotation that allows creating an instance of the class using the builder design pattern.
- **@Data:** Lombok annotation that automatically generates getter and setter methods for the class fields.
- **@Getter:** Lombok annotation that generates getter methods for the class fields.
- **@Setter:** Lombok annotation that generates setter methods for the class fields.

## Fields

- `id:` The unique identifier of the destination information.
- `nombreDestino:` The name of the destination.
- `pais:` The country of the destination.
- `idioma:` The language spoken at the destination.
- `lugarImperdible:` A must-see place at the destination.
- `comidaTipica:` The typical food of the destination.
- `img:` An image representing the destination.
- `continente:` The continent where the destination is located.
- `destino:` The destination associated with this detailed information.

## Usage

The `DestinationInfoEntity` class is used to represent detailed information about a destination in the database. It can be used in repository classes to perform CRUD operations on the `destino_info` table.

```java
DestinationInfoEntity destinationInfoEntity = DestinationInfoEntity.builder()
        .nombreDestino("Medellín")
        .pais("Colombia")
        .idioma("Spanish")
        .lugarImperdible("Pueblito Paisa")
        .comidaTipica("Bandeja Paisa")
        .img("image_url")
        .continente("South America")
        .build();
destinationInfoRepository.save(destinationInfoEntity);
```

## Example of usage in a repository

```java
@Repository
public interface DestinationInfoRepository extends JpaRepository<DestinationInfoEntity, Long> {
    Optional<DestinationInfoEntity> findByNombreDestino(String nombreDestino);
}
```

In this example, the DestinationInfoRepository interface extends JpaRepository to provide CRUD operations for the DestinationInfoEntity class. The findByNombreDestino method is used to find detailed information by the name of the destination.