package com.example.cs564.response;

import lombok.Data;

@Data
public class LoginResponse {
    private int ret;
    private String token;

    public LoginResponse() {}

    public LoginResponse(int ret, String token) {
        this.ret = ret;
        this.token = token;
    }
}
