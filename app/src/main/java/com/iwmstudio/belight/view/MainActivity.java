package com.iwmstudio.belight.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import com.iwmstudio.belight.R;
import com.iwmstudio.belight.databinding.ActivityMainBinding;
import com.iwmstudio.belight.view.sheet.PackagesBottomSheet;
import com.iwmstudio.belight.viewmodel.ActivityMainViewModel;

public class MainActivity extends AppCompatActivity {

    PackagesBottomSheet myBottomSheet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences prefs = getSharedPreferences("prefs", MODE_PRIVATE);
        String name = prefs.getString("name", null);//"No name defined" is the default value.

        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this , R.layout.activity_main);

        ActivityMainViewModel activityMainViewModel = new ViewModelProvider(this).get(ActivityMainViewModel.class);
        activityMainBinding.setMain(activityMainViewModel);

        activityMainViewModel.getAbout().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if(aBoolean)
                {
                    activityMainViewModel.getAbout().setValue(false);
                    Intent intent = new Intent(MainActivity.this , AboutActivity.class);
                    startActivity(intent);
                }
            }
        });

        activityMainViewModel.getBody().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if(aBoolean)
                {
                    activityMainViewModel.getBody().setValue(false);
                    Intent intent = new Intent(MainActivity.this , BitmapMesh.class);
                    startActivity(intent);
                }
            }
        });

        activityMainViewModel.getProfile().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if(aBoolean)
                {

                    if(name != null)
                    {
                        activityMainViewModel.getProfile().setValue(false);
                        Intent intent = new Intent(MainActivity.this , ProfileActivity.class);
                        startActivity(intent);
                    }
                    else {
                        activityMainViewModel.getProfile().setValue(false);
                        Intent intent = new Intent(MainActivity.this , RegisterActivity.class);
                        startActivity(intent);
                    }
                }
            }
        });

        activityMainViewModel.getPackages().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if(aBoolean)
                {
                    if(name != null)
                    {
                        activityMainViewModel.getPackages().setValue(false);

                        if(myBottomSheet == null)
                            myBottomSheet = PackagesBottomSheet.newInstance();

                        myBottomSheet.show( getSupportFragmentManager() , myBottomSheet.getTag());
                    }
                    else {
                        Toast.makeText(MainActivity.this , "Please register / Login !" , Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

        activityMainViewModel.getContact().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if(aBoolean)
                {
                    activityMainViewModel.getContact().setValue(false);
                    Intent intent = new Intent(MainActivity.this , SupportActivity.class);
                    startActivity(intent);
                }
            }
        });

        activityMainViewModel.getLogin().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if(aBoolean)
                {
                    Intent intent = new Intent(MainActivity.this , LoginActivity.class);
                    startActivity(intent);
                }
            }
        });

    }
}