package com.iwmstudio.belight.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;

import com.iwmstudio.belight.R;
import com.iwmstudio.belight.databinding.ActivityPackagesBinding;
import com.iwmstudio.belight.model.Packages;
import com.iwmstudio.belight.remote.packages.PackagesRepository;
import com.iwmstudio.belight.viewmodel.ItemPackageViewModel;
import com.iwmstudio.belight.viewmodel.PackagesActivityViewModel;

import java.util.ArrayList;

public class PackagesActivity extends AppCompatActivity {

    private ArrayList<ItemPackageViewModel> holder = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String pack = getIntent().getStringExtra("pack");

        ActivityPackagesBinding activityPackagesBinding = DataBindingUtil.setContentView(this , R.layout.activity_packages);
        activityPackagesBinding.setLifecycleOwner(this);

        PackagesActivityViewModel packagesActivityViewModel = new ViewModelProvider(this).get(PackagesActivityViewModel.class);
        activityPackagesBinding.setPackages(packagesActivityViewModel);

        packagesActivityViewModel.getFinish().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if(aBoolean)
                    finish();
            }
        });

        PackagesRepository packagesRepository = new PackagesRepository();
        packagesRepository.getLiveData(pack).observe(this, new Observer<ArrayList<Packages>>() {
            @Override
            public void onChanged(@NonNull ArrayList<Packages> packages) {
                Log.e("Pack size" , packages.size() + "");
                if(packages != null)
                {
                    for (Packages pack: packages) {
                        ItemPackageViewModel itemPackageViewModel = new ItemPackageViewModel(pack);
                        holder.add(itemPackageViewModel);
                    }
                    packagesActivityViewModel.getItemPackageViewModels().setValue(holder);
                }
            }
        });

    }
}