package com.example.cs564.response;

import lombok.Data;

@Data
public class LoginResponse {
    private int ret;
    private String token;
    private String msg;

    public LoginResponse() {}

    public LoginResponse(int ret, String token, String msg) {
        this.ret = ret;
        this.token = token;
        this.msg = msg;
    }
}
