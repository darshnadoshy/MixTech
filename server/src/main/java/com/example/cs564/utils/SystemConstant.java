package com.example.cs564.utils;

public class SystemConstant {

    // token
    public static final int RESCODE_REFTOKEN_MSG = 1006;		// refresh TOKEN(with message)
    public static final int RESCODE_REFTOKEN = 1007;			// refresh TOKEN

    public static final int JWT_ERRCODE_NULL = 4000;			//Token not exist
    public static final int JWT_ERRCODE_EXPIRE = 4001;			//Token expired
    public static final int JWT_ERRCODE_FAIL = 4002;			//authentication failed

    // JWT
    public static final String JWT_SECERT = "8677df7fc3a34e26a61c034d5ec8245d";			//secrete key
    public static final long JWT_TTL = 60 * 60 * 1000;

    // ret
    public static final int RET_ERR = -1;
    public static final int RET_SUC = 1;

    // msg
    public static final String MSG_SUCCESS = "success!";
    public static final String MSG_FAIL = "failed!";
    public static final String MSG_USER_DNE = "user not found!";
    public static final String MSG_USER_DUP = "user already existed!";

    public static final String MSG_UNAUTH_ACCESS = "Sorry, operation denied!";

}
