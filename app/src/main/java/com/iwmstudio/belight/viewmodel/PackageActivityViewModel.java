package com.iwmstudio.belight.viewmodel;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.squareup.picasso.Picasso;

public class PackageActivityViewModel extends ViewModel {

    private final MutableLiveData<Boolean> finish = new MutableLiveData<>();

    private final MutableLiveData<Boolean> buy = new MutableLiveData<>();

    private final MutableLiveData<String> image = new MutableLiveData<>();
    private final MutableLiveData<String> title = new MutableLiveData<>();
    private final MutableLiveData<String> del_price = new MutableLiveData<>();
    private final MutableLiveData<String> price = new MutableLiveData<>();
    private final MutableLiveData<String> content = new MutableLiveData<>();

    public void finish()
    {
        finish.setValue(true);
    }

    public void buy()
    {
        buy.setValue(true);
    }

    @BindingAdapter("bind:packageBigImage")
    public static void bindPackageBigImage(ImageView imageView , String image)
    {
        Picasso.get().load(image).into(imageView);
    }

    public MutableLiveData<Boolean> getFinish() {
        return finish;
    }

    public MutableLiveData<String> getImage() {
        return image;
    }

    public MutableLiveData<String> getTitle() {
        return title;
    }

    public MutableLiveData<String> getDel_price() {
        return del_price;
    }

    public MutableLiveData<String> getPrice() {
        return price;
    }

    public MutableLiveData<String> getContent() {
        return content;
    }

    public MutableLiveData<Boolean> getBuy() {
        return buy;
    }

}
