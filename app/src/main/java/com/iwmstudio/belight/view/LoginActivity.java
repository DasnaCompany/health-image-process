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
import com.iwmstudio.belight.databinding.ActivityLoginBinding;
import com.iwmstudio.belight.model.Login;
import com.iwmstudio.belight.remote.login.LoginRepository;
import com.iwmstudio.belight.viewmodel.LoginActivityViewModel;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityLoginBinding activityLoginBinding = DataBindingUtil.setContentView(this , R.layout.activity_login);
        activityLoginBinding.setLifecycleOwner(this);

        LoginActivityViewModel loginActivityViewModel = new ViewModelProvider(this).get(LoginActivityViewModel.class);
        activityLoginBinding.setLogin(loginActivityViewModel);

        loginActivityViewModel.getFinish().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if(aBoolean)
                    finish();
            }
        });

        loginActivityViewModel.getRegisterClicked().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if(aBoolean)
                {
                    Intent intent = new Intent(LoginActivity.this , RegisterActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });

        loginActivityViewModel.getBtnClick().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if(aBoolean)
                {
                    loginActivityViewModel.getBtnClick().setValue(false);

                    LoginRepository loginRepository = new LoginRepository();
                    loginRepository.getLogin(loginActivityViewModel.getPhone().getValue() , loginActivityViewModel.getPassword().getValue()).observe(LoginActivity.this, new Observer<Login>() {
                        @Override
                        public void onChanged(Login login) {
                            if(login != null)
                            {
                                SharedPreferences.Editor editor = getSharedPreferences("prefs", MODE_PRIVATE).edit();
                                editor.putString("name", login.getName());
                                editor.putString("email", login.getEmail());
                                editor.putString("phone", login.getPhone());
                                editor.apply();

                                Toast.makeText(LoginActivity.this , "Logged in successful !" , Toast.LENGTH_SHORT).show();
                                finish();
                            }
                            else
                            {
                                Toast.makeText(LoginActivity.this , "Phone number or password wrong !" , Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });

    }
}