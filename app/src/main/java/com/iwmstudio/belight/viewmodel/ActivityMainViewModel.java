package com.iwmstudio.belight.viewmodel;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.iwmstudio.belight.utils.CircleTransform;
import com.squareup.picasso.Picasso;

import pl.bclogic.pulsator4droid.library.PulsatorLayout;

public class ActivityMainViewModel extends ViewModel {

    // Activity
    private final MutableLiveData<Boolean> about = new MutableLiveData<>(false);
    private final MutableLiveData<Boolean> packages = new MutableLiveData<>(false);
    private final MutableLiveData<Boolean> contact = new MutableLiveData<>(false);
    private final MutableLiveData<Boolean> body = new MutableLiveData<>(false);
    private final MutableLiveData<Boolean> profile = new MutableLiveData<>(false);

    private final MutableLiveData<Boolean> login = new MutableLiveData<>();

    public ActivityMainViewModel()
    {
        
    }

    @BindingAdapter("bind:userImage")
    public static void bindUserImage(ImageView imageView , String url)
    {
        Picasso.get().load(url).transform(new CircleTransform()).into(imageView);
    }

    @BindingAdapter("bind:pulsePackages")
    public static void bindPulsePackages(PulsatorLayout pulsatorLayout, String url)
    {
        pulsatorLayout.start();
    }

    public void login()
    {
        login.setValue(true);
    }

    public void openProfile()
    {
        profile.setValue(true);
    }

    public void openSupport()
    {
        contact.setValue(true);
    }

    public void openAbout()
    {
        about.setValue(true);
    }

    public void openPackages()
    {
        packages.setValue(true);
    }

    public void openPro()
    {
        body.setValue(true);
    }

    public MutableLiveData<Boolean> getProfile() {
        return profile;
    }

    public MutableLiveData<Boolean> getAbout() {
        return about;
    }

    public MutableLiveData<Boolean> getPackages() {
        return packages;
    }

    public MutableLiveData<Boolean> getContact() {
        return contact;
    }

    public MutableLiveData<Boolean> getBody() {
        return body;
    }

    public MutableLiveData<Boolean> getLogin() {
        return login;
    }

}
