package com.iwmstudio.belight.remote.packages;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.iwmstudio.belight.model.Packages;

public class PackResponse {

    @SerializedName("status")
    @Expose
    private int status;

    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("data")
    @Expose
    private Packages data;

    public PackResponse(int status, String message, Packages data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public Packages getData() {
        return data;
    }

}
