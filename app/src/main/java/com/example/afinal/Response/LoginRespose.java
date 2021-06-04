package com.example.afinal.Response;

public class LoginRespose {

    String message;
    int code;
    String key;


    public LoginRespose(String message, int code, String key) {
        this.message = message;
        this.code = code;
        this.key = key;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
