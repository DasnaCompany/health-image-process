package com.iwmstudio.belight.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import com.iwmstudio.belight.R;
import com.iwmstudio.belight.databinding.ActivityFormBinding;
import com.iwmstudio.belight.remote.form.FormRepository;
import com.iwmstudio.belight.viewmodel.FormActivityViewModel;

public class FormActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences prefs = getSharedPreferences("prefs", MODE_PRIVATE);
        String phone = prefs.getString("phone", null);//"No name defined" is the default value.

        ActivityFormBinding activityFormBinding = DataBindingUtil.setContentView(this , R.layout.activity_form);
        activityFormBinding.setLifecycleOwner(this);


        FormActivityViewModel formActivityViewModel = new ViewModelProvider(this , new FormActivityViewModel(getIntent().getStringExtra("pack_name"))).get(FormActivityViewModel.class);
        activityFormBinding.setForm(formActivityViewModel);

        formActivityViewModel.getFinish().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if(aBoolean)
                    finish();
            }
        });

        formActivityViewModel.getSubmit().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if(aBoolean)
                {
                    Log.e("Clicked" , "True");
                    formActivityViewModel.getSubmit().setValue(false);
                    FormRepository formRepository = new FormRepository();
                    formRepository.getResult(
                            phone ,
                            formActivityViewModel.getWeight().getValue() ,
                            formActivityViewModel.getHeight().getValue() ,
                            formActivityViewModel.getArm().getValue() ,
                            formActivityViewModel.getAbdomen().getValue() ,
                            formActivityViewModel.getThigh().getValue() ,
                            formActivityViewModel.getNeck().getValue()
                            ).observe(FormActivity.this, new Observer<Boolean>() {
                        @Override
                        public void onChanged(Boolean aBoolean) {

                        }
                    });
                }
            }
        });

    }
}