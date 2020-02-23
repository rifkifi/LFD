package com.rifkifi.lfd.models;

import com.google.gson.annotations.SerializedName;

public class LoginResponse {
    @SerializedName("error")
    private boolean error;

    @SerializedName("message")
    private String message;

    @SerializedName("praktikan")
    private Praktikan praktikan;

    public LoginResponse(boolean error, String message, Praktikan praktikan) {
        this.error = error;
        this.message = message;
        this.praktikan = praktikan;
    }

    public boolean isError() {
        return error;
    }

    public String getMessage() {
        return message;
    }

    public Praktikan getPraktikan() {
        return praktikan;
    }
}
