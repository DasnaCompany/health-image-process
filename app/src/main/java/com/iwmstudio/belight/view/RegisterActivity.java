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
import com.iwmstudio.belight.databinding.ActivityRegisterBinding;
import com.iwmstudio.belight.remote.register.RegisterRepository;
import com.iwmstudio.belight.viewmodel.RegisterActivityViewModel;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences prefs = getSharedPreferences("prefs", MODE_PRIVATE);
        String name = prefs.getString("name", null);//"No name defined" is the default value.

        if(name != null)
        {
            Intent intent = new Intent(RegisterActivity.this , ProfileActivity.class);
            startActivity(intent);
            finish();
        }

        ActivityRegisterBinding activityRegisterBinding = DataBindingUtil.setContentView(this , R.layout.activity_register);
        activityRegisterBinding.setLifecycleOwner(this);

        RegisterActivityViewModel registerActivityViewModel = new ViewModelProvider(this).get(RegisterActivityViewModel.class);
        activityRegisterBinding.setRegister(registerActivityViewModel);

        registerActivityViewModel.getFinish().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if(aBoolean)
                    finish();
            }
        });

        registerActivityViewModel.getRegisterBtn().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if(aBoolean)
                {
                    RegisterRepository registerRepository = new RegisterRepository();
                    registerRepository.getStatus(registerActivityViewModel.getName().getValue() , registerActivityViewModel.getPhone().getValue() , registerActivityViewModel.getEmail().getValue() , registerActivityViewModel.getPassword().getValue()).observe(RegisterActivity.this, new Observer<Boolean>() {
                        @Override
                        public void onChanged(Boolean aBoolean) {
                            if(aBoolean)
                            {
                                SharedPreferences.Editor editor = getSharedPreferences("prefs", MODE_PRIVATE).edit();
                                editor.putString("name", registerActivityViewModel.getName().getValue());
                                editor.putString("email", registerActivityViewModel.getEmail().getValue());
                                editor.putString("phone", registerActivityViewModel.getPhone().getValue());
                                editor.apply();

                                Toast.makeText(RegisterActivity.this , "Register completed ." , Toast.LENGTH_SHORT).show();
                                finish();
                            }
                            else
                                Toast.makeText(RegisterActivity.this , "An error occurred ." , Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });

    }
}