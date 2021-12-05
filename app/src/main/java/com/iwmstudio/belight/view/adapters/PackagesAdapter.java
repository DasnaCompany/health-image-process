package com.iwmstudio.belight.view.adapters;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.iwmstudio.belight.R;
import com.iwmstudio.belight.databinding.ItemPackageBinding;
import com.iwmstudio.belight.viewmodel.ItemPackageViewModel;

import java.util.ArrayList;

public class PackagesAdapter extends RecyclerView.Adapter<PackagesAdapter.CustomHolder> {

    private ArrayList<ItemPackageViewModel> itemPackageViewModels = new ArrayList<>();

    public PackagesAdapter(ArrayList<ItemPackageViewModel> itemPackageViewModels) {
        this.itemPackageViewModels = itemPackageViewModels;
    }

    @NonNull
    @Override
    public CustomHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ItemPackageBinding itemPackageBinding = DataBindingUtil.inflate(layoutInflater , R.layout.item_package , parent , false);
        return new CustomHolder(itemPackageBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomHolder holder, int position) {
        ItemPackageViewModel itemPackageViewModel = itemPackageViewModels.get(position);
        holder.bind(itemPackageViewModel);
    }

    @Override
    public int getItemCount() {
        if(itemPackageViewModels != null)
            return itemPackageViewModels.size();
        return 0;
    }

    public static class CustomHolder extends RecyclerView.ViewHolder {

        ItemPackageBinding itemPackageBinding;

        public CustomHolder(@NonNull ItemPackageBinding itemPackageBinding) {
            super(itemPackageBinding.getRoot());
            this.itemPackageBinding = itemPackageBinding;
        }

        public void bind(ItemPackageViewModel itemPackageViewModel)
        {
            this.itemPackageBinding.setItem(itemPackageViewModel);
            this.itemPackageBinding.executePendingBindings();
        }

    }

}
