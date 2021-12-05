package com.iwmstudio.belight.view.sheet;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.iwmstudio.belight.R;
import com.iwmstudio.belight.databinding.BottomPackagesBinding;
import com.iwmstudio.belight.viewmodel.sheet.PackagesBottomSheetViewModel;

import static android.content.ContentValues.TAG;

public class PackagesBottomSheet extends BottomSheetDialogFragment {

    public static PackagesBottomSheet newInstance(){
        PackagesBottomSheet f = new PackagesBottomSheet();
        Bundle args = new Bundle();
        f.setArguments(args);
        return f;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL, R.style.AppModalStyle);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        BottomPackagesBinding binding = DataBindingUtil.inflate(LayoutInflater.from(getContext()), R.layout.bottom_packages, null, false);
        PackagesBottomSheetViewModel packagesBottomSheetViewModel = new PackagesBottomSheetViewModel();
        binding.setBottom(packagesBottomSheetViewModel);
        return binding.getRoot();
    }

    @Override
    public void show(FragmentManager manager, String tag) {
        FragmentTransaction fragmentTransaction = manager.beginTransaction();
        fragmentTransaction.add(this, TAG);
        fragmentTransaction.commitNow();
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = super.onCreateDialog(savedInstanceState);
        dialog.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override public void onShow(DialogInterface dialogInterface) {
                BottomSheetDialog bottomSheetDialog = (BottomSheetDialog) dialogInterface;
            }
        });
        return dialog;
    }

}
