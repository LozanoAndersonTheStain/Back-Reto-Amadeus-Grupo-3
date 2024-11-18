# Class UserQuerysEntity

## Description
The `UserQuerysEntity` class is an entity that represents a user's query in the database. It is mapped to the `users_querys` table in the database and contains fields that store information about the user's query.

## Annotations

- **@Entity(name = "users_querys"):** Specifies that the class is an entity and is mapped to the `users_querys` table in the database.
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

- `id:` The unique identifier of the user's query.
- `queryTime:` The time when the query was made.
- `environment_type:` The type of environment specified in the query.
- `climate_type:` The type of climate specified in the query.
- `accommodation_type:` The type of accommodation specified in the query.
- `activity_type:` The type of activity specified in the query.
- `stay_duration:` The duration of the stay specified in the query.
- `age_range:` The age range specified in the query.
- `user:` The user associated with the query.

## Usage

The `UserQuerysEntity` class is used to represent a user's query in the database. It can be used in repository classes to perform CRUD operations on the `users_querys` table.

```java
UserQuerysEntity userQuerysEntity = UserQuerysEntity.builder()
        .queryTime(Timestamp.valueOf("2023-10-01 10:00:00"))
        .environment_type("Urban")
        .climate_type("Tropical")
        .accommodation_type("Hotel")
        .activity_type("Sightseeing")
        .stay_duration("1 week")
        .age_range("18-25")
        .build();
userQuerysRepository.save(userQuerysEntity);
```

## Example of usage in a repository

```java
@Repository
public interface UserQuerysRepository extends JpaRepository<UserQuerysEntity, Long> {
    Optional<UserQuerysEntity> findByQueryTime(Timestamp queryTime);
}
```

In this example, the UserQuerysRepository interface extends JpaRepository to provide CRUD operations for the UserQuerysEntity class. The findByQueryTime method is used to find a user's query by its creation time.