package com.iwmstudio.belight.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.iwmstudio.belight.viewmodel.ItemPackageViewModel;

public class Packages {

    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("pack")
    @Expose
    private int pack;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("thumb")
    @Expose
    private String thumb;

    @SerializedName("del_price")
    @Expose
    private String del_price;

    @SerializedName("price")
    @Expose
    private String price;

    @SerializedName("time")
    @Expose
    private String time;

    public Packages(int id, int pack, String name, String description, String thumb, String del_price, String price, String time) {
        this.id = id;
        this.pack = pack;
        this.name = name;
        this.description = description;
        this.thumb = thumb;
        this.del_price = del_price;
        this.price = price;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPack() {
        return pack;
    }

    public void setPack(int pack) {
        this.pack = pack;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public String getDel_price() {
        return del_price;
    }

    public void setDel_price(String del_price) {
        this.del_price = del_price;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

}
