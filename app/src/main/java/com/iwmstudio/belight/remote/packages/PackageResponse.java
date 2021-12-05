package com.iwmstudio.belight.remote.packages;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.iwmstudio.belight.model.Packages;

import java.util.ArrayList;

public class PackageResponse {

    @SerializedName("status")
    @Expose
    private int status;

    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("data")
    @Expose
    private ArrayList<Packages> data;

    public PackageResponse(int status, String message, ArrayList<Packages> data) {
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

    public ArrayList<Packages> getData() {
        return data;
    }

}