package com.iwmstudio.belight;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.iwmstudio.belight.databinding.ActivityCameraBinding;
import com.iwmstudio.belight.viewmodel.CameraActivityViewModel;

public class CameraActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityCameraBinding activityCameraBinding = DataBindingUtil.setContentView(this , R.layout.activity_camera);
        activityCameraBinding.setLifecycleOwner(this);

        CameraActivityViewModel cameraActivityViewModel = new ViewModelProvider(this).get(CameraActivityViewModel.class);
        activityCameraBinding.setCamera(cameraActivityViewModel);

    }
}