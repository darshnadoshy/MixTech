package com.example.cs564.response;

import lombok.Data;

/**
 * standard response to parse info to the frontend
 */
@Data
public class StandardResponse {
    private int ret;
    private String msg;

    public StandardResponse() {}

    public StandardResponse(int ret, String msg) {
        this.ret = ret;
        this.msg = msg;
    }
}
