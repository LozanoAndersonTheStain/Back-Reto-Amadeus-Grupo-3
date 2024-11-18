# Clase ReportsEntity

## Descripción
La clase `ReportsEntity` es una entidad que representa un informe en la base de datos. Está mapeada a la tabla `reports` en la base de datos y contiene campos que almacenan la información sobre el informe.

## Anotaciones

- **@Entity(name = "reports")**: Especifica que la clase es una entidad y está mapeada a la tabla `reports` en la base de datos.
- **@Id**: Especifica la clave primaria de la entidad.
- **@GeneratedValue(strategy = GenerationType.IDENTITY)**: Especifica la estrategia de generación para las claves primarias.
- **@ManyToOne(fetch = FetchType.LAZY)**: Especifica una relación muchos a uno con la clase `UserEntity`.
- **@JoinColumn(name = "user_id")**: Especifica la columna de clave externa para la relación con `UserEntity`.
- **@NoArgsConstructor**: Anotación de Lombok que genera un constructor sin argumentos para la clase.
- **@AllArgsConstructor**: Anotación de Lombok que genera un constructor con todos los argumentos para la clase.
- **@Builder**: Anotación de Lombok que permite crear una instancia de la clase utilizando el patrón de diseño de constructor.
- **@Data**: Anotación de Lombok que genera automáticamente los métodos getter y setter para los campos de la clase.
- **@Getter**: Anotación de Lombok que genera los métodos getter para los campos de la clase.
- **@Setter**: Anotación de Lombok que genera los métodos setter para los campos de la clase.

## Campos

- `id:` El identificador único del informe.
- `reportTime:` El tiempo cuando se creó el informe.
- `reportData:` Los datos contenidos en el informe.
- `user:` El usuario asociado con el informe.

## Uso

La clase `ReportsEntity` se utiliza para representar un informe en la base de datos. Puede ser utilizada en las clases de repositorio para realizar operaciones CRUD en la tabla `reports`.

```java
ReportsEntity reportsEntity = ReportsEntity.builder()
        .reportTime("2023-10-01T10:00:00")
        .reportData("Datos del informe de ejemplo")
        .build();
reportsRepository.save(reportsEntity);
```

## Ejemplo de uso en un repositorio

```java
@Repository
public interface ReportsRepository extends JpaRepository<ReportsEntity, Long> {
    Optional<ReportsEntity> findByReportTime(String reportTime);
}
```

En este ejemplo, la interfaz `ReportsRepository` extiende `JpaRepository` para proporcionar operaciones CRUD para la clase `ReportsEntity`. El método `findByReportTime` se utiliza para encontrar un informe por su tiempo de creación.