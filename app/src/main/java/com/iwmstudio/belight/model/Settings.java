package com.iwmstudio.belight.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Settings {

    @SerializedName("about_text")
    @Expose
    private String about_text;

    @SerializedName("whatsapp")
    @Expose
    private String whatsapp;

    @SerializedName("telegram")
    @Expose
    private String telegram;

    @SerializedName("contact")
    @Expose
    private String contact;

    public Settings(String about_text, String whatsapp, String telegram, String contact) {
        this.about_text = about_text;
        this.whatsapp = whatsapp;
        this.telegram = telegram;
        this.contact = contact;
    }

    public String getAbout_text() {
        return about_text;
    }

    public void setAbout_text(String about_text) {
        this.about_text = about_text;
    }

    public String getWhatsapp() {
        return whatsapp;
    }

    public void setWhatsapp(String whatsapp) {
        this.whatsapp = whatsapp;
    }

    public String getTelegram() {
        return telegram;
    }

    public void setTelegram(String telegram) {
        this.telegram = telegram;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

}
