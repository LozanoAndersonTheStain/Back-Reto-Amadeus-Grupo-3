# Clase DestinationInfoEntity

## Descripción
La clase `DestinationInfoEntity` es una entidad que representa información detallada sobre un destino en la base de datos. Está mapeada a la tabla `destino_info` en la base de datos y contiene campos que almacenan información detallada sobre el destino.

## Anotaciones

- **@Entity(name = "destino_info"):** Especifica que la clase es una entidad y está mapeada a la tabla `destino_info` en la base de datos.
- **@Id:** Especifica la clave primaria de la entidad.
- **@GeneratedValue(strategy = GenerationType.IDENTITY):** Proporciona la especificación de estrategias de generación para las claves primarias.
- **@OneToOne(cascade = CascadeType.ALL):** Especifica una relación uno a uno con la clase `DestinationEntity`.
- **@JoinColumn(name = "destino_id"):** Especifica la columna de clave foránea para la relación con `DestinationEntity`.
- **@NoArgsConstructor:** Anotación de Lombok que genera un constructor sin argumentos para la clase.
- **@AllArgsConstructor:** Anotación de Lombok que genera un constructor con todos los argumentos para la clase.
- **@Builder:** Anotación de Lombok que permite crear una instancia de la clase utilizando el patrón de diseño *builder*.
- **@Data:** Anotación de Lombok que genera automáticamente los métodos *getter* y *setter* para los campos de la clase.
- **@Getter:** Anotación de Lombok que genera métodos *getter* para los campos de la clase.
- **@Setter:** Anotación de Lombok que genera métodos *setter* para los campos de la clase.

## Campos

- `id:` El identificador único de la información del destino.
- `nombreDestino:` El nombre del destino.
- `pais:` El país del destino.
- `idioma:` El idioma hablado en el destino.
- `lugarImperdible:` Un lugar imprescindible en el destino.
- `comidaTipica:` La comida típica del destino.
- `img:` Una imagen que representa el destino.
- `continente:` El continente donde se encuentra el destino.
- `destino:` El destino asociado con esta información detallada.

## Uso

La clase `DestinationInfoEntity` se utiliza para representar información detallada sobre un destino en la base de datos. Puede ser utilizada en clases de repositorio para realizar operaciones CRUD en la tabla `destino_info`.

```java
DestinationInfoEntity destinationInfoEntity = DestinationInfoEntity.builder()
        .nombreDestino("Medellín")
        .pais("Colombia")
        .idioma("Español")
        .lugarImperdible("Pueblito Paisa")
        .comidaTipica("Bandeja Paisa")
        .img("url_imagen")
        .continente("América del Sur")
        .build();
destinationInfoRepository.save(destinationInfoEntity);
```

## Ejemplo de uso en un repositorio

```java
@Repository
public interface DestinationInfoRepository extends JpaRepository<DestinationInfoEntity, Long> {
    Optional<DestinationInfoEntity> findByNombreDestino(String nombreDestino);
}
```

En este ejemplo, la interfaz `DestinationInfoRepository` extiende `JpaRepository` para proporcionar operaciones CRUD para la clase `DestinationInfoEntity`. El método `findByNombreDestino` se utiliza para encontrar información detallada por el nombre del destino.
