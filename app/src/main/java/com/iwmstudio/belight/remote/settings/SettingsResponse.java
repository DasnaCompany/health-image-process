package com.iwmstudio.belight.remote.settings;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.iwmstudio.belight.model.Settings;

public class SettingsResponse {

    @SerializedName("status")
    @Expose
    private int status;

    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("data")
    @Expose
    private Settings data;

    public SettingsResponse(int status, String message, Settings data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Settings getData() {
        return data;
    }

    public void setData(Settings data) {
        this.data = data;
    }

}
