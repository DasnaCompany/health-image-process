package com.iwmstudio.belight.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.iwmstudio.belight.R;
import com.iwmstudio.belight.databinding.ActivityPackageBinding;
import com.iwmstudio.belight.model.Packages;
import com.iwmstudio.belight.remote.packages.PackageRepository;
import com.iwmstudio.belight.viewmodel.PackageActivityViewModel;

public class PackageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityPackageBinding activityPackageBinding = DataBindingUtil.setContentView(this , R.layout.activity_package);
        activityPackageBinding.setLifecycleOwner(this);

        PackageActivityViewModel packageActivityViewModel = new ViewModelProvider(this).get(PackageActivityViewModel.class);
        activityPackageBinding.setPack(packageActivityViewModel);

        packageActivityViewModel.getBuy().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if(aBoolean)
                {
                    Intent intent = new Intent(PackageActivity.this , FormActivity.class);
                    intent.putExtra("pack_name" , packageActivityViewModel.getTitle().getValue());
                    startActivity(intent);
                }
            }
        });

        PackageRepository packageRepository = new PackageRepository();
        packageRepository.getPackageDetails(getIntent().getStringExtra("pack")).observe(this, new Observer<Packages>() {
            @Override
            public void onChanged(Packages packages) {
                if(packages != null)
                {
                    packageActivityViewModel.getTitle().setValue(packages.getName());
                    packageActivityViewModel.getImage().setValue(packages.getThumb());
                    packageActivityViewModel.getContent().setValue(packages.getDescription());
                    packageActivityViewModel.getPrice().setValue(packages.getPrice());
                    packageActivityViewModel.getDel_price().setValue(packages.getDel_price());
                }
            }
        });

        packageActivityViewModel.getFinish().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if(aBoolean)
                    finish();
            }
        });

    }

}