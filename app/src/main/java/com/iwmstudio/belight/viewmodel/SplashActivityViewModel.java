package com.iwmstudio.belight.viewmodel;

import android.net.Uri;
import android.widget.VideoView;

import androidx.databinding.BindingAdapter;
import androidx.lifecycle.ViewModel;

import com.iwmstudio.belight.R;

public class SplashActivityViewModel extends ViewModel {

    @BindingAdapter("bind:videoView")
    public static void bindVideoPlayer(VideoView videoView , String nullable)
    {
        String path = "android.resource://" + videoView.getContext().getPackageName() + "/" + R.raw.welcome;
        videoView.setVideoURI(Uri.parse(path));
        videoView.start();
    }

}
