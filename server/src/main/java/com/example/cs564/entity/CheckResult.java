package com.example.cs564.entity;

import io.jsonwebtoken.Claims;
import lombok.Data;

/**
 * an entity used for jwt token
 */

@Data
public class CheckResult {
    private int errCode;
    private boolean success;
    private Claims claims;
}
