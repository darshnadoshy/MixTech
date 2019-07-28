package com.example.cs564.controller;

import com.example.cs564.entity.UserEntity;
import com.example.cs564.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;
//    @Autowired
//    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @RequestMapping(value = "/login")
    public String login(String username, String password, HttpServletResponse response) {
        return null;
    }

    @RequestMapping(value = "/register")
    public void register(@RequestBody UserEntity userEntity) {
//        userEntity.setPassword(bCryptPasswordEncoder.encode(userEntity.getPassword()));
        userService.create(userEntity);
    }
}
