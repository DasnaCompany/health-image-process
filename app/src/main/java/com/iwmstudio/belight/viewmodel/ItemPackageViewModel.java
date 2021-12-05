package com.iwmstudio.belight.viewmodel;


import android.content.Context;
import android.content.Intent;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.iwmstudio.belight.model.Packages;
import com.iwmstudio.belight.view.PackageActivity;
import com.squareup.picasso.Picasso;

public class ItemPackageViewModel {

    private int id;
    private int pack;
    private String name;
    private String description;
    private String thumb;
    private String del_price;
    private String price;
    private String time;

    public ItemPackageViewModel(Packages packages) {
        this.id = packages.getId();
        this.pack = packages.getPack();
        this.name = packages.getName();
        this.description = packages.getDescription();
        this.thumb = packages.getThumb();
        this.del_price = packages.getDel_price();
        this.price = packages.getPrice();
        this.time = packages.getTime();
    }

    public void openPack(Context context)
    {
        Intent intent = new Intent(context , PackageActivity.class);
        intent.putExtra("pack" , String.valueOf(id) );
        context.startActivity(intent);
    }

    @BindingAdapter("bind:packageImage")
    public static void bindPackageImage(ImageView imageView , String url)
    {
        Picasso.get().load(url).into(imageView);
    }

    public int getId() {
        return id;
    }

    public int getPack() {
        return pack;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getThumb() {
        return thumb;
    }

    public String getDel_price() {
        return del_price;
    }

    public String getPrice() {
        return price;
    }

    public String getTime() {
        return time;
    }

}
