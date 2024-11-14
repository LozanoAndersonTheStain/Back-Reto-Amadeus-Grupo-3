package com.eafit.nodo.backamadeusgrupo3.controllers;

import com.eafit.nodo.backamadeusgrupo3.contracts.request.UserRequest;
import com.eafit.nodo.backamadeusgrupo3.contracts.responses.UserResponse;
import com.eafit.nodo.backamadeusgrupo3.mappers.interfaces.UserMapper;
import com.eafit.nodo.backamadeusgrupo3.models.User;
import com.eafit.nodo.backamadeusgrupo3.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    @GetMapping("/list")
    public List<UserResponse> listarUsers() {
        log.info("Listando todos los usuarios");
        return userMapper.mapUserModelListToUserResponseList(userService.findAll());
    }

    @PostMapping("/create")
    public Long crearUser(@RequestBody UserRequest userRequest) {
        log.info("Creando usuario con nombre: " + userRequest.getName() + " y email: " + userRequest.getEmail());
        User user = userMapper.mapUserRequestToUser(userRequest);
        User createdUser = userService.create(user);
        return createdUser.getId();
    }

    @PostMapping("/authenticate")
    public Map<String, Object> authenticate(@RequestParam String name, @RequestParam String email) {
        log.info("Autenticando usuario con nombre: " + name + " y email: " + email);
        UserRequest userRequest = UserRequest.builder()
                .name(name)
                .email(email)
                .build();
        log.info("UserRequest: " + userRequest);
        User user = userService.authenticate(userRequest);
        Map<String, Object> response = new HashMap<>();
        response.put("name", user.getName());
        response.put("email", user.getEmail());
        response.put("birthdate", user.getBirthdate());
        response.put(("role"), user.getRole());
        response.put("success", true);
        log.info("Sending response: " + response);
        return response;
    }

    @GetMapping("/get/{id}")
    public UserResponse getUser(@PathVariable Long id) {
        log.info("Obteniendo usuario con id: " + id);
        return userMapper.mapUserToUserResponse(userService.findById(id));
    }

    @PutMapping("/update/{id}")
    public Long updateUser(@PathVariable Long id, @RequestBody UserRequest userRequest) {
        log.info("Actualizando usuario con id: " + id);
        User user = userMapper.mapUserRequestToUser(userRequest);
        User updatedUser = userService.update(id, user);
        log.info("Usuario actualizado: " + updatedUser);
        return updatedUser != null ? updatedUser.getId() : null;
    }

    @DeleteMapping("/delete/{id}")
    public Long deleteUser(@PathVariable Long id) {
        log.info("Eliminando usuario con id: " + id);
        return userService.delete(id);
    }
}