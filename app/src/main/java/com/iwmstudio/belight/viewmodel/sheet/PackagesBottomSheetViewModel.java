package com.iwmstudio.belight.viewmodel.sheet;

import android.content.Context;
import android.content.Intent;

import androidx.databinding.BaseObservable;

import com.iwmstudio.belight.view.PackagesActivity;

public class PackagesBottomSheetViewModel extends BaseObservable {

    public PackagesBottomSheetViewModel()
    {

    }

    public void openForm(Context context , String pack)
    {
        Intent intent = new Intent(context , PackagesActivity.class);
        intent.putExtra("pack" , pack);
        context.startActivity(intent);
    }

}
