# Class UserEntity

## Description
The `UserEntity` class is a JPA entity that represents a user in the database. It contains the necessary fields to store user information.

## Annotations

- **@Entity(name = "users"):** Indicates that the class is a JPA entity and specifies the name of the table in the database.
- **@Data:** Lombok annotation that automatically generates getter and setter methods for the class fields.
- **@NoArgsConstructor:** Lombok annotation that generates a no-argument constructor for the class.
- **@AllArgsConstructor:** Lombok annotation that generates an all-argument constructor for the class.
- **@Builder:** Lombok annotation that allows creating an instance of the class using the builder design pattern.
- **@Getter:** Lombok annotation that generates getter methods for the class fields.
- **@Setter:** Lombok annotation that generates setter methods for the class fields.

## Fields

* **`id`**
    - **Description:** The unique ID of the user.
    - **Type:** `Long`
    - **Annotations:** `@Id`, `@GeneratedValue(strategy = GenerationType.IDENTITY)`, `@Column(name = "user_id")`


* **`name`**
    - **Description:** The name of the user.
    - **Type:** `String`
    - **Annotations:** `@Column(nullable = false)`


* **`email`**
    - **Description:** The email of the user.
    - **Type:** `String`
    - **Annotations:** `@Column(nullable = false)`


* **`birthdate`**
    - **Description:** The birthdate of the user.
    - **Type:** `Date`
    - **Annotations:** `@Temporal(TemporalType.DATE)`, `@Column(nullable = false)`


* **`role`**
    - **Description:** The role of the user.
    - **Type:** `RoleUser`
    - **Annotations:** `@Enumerated(EnumType.STRING)`, `@Column(nullable = false)`


* **`destinoInfo`**
    - **Description:** A list of `DestinationEntity` objects associated with the user.
    - **Type:** `List<DestinationEntity>`
    - **Annotations:** `@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)`


* **`userQuerys`**
    - **Description:** A list of `UserQuerysEntity` objects associated with the user.
    - **Type:** `List<UserQuerysEntity>`
    - **Annotations:** `@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)`


* **`reports`**
    - **Description:** A list of `ReportsEntity` objects associated with the user.
    - **Type:** `List<ReportsEntity>`
    - **Annotations:** `@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)`

## Usage

The `UserEntity` class is used to store user information in the database. For example, when creating a new user, an instance of `UserEntity` can be created and saved in the database.

```java
UserEntity userEntity = UserEntity.builder()
        .name("Juan Pérez")
        .email("juan.perez@example.com")
        .birthdate(new Date())
        .role(RoleUser.USER)
        .build();
userService.save(userEntity);