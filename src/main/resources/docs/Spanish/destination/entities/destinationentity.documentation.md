# Clase DestinationEntity

## Descripción
La clase `DestinationEntity` es una entidad que representa un destino en la base de datos. Está mapeada a la tabla `destino` en la base de datos y contiene campos que almacenan información sobre el destino.

## Anotaciones

- **@Entity:** Especifica que la clase es una entidad y está mapeada a una tabla de base de datos.
- **@Table(name = "destino"):** Especifica el nombre de la tabla de base de datos para el mapeo.
- **@Id:** Especifica la clave primaria de la entidad.
- **@GeneratedValue(strategy = GenerationType.IDENTITY):** Proporciona la especificación de estrategias de generación para las claves primarias.
- **@OneToOne(mappedBy = "destino", cascade = CascadeType.ALL):** Especifica una relación uno a uno con la clase `DestinationInfoEntity`.
- **@ManyToOne(fetch = FetchType.LAZY):** Especifica una relación muchos a uno con la clase `UserEntity`.
- **@JoinColumn(name = "user_id"):** Especifica la columna de clave foránea para la relación con `UserEntity`.
- **@NoArgsConstructor:** Anotación de Lombok que genera un constructor sin argumentos para la clase.
- **@AllArgsConstructor:** Anotación de Lombok que genera un constructor con todos los argumentos para la clase.
- **@Builder:** Anotación de Lombok que permite crear una instancia de la clase utilizando el patrón de diseño *builder*.
- **@Data:** Anotación de Lombok que genera automáticamente los métodos *getter* y *setter* para los campos de la clase.
- **@Getter:** Anotación de Lombok que genera métodos *getter* para los campos de la clase.
- **@Setter:** Anotación de Lombok que genera métodos *setter* para los campos de la clase.

## Campos

- `id:` El identificador único del destino.
- `destino:` El nombre del destino.
- `climatica:` La información climática del destino.
- `actividad:` Las actividades disponibles en el destino.
- `alojamiento:` Las opciones de alojamiento en el destino.
- `viaje:` La información de viaje para el destino.
- `edad:` La adecuación por edades del destino.
- `destinoInfo:` La información detallada del destino.
- `user:` El usuario asociado con el destino.

## Uso

La clase `DestinationEntity` se utiliza para representar un destino en la base de datos. Puede ser utilizada en clases de repositorio para realizar operaciones CRUD en la tabla `destino`.

```java
DestinationEntity destinationEntity = DestinationEntity.builder()
        .destino("Medellín")
        .climatica("Tropical")
        .actividad("Senderismo")
        .alojamiento("Hotel")
        .viaje("Avión")
        .edad("Todas las edades")
        .build();
destinationRepository.save(destinationEntity);
```

## Ejemplo de uso en un repositorio

```java
@Repository
public interface DestinationRepository extends JpaRepository<DestinationEntity, Long> {
    Optional<DestinationEntity> findByDestino(String destino);
}
```

En este ejemplo, la interfaz `DestinationRepository` extiende `JpaRepository` para proporcionar operaciones CRUD para la clase `DestinationEntity`. El método `findByDestino` se utiliza para encontrar un destino por su nombre.