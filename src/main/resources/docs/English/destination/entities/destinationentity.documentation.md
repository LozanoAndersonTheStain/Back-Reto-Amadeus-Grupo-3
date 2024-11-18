# Class DestinationEntity

## Description
The `DestinationEntity` class is an entity that represents a destination in the database. It is mapped to the `destino` table in the database and contains fields that store information about the destination.

## Annotations

- **@Entity:** Specifies that the class is an entity and is mapped to a database table.
- **@Table(name = "destino"):** Specifies the name of the database table to be used for mapping.
- **@Id:** Specifies the primary key of the entity.
- **@GeneratedValue(strategy = GenerationType.IDENTITY):** Provides the specification of generation strategies for the primary keys.
- **@OneToOne(mappedBy = "destino", cascade = CascadeType.ALL):** Specifies a one-to-one relationship with the `DestinationInfoEntity` class.
- **@ManyToOne(fetch = FetchType.LAZY):** Specifies a many-to-one relationship with the `UserEntity` class.
- **@JoinColumn(name = "user_id"):** Specifies the foreign key column for the `UserEntity` relationship.
- **@NoArgsConstructor:** Lombok annotation that generates a no-argument constructor for the class.
- **@AllArgsConstructor:** Lombok annotation that generates an all-argument constructor for the class.
- **@Builder:** Lombok annotation that allows creating an instance of the class using the builder design pattern.
- **@Data:** Lombok annotation that automatically generates getter and setter methods for the class fields.
- **@Getter:** Lombok annotation that generates getter methods for the class fields.
- **@Setter:** Lombok annotation that generates setter methods for the class fields.

## Fields

- `id:` The unique identifier of the destination.
- `destino:` The name of the destination.
- `climatica:` The climate information of the destination.
- `actividad:` The activities available at the destination.
- `alojamiento:` The accommodation options at the destination.
- `viaje:` The travel information for the destination.
- `edad:` The age suitability for the destination.
- `destinoInfo:` The detailed information about the destination.
- `user:` The user associated with the destination.

## Usage

The `DestinationEntity` class is used to represent a destination in the database. It can be used in repository classes to perform CRUD operations on the `destino` table.

```java
DestinationEntity destinationEntity = DestinationEntity.builder()
        .destino("Medellín")
        .climatica("Tropical")
        .actividad("Hiking")
        .alojamiento("Hotel")
        .viaje("Flight")
        .edad("All ages")
        .build();
destinationRepository.save(destinationEntity);
```
## Example of usage in a repository

```java
@Repository
public interface DestinationRepository extends JpaRepository<DestinationEntity, Long> {
    Optional<DestinationEntity> findByDestino(String destino);
}
```

In this example, the DestinationRepository interface extends JpaRepository to provide CRUD operations for the DestinationEntity class. The findByDestino method is used to find a destination by its name.