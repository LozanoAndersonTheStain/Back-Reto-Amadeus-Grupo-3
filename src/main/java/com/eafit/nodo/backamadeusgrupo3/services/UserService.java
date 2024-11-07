package com.eafit.nodo.backamadeusgrupo3.services;

import com.eafit.nodo.backamadeusgrupo3.contracts.request.UserRequest;
import com.eafit.nodo.backamadeusgrupo3.entities.UserEntity;
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
        return null;
    }

    public User create(User user) {
        UserEntity userEntity = userMapper.mapUserToUserEntity(user);
        UserEntity savedUserEntity = userRepository.save(userEntity);
        return userMapper.mapUserEntityToUser(savedUserEntity);
    }

    public List<User> findAll() {
        return userRepository.findAll().stream()
                .map(userMapper::mapUserEntityToUser)
                .collect(Collectors.toList());
    }

    public User findById(Long id) {
        Optional<UserEntity> userEntityOptional = userRepository.findById(id);
        return userEntityOptional.map(userMapper::mapUserEntityToUser).orElse(null);
    }
}
