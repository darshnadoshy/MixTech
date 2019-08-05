package com.example.cs564.controller;

import com.example.cs564.entity.UserEntity;
import com.example.cs564.response.LoginResponse;
import com.example.cs564.response.RegisterResponse;
import com.example.cs564.service.UserService;
import com.example.cs564.utils.JwtUtils;
import com.example.cs564.utils.SystemConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Base64;


@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;
//    @Autowired
//    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    @CrossOrigin(origins = "http://localhost:3000")
    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public LoginResponse login(@RequestParam String email, @RequestParam String password) {
        LoginResponse loginResponse = new LoginResponse();
        UserEntity userEntity = userService.getByEmail(email);
        if (userEntity == null) {
            loginResponse.setRet(SystemConstant.RET_ERR);
            loginResponse.setMsg(SystemConstant.MSG_USER_DNE);
            return loginResponse;
        }
        String decodedPassord = new String(Base64.getDecoder().decode(userEntity.getPassword()));
        if (decodedPassord.equals(password)) {
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
    @ResponseBody
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public RegisterResponse register(@RequestBody UserEntity userEntity) {
//        userEntity.setPassword(bCryptPasswordEncoder.encode(userEntity.getPassword()));
        RegisterResponse registerResponse = new RegisterResponse();
        if (userService.getByEmail(userEntity.getEmail()) != null) {
            registerResponse.setRet(SystemConstant.RET_ERR);
            registerResponse.setMsg(SystemConstant.MSG_USER_DUP);
        } else if(userEntity.getPassword() == null) {
            registerResponse.setRet(SystemConstant.RET_ERR);
            registerResponse.setMsg("password cannot be empty!");
        } else if (userEntity.getUname() == null) {
            registerResponse.setRet(SystemConstant.RET_ERR);
            registerResponse.setMsg("username cannot be empty!");
        } else {
            userEntity.setPassword(Base64.getEncoder().encodeToString(userEntity.getPassword().getBytes()));
            userService.create(userEntity);
            registerResponse.setRet(SystemConstant.RET_SUC);
            registerResponse.setMsg(SystemConstant.MSG_SUCCESS);
        }
        return registerResponse;
    }

//    @RequestMapping(value = "/logout", method = RequestMethod.GET)
//    public void logout(@RequestBody HttpSession httpSession) {
//        httpSession.invalidate();
//    }
}
