package com.iwmstudio.belight.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import com.iwmstudio.belight.R;
import com.iwmstudio.belight.databinding.ActivityProfileBinding;
import com.iwmstudio.belight.viewmodel.ProfileActivityViewModel;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityProfileBinding activityProfileBinding = DataBindingUtil.setContentView(this , R.layout.activity_profile);
        activityProfileBinding.setLifecycleOwner(this);

        ProfileActivityViewModel profileActivityViewModel = new ProfileActivityViewModel();
        activityProfileBinding.setProfile(profileActivityViewModel);

        SharedPreferences prefs = getSharedPreferences("prefs", MODE_PRIVATE);
        String name = prefs.getString("name", null);//"No name defined" is the default value.
        String phone = prefs.getString("phone", null);//"No name defined" is the default value.
        String email = prefs.getString("email", null);//"No name defined" is the default value.
        profileActivityViewModel.getName().setValue(name);
        profileActivityViewModel.getPhone().setValue(phone);
        profileActivityViewModel.getEmail().setValue(email);

        profileActivityViewModel.getFinish().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if(aBoolean)
                    finish();
            }
        });

        profileActivityViewModel.getSave().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if(aBoolean)
                {
                    SharedPreferences.Editor editor = getSharedPreferences("prefs", MODE_PRIVATE).edit();
                    editor.putString("name", profileActivityViewModel.getName().getValue());
                    editor.putString("email", profileActivityViewModel.getEmail().getValue());
                    editor.putString("phone", profileActivityViewModel.getPhone().getValue());
                    editor.apply();

                    Toast.makeText(ProfileActivity.this , "Saved !" , Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });

    }
}