package com.iwmstudio.belight.viewmodel;

import androidx.databinding.BindingAdapter;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.iwmstudio.belight.view.adapters.PackagesAdapter;

import java.util.ArrayList;

public class PackagesActivityViewModel extends ViewModel {

    private final MutableLiveData<Boolean> finish = new MutableLiveData<>(false);

    private MutableLiveData<ArrayList<ItemPackageViewModel>> itemPackageViewModels = new MutableLiveData<>();

    public void finish()
    {
        finish.setValue(true);
    }

    @BindingAdapter("bind:packagesRecyclerView")
    public static void bindPackagesRecyclerView(RecyclerView recyclerView , ArrayList<ItemPackageViewModel> itemPackageViewModels)
    {
        PackagesAdapter packagesAdapter = new PackagesAdapter(itemPackageViewModels);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(packagesAdapter);
    }

    public MutableLiveData<ArrayList<ItemPackageViewModel>> getItemPackageViewModels() {
        return itemPackageViewModels;
    }

    public MutableLiveData<Boolean> getFinish() {
        return finish;
    }
}
