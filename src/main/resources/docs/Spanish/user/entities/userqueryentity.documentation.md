# Clase UserQueryEntity

## Descripción
La clase `UserQuerysEntity` es una entidad que representa una consulta del usuario en la base de datos. Está mapeada a la tabla `users_querys` en la base de datos y contiene campos que almacenan información sobre la consulta del usuario.

## Anotaciones

- **@Entity(name = "users_querys")**: Especifica que la clase es una entidad y está mapeada a la tabla `users_querys` en la base de datos.
- **@Id**: Especifica la clave primaria de la entidad.
- **@GeneratedValue(strategy = GenerationType.IDENTITY)**: Proporciona la especificación de las estrategias de generación para las claves primarias.
- **@ManyToOne(fetch = FetchType.LAZY)**: Especifica una relación de muchos a uno con la clase `UserEntity`.
- **@JoinColumn(name = "user_id")**: Especifica la columna de la clave foránea para la relación con `UserEntity`.
- **@NoArgsConstructor**: Anotación de Lombok que genera un constructor sin argumentos para la clase.
- **@AllArgsConstructor**: Anotación de Lombok que genera un constructor con todos los argumentos para la clase.
- **@Builder**: Anotación de Lombok que permite crear una instancia de la clase utilizando el patrón de diseño builder.
- **@Data**: Anotación de Lombok que genera automáticamente los métodos getter y setter para los campos de la clase.
- **@Getter**: Anotación de Lombok que genera métodos getter para los campos de la clase.
- **@Setter**: Anotación de Lombok que genera métodos setter para los campos de la clase.

## Campos

* **`id`**
    - **Descripción:** El identificador único de la consulta del usuario.
    - **Tipo:** `Long`

* **`queryTime`**
    - **Descripción:** El momento en que se realizó la consulta.
    - **Tipo:** `Timestamp`

* **`environment_type`**
    - **Descripción:** El tipo de entorno especificado en la consulta.
    - **Tipo:** `String`

* **`climate_type`**
    - **Descripción:** El tipo de clima especificado en la consulta.
    - **Tipo:** `String`

* **`accommodation_type`**
    - **Descripción:** El tipo de alojamiento especificado en la consulta.
    - **Tipo:** `String`

* **`activity_type`**
    - **Descripción:** El tipo de actividad especificada en la consulta.
    - **Tipo:** `String`

* **`stay_duration`**
    - **Descripción:** La duración de la estancia especificada en la consulta.
    - **Tipo:** `String`

* **`age_range`**
    - **Descripción:** El rango de edad especificado en la consulta.
    - **Tipo:** `String`

* **`user`**
    - **Descripción:** El usuario asociado con la consulta.
    - **Tipo:** `UserEntity`
    - **Anotaciones:** `@ManyToOne(fetch = FetchType.LAZY)`, `@JoinColumn(name = "user_id")`

## Uso

La clase `UserQuerysEntity` se utiliza para representar una consulta del usuario en la base de datos. Se puede utilizar en clases de repositorio para realizar operaciones CRUD en la tabla `users_querys`.

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

## Ejemplo de uso en un repositorio

```java
@Repository
public interface UserQuerysRepository extends JpaRepository<UserQuerysEntity, Long> {
    Optional<UserQuerysEntity> findByQueryTime(Timestamp queryTime);
}
```

En este ejemplo, la interfaz `UserQuerysRepository` extiende `JpaRepository` para proporcionar operaciones CRUD para la clase `UserQuerysEntity`. El método findByQueryTime se utiliza para encontrar una consulta del usuario por su hora de creación.