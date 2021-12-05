package com.iwmstudio.belight.viewmodel;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;
import androidx.lifecycle.ViewModel;

public class ProActivityViewModel extends ViewModel {

    //Little changes in this piece of code
    float[] dst; //Global

    @BindingAdapter("bind:imagePro")
    public static void bindImagePro(ImageView imageView , String nullable)
    {

    }

}
