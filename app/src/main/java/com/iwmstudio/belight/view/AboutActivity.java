package com.iwmstudio.belight.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import com.iwmstudio.belight.R;
import com.iwmstudio.belight.databinding.ActivityAboutBinding;
import com.iwmstudio.belight.model.Settings;
import com.iwmstudio.belight.remote.settings.SettingsRepository;
import com.iwmstudio.belight.viewmodel.AboutActivityViewModel;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityAboutBinding activityAboutBinding = DataBindingUtil.setContentView(this ,  R.layout.activity_about);
        activityAboutBinding.setLifecycleOwner(this);

        AboutActivityViewModel aboutActivityViewModel = new ViewModelProvider(this).get(AboutActivityViewModel.class);
        activityAboutBinding.setAbout(aboutActivityViewModel);

        SettingsRepository settingsRepository = new SettingsRepository();
        settingsRepository.getSettingsMutableLiveData().observe(this, new Observer<Settings>() {
            @Override
            public void onChanged(Settings settings) {
                aboutActivityViewModel.getAbout().setValue(settings.getAbout_text());
            }
        });

        aboutActivityViewModel.getContact().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if (aBoolean)
                {
                    aboutActivityViewModel.getContact().setValue(false);
                    Intent intent = new Intent(AboutActivity.this , SupportActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });

        aboutActivityViewModel.getFinish().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if(aBoolean)
                    finish();
            }
        });

    }
}