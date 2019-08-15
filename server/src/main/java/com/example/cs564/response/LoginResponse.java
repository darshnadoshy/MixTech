package com.example.cs564.response;

import lombok.Data;

/**
 * notifying the fronted if the login succeeds or not
 */

@Data
public class LoginResponse {
    private int ret;
    private String token;
    private String msg;
    private Long uid;
    private String uname;

    public LoginResponse() {}

    public LoginResponse(int ret, String token, String msg) {
        this.ret = ret;
        this.token = token;
        this.msg = msg;
    }
}
