package com.iwmstudio.belight.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import com.iwmstudio.belight.R;
import com.iwmstudio.belight.databinding.ActivitySplashBinding;
import com.iwmstudio.belight.viewmodel.SplashActivityViewModel;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivitySplashBinding activitySplashBinding = DataBindingUtil.setContentView(this , R.layout.activity_splash);

        SplashActivityViewModel activitySplashViewModel = new ViewModelProvider(this).get(SplashActivityViewModel.class);
        activitySplashBinding.setSplash(activitySplashViewModel);

        final Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this , MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 8000);

    }
}