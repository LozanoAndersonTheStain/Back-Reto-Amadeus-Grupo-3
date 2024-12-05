package com.eafit.nodo.backamadeusgrupo3.mappers.implementation;

import com.eafit.nodo.backamadeusgrupo3.contracts.request.UserRequest;
import com.eafit.nodo.backamadeusgrupo3.contracts.responses.UserResponse;
import com.eafit.nodo.backamadeusgrupo3.entities.UserEntity;
import com.eafit.nodo.backamadeusgrupo3.models.User;

public class UserMapper {
    public User mapUserModelToUser(User model) {
        return User.builder()
                .name(model.getName())
                .email(model.getEmail())
                .build();
    }
User user = User.builder()
        .name("Juan Pérez")
        .email("juan.perez@example.com")
        .build();

UserResponse userResponse = UserMapper.mapUserToUserResponse(user);
    public User mapUserToUserModel(User entity) {
        return User.builder()
                .name(entity.getName())
                .email(entity.getEmail())
                .build();
    }

    public static UserResponse mapUserToUserResponse(User model) {
        return UserResponse.builder()
                .name(model.getName())
                .email(model.getEmail())
                .build();
    }

    public UserRequest mapUserToUserRequest(UserRequest userRequest) {
        return UserRequest.builder()
                .name(userRequest.getName())
                .email(userRequest.getEmail())
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
