package com.iwmstudio.belight.remote.login;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.iwmstudio.belight.model.Login;

public class LoginResponse {

    @SerializedName("status")
    @Expose
    private String status;

    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("data")
    @Expose
    private Login data;

    public LoginResponse(String status, String message, Login data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Login getData() {
        return data;
    }

    public void setData(Login data) {
        this.data = data;
    }

}
