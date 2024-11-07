package com.eafit.nodo.backamadeusgrupo3.mappers.interfaces;

import com.eafit.nodo.backamadeusgrupo3.contracts.request.UserRequest;
import com.eafit.nodo.backamadeusgrupo3.contracts.responses.UserResponse;
import com.eafit.nodo.backamadeusgrupo3.entities.UserEntity;
import com.eafit.nodo.backamadeusgrupo3.models.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserEntity mapUserRequestToUserEntity(UserRequest userRequest);

    UserEntity mapUserToUserEntity(User user);

    User mapUserEntityToUser(UserEntity userEntity);

    User mapUserRequestToUser(UserRequest userRequest);

    UserRequest mapUserToUserRequest(User user);

    UserResponse mapUserToUserResponse(User user);

    List<UserResponse> mapUserModelListToUserResponseList(List<User> users);
}