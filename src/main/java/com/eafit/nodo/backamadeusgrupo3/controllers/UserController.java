package com.eafit.nodo.backamadeusgrupo3.controllers;

import com.eafit.nodo.backamadeusgrupo3.contracts.request.UserRequest;
import com.eafit.nodo.backamadeusgrupo3.contracts.responses.UserResponse;
import com.eafit.nodo.backamadeusgrupo3.mappers.interfaces.UserMapper;
import com.eafit.nodo.backamadeusgrupo3.models.User;
import com.eafit.nodo.backamadeusgrupo3.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    @GetMapping("/list")
    public List<UserResponse> listarUsers() {
        return userMapper.mapUserModelListToUserResponseList(userService.findAll());
    }

    @PostMapping("/create")
    public Long crearUser(@RequestBody UserRequest userRequest) {
        User user = userMapper.mapUserRequestToUser(userRequest);
        User createdUser = userService.create(user);
        return createdUser.getId();
    }

    @PostMapping("/authenticate")
    public Map<String, Object> authenticate(@RequestParam String name, @RequestParam String email) {
        System.out.println("Received authentication request with name: " + name + " and email: " + email);
        UserRequest userRequest = UserRequest.builder()
                .name(name)
                .email(email)
                .build();
        User user = userService.authenticate(userRequest);
        Map<String, Object> response = new HashMap<>();
        response.put("name", user.getName());
        response.put("email", user.getEmail());
        response.put("birthdate", user.getBirthdate());
        response.put("success", true);
        System.out.println("Sending response: " + response);
        return response;
    }

    @GetMapping("/get/{id}")
    public UserResponse getUser(@PathVariable Long id) {
        return userMapper.mapUserToUserResponse(userService.findById(id));
    }

    @PutMapping("/update/{id}")
    public Long updateUser(@PathVariable Long id, @RequestBody UserRequest userRequest) {
        User user = userMapper.mapUserRequestToUser(userRequest);
        User updatedUser = userService.update(id, user);
        return updatedUser != null ? updatedUser.getId() : null;
    }

    @DeleteMapping("/delete/{id}")
    public Long deleteUser(@PathVariable Long id) {
        return userService.delete(id);
    }
}