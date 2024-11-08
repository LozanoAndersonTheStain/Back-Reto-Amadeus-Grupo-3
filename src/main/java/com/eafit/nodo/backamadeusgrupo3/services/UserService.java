package com.eafit.nodo.backamadeusgrupo3.services;

import com.eafit.nodo.backamadeusgrupo3.contracts.request.UserRequest;
import com.eafit.nodo.backamadeusgrupo3.entities.UserEntity;
import com.eafit.nodo.backamadeusgrupo3.exeptions.*;
import com.eafit.nodo.backamadeusgrupo3.mappers.interfaces.UserMapper;
import com.eafit.nodo.backamadeusgrupo3.models.User;
import com.eafit.nodo.backamadeusgrupo3.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    public User authenticate(UserRequest userRequest) {
        Optional<UserEntity> userEntityOptional = userRepository.findByEmail(userRequest.getEmail());
        if (userEntityOptional.isPresent()) {
            UserEntity userEntity = userEntityOptional.get();
            if(userEntity.getName().equals(userRequest.getName())
                    && userEntity.getBirthdate().equals(userRequest.getBirthdate())) {
                return userMapper.mapUserEntityToUser(userEntity);
            }
        }
        throw new UserNotFoundException("User not found or credentials are incorrect");
    }

    public User create(User user) {
        if (user.getName() == null || user.getEmail() == null || user.getBirthdate() == null) {
            throw new InvalidUserDataException("Name, email and birthdate are required");
        }
        UserEntity userEntity = userMapper.mapUserToUserEntity(user);
        UserEntity savedUserEntity = userRepository.save(userEntity);
        return userMapper.mapUserEntityToUser(savedUserEntity);
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
            userEntity.setBirthdate(user.getBirthdate());
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
