# Clase UserEntity

## Descripción
La clase `UserEntity` es una entidad JPA que representa a un usuario en la base de datos. Contiene los campos necesarios para almacenar la información del usuario.

## Anotaciones

- **@Entity(name = "users")**: Indica que la clase es una entidad JPA y especifica el nombre de la tabla en la base de datos.
- **@Data**: Anotación de Lombok que genera automáticamente los métodos getter y setter para los campos de la clase.
- **@NoArgsConstructor**: Anotación de Lombok que genera un constructor sin argumentos para la clase.
- **@AllArgsConstructor**: Anotación de Lombok que genera un constructor con todos los argumentos para la clase.
- **@Builder**: Anotación de Lombok que permite crear una instancia de la clase utilizando el patrón de diseño builder.
- **@Getter**: Anotación de Lombok que genera métodos getter para los campos de la clase.
- **@Setter**: Anotación de Lombok que genera métodos setter para los campos de la clase.

## Campos

* **`id`**
    - **Descripción:** El ID único del usuario.
    - **Tipo:** `Long`
    - **Anotaciones:** `@Id`, `@GeneratedValue(strategy = GenerationType.IDENTITY)`, `@Column(name = "user_id")`

* **`name`**
    - **Descripción:** El nombre del usuario.
    - **Tipo:** `String`
    - **Anotaciones:** `@Column(nullable = false)`

* **`email`**
    - **Descripción:** El correo electrónico del usuario.
    - **Tipo:** `String`
    - **Anotaciones:** `@Column(nullable = false)`

* **`birthdate`**
    - **Descripción:** La fecha de nacimiento del usuario.
    - **Tipo:** `Date`
    - **Anotaciones:** `@Temporal(TemporalType.DATE)`, `@Column(nullable = false)`

* **`role`**
    - **Descripción:** El rol del usuario.
    - **Tipo:** `RoleUser`
    - **Anotaciones:** `@Enumerated(EnumType.STRING)`, `@Column(nullable = false)`

* **`destinoInfo`**
    - **Descripción:** Una lista de objetos `DestinationEntity` asociados con el usuario.
    - **Tipo:** `List<DestinationEntity>`
    - **Anotaciones:** `@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)`

* **`userQuerys`**
    - **Descripción:** Una lista de objetos `UserQuerysEntity` asociados con el usuario.
    - **Tipo:** `List<UserQuerysEntity>`
    - **Anotaciones:** `@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)`

* **`reports`**
    - **Descripción:** Una lista de objetos `ReportsEntity` asociados con el usuario.
    - **Tipo:** `List<ReportsEntity>`
    - **Anotaciones:** `@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)`

## Uso

La clase `UserEntity` se utiliza para almacenar la información del usuario en la base de datos. Por ejemplo, al crear un nuevo usuario, se puede crear una instancia de `UserEntity` y guardarla en la base de datos.

```java
UserEntity userEntity = UserEntity.builder()
        .name("Juan Pérez")
        .email("juan.perez@example.com")
        .birthdate(new Date())
        .role(RoleUser.USER)
        .build();
userService.save(userEntity);
```