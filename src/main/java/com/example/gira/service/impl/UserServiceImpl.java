package com.example.gira.service.impl;

import com.example.gira.model.entity.UserEntity;
import com.example.gira.model.serviceModel.UserServiceModel;
import com.example.gira.repository.UserRepository;
import com.example.gira.service.UserService;
import com.example.gira.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
    }

    @Override
    public Boolean checkUserByUsernameAndPassword(String username, String password) {
        return this.userRepository.existsByUsernameAndEmail(
                username,
                password
        );
    }

    @Override
    public void registerUser(UserServiceModel userRegisterServiceModel) {
        this.userRepository.save(
                modelMapper.map(userRegisterServiceModel, UserEntity.class)
        );
    }

    @Override
    public Boolean loginUser(UserServiceModel userServiceModel) {

        UserEntity user = this.userRepository.findByEmailAndPassword(
                userServiceModel.getEmail(),
                userServiceModel.getPassword()
        ).orElse(null);

        if (user != null) {
            currentUser.setUsername(user.getUsername())
                    .setId(user.getId());

            return true;
        }

        return false;

    }

    @Override
    public UserEntity findUserById(Long id) {
        return this.userRepository.findById(id).orElse(null);
    }

}
