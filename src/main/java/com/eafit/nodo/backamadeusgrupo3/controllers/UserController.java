package com.eafit.nodo.backamadeusgrupo3.controllers;

import com.eafit.nodo.backamadeusgrupo3.contracts.request.UserRequest;
import com.eafit.nodo.backamadeusgrupo3.contracts.responses.UserResponse;
import com.eafit.nodo.backamadeusgrupo3.mappers.interfaces.UserMapper;
import com.eafit.nodo.backamadeusgrupo3.models.User;
import com.eafit.nodo.backamadeusgrupo3.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
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
    public UserResponse authenticate(@RequestParam String name, @RequestParam String email) {
        UserRequest userRequest = UserRequest.builder()
                .name(name)
                .email(email)
                .build();
        User user = userService.authenticate(userRequest);
        if (user != null) {
            return UserResponse.builder()
                    .name(user.getName())
                    .email(user.getEmail())
                    .birthdate(user.getBirthdate())
                    .build();
        }
        return null;
    }

    @GetMapping("/get/{id}")
    public UserResponse getUser(@PathVariable Long id) {
        return userMapper.mapUserToUserResponse(userService.findById(id));
    }

    @PostMapping("/update/{id}")
    public Long updateUser(@PathVariable Long id, @RequestBody UserRequest userRequest) {
        User user = userMapper.mapUserRequestToUser(userRequest);
        User updatedUser = userService.update(id, user);
        return updatedUser != null ? updatedUser.getId() : null;
    }

    @GetMapping("/delete/{id}")
    public Long deleteUser(@RequestParam Long id) {
        return userService.delete(id);
    }
}