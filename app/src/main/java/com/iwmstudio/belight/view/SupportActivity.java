package com.iwmstudio.belight.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.iwmstudio.belight.R;
import com.iwmstudio.belight.databinding.ActivitySupportBinding;
import com.iwmstudio.belight.model.Settings;
import com.iwmstudio.belight.remote.settings.SettingsRepository;
import com.iwmstudio.belight.viewmodel.SupportActivityViewModel;

public class SupportActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivitySupportBinding activitySupportBinding = DataBindingUtil.setContentView(this ,R.layout.activity_support);
        activitySupportBinding.setLifecycleOwner(this);

        SupportActivityViewModel supportActivityViewModel = new ViewModelProvider(this).get(SupportActivityViewModel.class);
        activitySupportBinding.setSupport(supportActivityViewModel);

        SettingsRepository settingsRepository = new SettingsRepository();
        settingsRepository.getSettingsMutableLiveData().observe(this, new Observer<Settings>() {
            @Override
            public void onChanged(Settings settings) {
                supportActivityViewModel.getPhone().setValue(settings.getContact());
                supportActivityViewModel.getTelegram().setValue(settings.getTelegram());
                supportActivityViewModel.getWhatsapp().setValue(settings.getWhatsapp());
            }
        });

        supportActivityViewModel.getCallAction().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                if(integer != 0)
                {
                    supportActivityViewModel.getCallAction().setValue(0);
                    switch (integer)
                    {
                        case 1:
                            // WhatsApp
                            String url = supportActivityViewModel.getWhatsapp().getValue();
                            Intent i = new Intent(Intent.ACTION_VIEW);
                            i.setData(Uri.parse(url));
                            startActivity(i);
                            break;
                        case 2:
                            // Telegram
                            String url2 = supportActivityViewModel.getTelegram().getValue();
                            Intent i2 = new Intent(Intent.ACTION_VIEW);
                            i2.setData(Uri.parse(url2));
                            startActivity(i2);
                            break;
                    }
                }
            }
        });

        supportActivityViewModel.getFinish().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if(aBoolean)
                    finish();
            }
        });
    }
}