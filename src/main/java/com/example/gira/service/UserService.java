package com.example.gira.service;

import com.example.gira.model.entity.UserEntity;
import com.example.gira.model.serviceModel.UserServiceModel;

public interface UserService {
    Boolean checkUserByUsernameAndPassword(String username, String password);

    void registerUser(UserServiceModel map);


    Boolean loginUser(UserServiceModel userServiceModel);

    UserEntity findUserById(Long id);
}
