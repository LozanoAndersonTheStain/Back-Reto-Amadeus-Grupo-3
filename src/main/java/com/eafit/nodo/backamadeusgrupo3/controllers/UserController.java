package com.eafit.nodo.backamadeusgrupo3.controllers;

import com.eafit.nodo.backamadeusgrupo3.contracts.request.UserRequest;
import com.eafit.nodo.backamadeusgrupo3.contracts.responses.UserResponse;
import com.eafit.nodo.backamadeusgrupo3.exeptions.user.UserAlreadyExistsException;
import com.eafit.nodo.backamadeusgrupo3.exeptions.user.UserNotFoundException;
import com.eafit.nodo.backamadeusgrupo3.mappers.interfaces.UserMapper;
import com.eafit.nodo.backamadeusgrupo3.models.User;
import com.eafit.nodo.backamadeusgrupo3.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    @GetMapping("/list")
    public ResponseEntity<List<UserResponse>> listarUsers() {
        log.info("Listing users");
        List<User> users = userService.findAll();
        if (users.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(userMapper.mapUserModelListToUserResponseList(users));
    }

    @PostMapping("/create")
    public ResponseEntity<String> crearUser(@RequestBody UserRequest userRequest) {
        log.info("Creando usuario con nombre: {} y email: {}", userRequest.getName(), userRequest.getEmail());
        try {
            User user = userMapper.mapUserRequestToUser(userRequest);
            User createdUser = userService.create(user);
            return ResponseEntity.status(HttpStatus.CREATED).body("User created with ID: " + createdUser.getId());
        } catch (UserAlreadyExistsException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

    @PostMapping("/createMultipleUsers")
public ResponseEntity<?> createMultipleUsers(@RequestBody List<UserRequest> userRequests) {
    log.info("Creating multiple users");
    try {
        List<User> users = userRequests.stream()
                .map(userMapper::mapUserRequestToUser)
                .collect(Collectors.toList());
        List<User> createdUsers = userService.createMultipleUsers(users);
        List<UserResponse> userResponses = createdUsers.stream()
                .map(userMapper::mapUserToUserResponse)
                .collect(Collectors.toList());
        return new ResponseEntity<>(userResponses, HttpStatus.CREATED);
    } catch (UserAlreadyExistsException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
    } catch (Exception e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

    @PostMapping("/authenticate")
    public ResponseEntity<Map<String, Object>> authenticate(@RequestParam String name, @RequestParam String email) {
        log.info("Autenticando usuario con nombre: {} y email: {}", name, email);
        UserRequest userRequest = UserRequest.builder()
                .name(name)
                .email(email)
                .build();
        log.info("UserRequest: {}", userRequest);
        try {
            User user = userService.authenticate(userRequest);
            Map<String, Object> response = new HashMap<>();
            response.put("id", user.getId());
            response.put("name", user.getName());
            response.put("email", user.getEmail());
            response.put("birthdate", user.getBirthdate());
            response.put("role", user.getRole());
            response.put("success", true);
            log.info("Sending response: {}", response);
            return ResponseEntity.ok(response);
        } catch (UserNotFoundException e) {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("message", "User not authorized or logged in");
            errorResponse.put("success", false);
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse);
        } catch (Exception e) {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("message", "An error occurred during authentication");
            errorResponse.put("success", false);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    @GetMapping("/getUserById/{id}")
    public ResponseEntity<?> getUser(@PathVariable Long id) {
        log.info("Obtain: {}", id);
        try {
            UserResponse userResponse = userMapper.mapUserToUserResponse(userService.findById(id));
            return ResponseEntity.ok(userResponse);
        } catch (UserNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody UserRequest userRequest) {
        log.info("Actualizando usuario con id: {}", id);
        try {
            User user = userMapper.mapUserRequestToUser(userRequest);
            User updatedUser = userService.update(id, user);
            log.info("Usuario actualizado: {}", updatedUser);
            return ResponseEntity.ok(updatedUser.getId());
        } catch (UserNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        log.info("Eliminando usuario con id: {}", id);
        try {
            Long deletedId = userService.delete(id);
            return ResponseEntity.ok(deletedId);
        } catch (UserNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}