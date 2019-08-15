package com.example.cs564.service.impl;

import com.example.cs564.dao.UserRepo;
import com.example.cs564.entity.UserEntity;
import com.example.cs564.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * user service implementation
 */
@Service("UserService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;

    /**
     * get a user by email
     * @param email user email
     * @return user
     */
    @Override
    public UserEntity getByEmail(String email) {
        UserEntity userEntity = userRepo.findByEmail(email);
        return userEntity;
    }

    /**
     * create/save new user info
     * @param userEntity user info
     */
    @Override
    public void create(UserEntity userEntity) {
        userRepo.save(userEntity);
    }
}
