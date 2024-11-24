package com.eafit.nodo.backamadeusgrupo3.mappers.implementation;

import com.eafit.nodo.backamadeusgrupo3.contracts.request.UserRequest;
import com.eafit.nodo.backamadeusgrupo3.contracts.responses.UserResponse;
import com.eafit.nodo.backamadeusgrupo3.entities.UserEntity;
import com.eafit.nodo.backamadeusgrupo3.models.User;

import java.util.Date;

public class UserMapper {
    public User mapUserModelToUser(User model) {
        return User.builder()
                .name(model.getName())
                .email(model.getEmail())
                .birthdate(model.getBirthdate())
                .build();
    }
User user = User.builder()
        .name("Juan Pérez")
        .email("juan.perez@example.com")
        .birthdate(new Date())
        .build();

UserResponse userResponse = UserMapper.mapUserToUserResponse(user);
    public User mapUserToUserModel(User entity) {
        return User.builder()
                .name(entity.getName())
                .email(entity.getEmail())
                .birthdate(entity.getBirthdate())
                .build();
    }

    public static UserResponse mapUserToUserResponse(User model) {
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
                .build();
    }

    public User toUser(UserEntity userEntity) {
        if (userEntity == null) {
            return null;
        }
        return User.builder()
                .id(userEntity.getId())
                .name(userEntity.getName())
                .email(userEntity.getEmail())
                .build();
    }

    public UserEntity toUserEntity(User user) {
        if (user == null) {
            return null;
        }

        return UserEntity.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }
}
