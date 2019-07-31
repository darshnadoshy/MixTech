package com.example.cs564.controller;

import com.example.cs564.entity.UserEntity;
import com.example.cs564.response.LoginResponse;
import com.example.cs564.response.RegisterResponse;
import com.example.cs564.service.UserService;
import com.example.cs564.utils.JwtUtils;
import com.example.cs564.utils.SystemConstant;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public LoginResponse login(String email, String password) {
        LoginResponse loginResponse = new LoginResponse();
        UserEntity userEntity = userService.getByEmail(email);
        if (userEntity == null) {
            loginResponse.setRet(SystemConstant.RET_ERR);
            loginResponse.setMsg(SystemConstant.MSG_USER_DNE);
            return loginResponse;
        }
        if (userEntity.getPassword().equals(password)) {
            String jwt = JwtUtils.createJWT(userEntity.getUid().toString(),
                    userEntity.getEmail(), SystemConstant.JWT_TTL);
            loginResponse.setRet(SystemConstant.RET_SUC);
            loginResponse.setToken(jwt);
            loginResponse.setMsg(SystemConstant.MSG_SUCCESS);
        } else {
            loginResponse.setRet(SystemConstant.RET_ERR);
            loginResponse.setMsg(SystemConstant.MSG_FAIL);
        }
        return loginResponse;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public RegisterResponse register(@RequestBody UserEntity userEntity) {
//        userEntity.setPassword(bCryptPasswordEncoder.encode(userEntity.getPassword()));
        System.out.println(userEntity);
        RegisterResponse registerResponse = new RegisterResponse();
        if (userService.getByEmail(userEntity.getEmail()) != null) {
            registerResponse.setRet(SystemConstant.RET_ERR);
            registerResponse.setMsg(SystemConstant.MSG_USER_DUP);
        } else {
            userService.create(userEntity);
            registerResponse.setRet(SystemConstant.RET_SUC);
            registerResponse.setMsg(SystemConstant.MSG_SUCCESS);
        }
        return registerResponse;
    }
}
