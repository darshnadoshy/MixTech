package com.example.cs564.controller;

import com.example.cs564.entity.UserEntity;
import com.example.cs564.response.LoginResponse;
import com.example.cs564.response.RegisterResponse;
import com.example.cs564.service.UserService;
import com.example.cs564.utils.JwtUtils;
import com.example.cs564.utils.SystemConstant;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    public LoginResponse login(String email, String password, HttpServletResponse response) {
        UserEntity userEntity = userService.getByEmail(email);

        if (userEntity.getPassword().equals(password)) {
            String jwt = JwtUtils.createJWT(userEntity.getUid().toString(),
                    userEntity.getEmail(), SystemConstant.JWT_TTL);
        } else {

        }
        return null;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public RegisterResponse register(@RequestBody UserEntity userEntity) {
//        userEntity.setPassword(bCryptPasswordEncoder.encode(userEntity.getPassword()));
        RegisterResponse registerResponse = new RegisterResponse();
        if (userService.getByEmail(userEntity.getEmail()) != null) {
            registerResponse.setRet(-1);
            registerResponse.setMsg("Account has already existed.");
        } else {
            userService.create(userEntity);
            registerResponse.setRet(1);
            registerResponse.setMsg("Success!");
        }
        return registerResponse;
    }
}
