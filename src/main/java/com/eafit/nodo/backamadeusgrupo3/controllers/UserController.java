package com.eafit.nodo.backamadeusgrupo3.controllers;

import com.eafit.nodo.backamadeusgrupo3.contracts.request.UserRequest;
import com.eafit.nodo.backamadeusgrupo3.contracts.responses.UserResponse;
import com.eafit.nodo.backamadeusgrupo3.mappers.interfaces.UserMapper;
import com.eafit.nodo.backamadeusgrupo3.models.User;
import com.eafit.nodo.backamadeusgrupo3.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
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
    public Long crearUser(@RequestParam String name, @RequestParam String email, @RequestParam String password, @RequestParam Date birthdate, @RequestParam String DNI) {
        UserRequest userRequest = UserRequest.builder()
                .name(name)
                .email(email)
                .password(password)
                .birthdate(birthdate)
                .DNI(DNI)
                .build();
        User user = userMapper.mapUserRequestToUser(userRequest);
        User createdUser = userService.create(user);
        return createdUser.getId();
    }

    @PostMapping("/authenticate")
    public UserResponse authenticate(@RequestParam String email, @RequestParam String password) {
        UserRequest userRequest = UserRequest.builder()
                .email(email)
                .password(password)
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
}
