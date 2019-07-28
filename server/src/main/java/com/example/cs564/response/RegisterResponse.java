package com.example.cs564.response;

import lombok.Data;

@Data
public class RegisterResponse {
    private int ret;
    private String msg;

    public RegisterResponse() {}

    public RegisterResponse(int ret, String msg) {
        this.ret = ret;
        this.msg = msg;
    }
}
