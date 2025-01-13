# Class ReportsEntity

## Description
The `ReportsEntity` class is an entity that represents a report in the database. It is mapped to the `reports` table in the database and contains fields that store information about the report.

## Annotations

- **@Entity(name = "reports"):** Specifies that the class is an entity and is mapped to the `reports` table in the database.
- **@Id:** Specifies the primary key of the entity.
- **@GeneratedValue(strategy = GenerationType.IDENTITY):** Provides the specification of generation strategies for the primary keys.
- **@ManyToOne(fetch = FetchType.LAZY):** Specifies a many-to-one relationship with the `UserEntity` class.
- **@JoinColumn(name = "user_id"):** Specifies the foreign key column for the `UserEntity` relationship.
- **@NoArgsConstructor:** Lombok annotation that generates a no-argument constructor for the class.
- **@AllArgsConstructor:** Lombok annotation that generates an all-argument constructor for the class.
- **@Builder:** Lombok annotation that allows creating an instance of the class using the builder design pattern.
- **@Data:** Lombok annotation that automatically generates getter and setter methods for the class fields.
- **@Getter:** Lombok annotation that generates getter methods for the class fields.
- **@Setter:** Lombok annotation that generates setter methods for the class fields.

## Fields

- `id:` The unique identifier of the report.
- `reportTime:` The time when the report was created.
- `reportData:` The data contained in the report.
- `user:` The user associated with the report.

## Usage

The `ReportsEntity` class is used to represent a report in the database. It can be used in repository classes to perform CRUD operations on the `reports` table.

```java
ReportsEntity reportsEntity = ReportsEntity.builder()
        .reportTime("2023-10-01T10:00:00")
        .reportData("Sample report data")
        .build();
reportsRepository.save(reportsEntity);
```

## Example of usage in a repository

```java
@Repository
public interface ReportsRepository extends JpaRepository<ReportsEntity, Long> {
    Optional<ReportsEntity> findByReportTime(String reportTime);
}
```

In this example, the ReportsRepository interface extends JpaRepository to provide CRUD operations for the ReportsEntity class. The findByReportTime method is used to find a report by its creation time.
