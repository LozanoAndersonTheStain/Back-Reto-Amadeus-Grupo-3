package com.eafit.nodo.backamadeusgrupo3.services;

import com.eafit.nodo.backamadeusgrupo3.contracts.request.UserRequest;
import com.eafit.nodo.backamadeusgrupo3.entities.UserEntity;
import com.eafit.nodo.backamadeusgrupo3.exeptions.user.InvalidUserDataException;
import com.eafit.nodo.backamadeusgrupo3.exeptions.user.UserAlreadyExistsException;
import com.eafit.nodo.backamadeusgrupo3.exeptions.user.UserNotFoundException;
import com.eafit.nodo.backamadeusgrupo3.mappers.interfaces.UserMapper;
import com.eafit.nodo.backamadeusgrupo3.models.User;
import com.eafit.nodo.backamadeusgrupo3.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public User authenticate(UserRequest userRequest) {
        Optional<UserEntity> userEntityOptional = userRepository.findByEmail(userRequest.getEmail());
        if (userEntityOptional.isPresent()) {
            UserEntity userEntity = userEntityOptional.get();
            if (userEntity.getName().equals(userRequest.getName())) {
                return userMapper.mapUserEntityToUser(userEntity);
            }
        }
        throw new UserNotFoundException("User not found or credentials are incorrect");
    }

    public User create(User user) {
        if (user.getName() == null || user.getEmail() == null) {
            throw new InvalidUserDataException("Name, email and birthdate are required");
        }
        Optional<UserEntity> existingUser = userRepository.findByNameAndEmail(user.getName(), user.getEmail());
        if (existingUser.isPresent()) {
            throw new UserAlreadyExistsException("User with name " + user.getName() + " and email " + user.getEmail() + " already exists");
        }
        UserEntity userEntity = userMapper.mapUserToUserEntity(user);
        UserEntity savedUserEntity = userRepository.save(userEntity);
        return userMapper.mapUserEntityToUser(savedUserEntity);
    }

public List<User> createMultipleUsers(List<User> users) {
    if (users == null || users.isEmpty()) {
        throw new InvalidUserDataException("User list cannot be null or empty");
    }

    List<UserEntity> userEntities = users.stream()
            .map(user -> {
                if (user.getName() == null || user.getEmail() == null) {
                    throw new InvalidUserDataException("Name, email, and birthdate are required for all users");
                }
                if (userRepository.existsByEmail(user.getEmail())) {
                    throw new UserAlreadyExistsException("User with email " + user.getEmail() + " already exists");
                }
                return userMapper.mapUserToUserEntity(user);
            })
            .collect(Collectors.toList());

    List<UserEntity> savedUserEntities = userRepository.saveAll(userEntities);
    return savedUserEntities.stream()
            .map(userMapper::mapUserEntityToUser)
            .collect(Collectors.toList());
}

    public List<User> findAll() {
        if (userRepository.count() == 0) {
            throw new UserNotFoundException("No users found");
        }
        return userRepository.findAll().stream()
                .map(userMapper::mapUserEntityToUser)
                .collect(Collectors.toList());
    }

    public User findById(Long id) {
        Optional<UserEntity> userEntityOptional = userRepository.findById(id);
        return userEntityOptional.map(userMapper::mapUserEntityToUser)
                .orElseThrow(() -> new UserNotFoundException("User with id " + id + " not found"));
    }

    public User update(Long id, User user) {
        Optional<UserEntity> userEntityOptional = userRepository.findById(id);
        if (userEntityOptional.isPresent()) {
            UserEntity userEntity = userEntityOptional.get();
            userEntity.setName(user.getName());
            userEntity.setEmail(user.getEmail());
            UserEntity updatedUserEntity = userRepository.save(userEntity);
            return userMapper.mapUserEntityToUser(updatedUserEntity);
        }
        throw new UserNotFoundException("User with id " + id + " not found");
    }

    public Long delete(Long id) {
        if (!userRepository.existsById(id)) {
            throw new UserNotFoundException("User with id " + id + " not found");
        }
        userRepository.deleteById(id);
        return id;
    }
}
