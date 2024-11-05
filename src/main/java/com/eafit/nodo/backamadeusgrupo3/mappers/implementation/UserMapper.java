package com.eafit.nodo.backamadeusgrupo3.mappers.implementation;

import com.eafit.nodo.backamadeusgrupo3.contracts.request.UserRequest;
import com.eafit.nodo.backamadeusgrupo3.contracts.responses.UserResponse;
import com.eafit.nodo.backamadeusgrupo3.models.User;

public class UserMapper {
    public User mapUserModelToUser(User model) {
        return User.builder()
                .name(model.getName())
                .email(model.getEmail())
                .birthdate(model.getBirthdate())
                .DNI(model.getDNI())
                .build();
    }

    public User mapUserToUserModel(User entity) {
        return User.builder()
                .name(entity.getName())
                .email(entity.getEmail())
                .birthdate(entity.getBirthdate())
                .DNI(entity.getDNI())
                .build();
    }

    public UserResponse mapUserToUserResponse(User model) {
        return UserResponse.builder()
                .name(model.getName())
                .email(model.getEmail())
                .birthdate(model.getBirthdate())
                .build();
    }

    public UserRequest mapUserToUserRequest(UserRequest userRequest) {
        return UserRequest.builder()
                .name(userRequest.getName())
                .email(userRequest.getEmail())
                .birthdate(userRequest.getBirthdate())
                .DNI(userRequest.getDNI())
                .build();
    }
}
