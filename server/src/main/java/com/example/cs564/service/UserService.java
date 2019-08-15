package com.example.cs564.service;

import com.example.cs564.entity.UserEntity;

public interface UserService {
    public UserEntity getByEmail(String email);
    public void create(UserEntity userEntity);
}
