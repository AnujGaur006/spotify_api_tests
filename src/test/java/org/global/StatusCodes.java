package org.global;

public enum StatusCodes {
    STATUS_CODE_200(200,""),
    STATUS_CODE_201(201,""),
    STATUS_CODE_400(400,"Missing required field: name"),
    STATUS_CODE_401(401,"Invalid access token")
    ;

    public final int code;
    public final String message;

    StatusCodes(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
