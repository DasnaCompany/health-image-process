package com.iwmstudio.belight.remote.packages;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.iwmstudio.belight.model.Packages;
import com.iwmstudio.belight.remote.APIService;
import com.iwmstudio.belight.remote.RetroClass;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PackageRepository {

    private final MutableLiveData<Packages> packageDetails = new MutableLiveData<>();

    public MutableLiveData<Packages> getPackageDetails(String pack) {

        APIService apiService = RetroClass.getApiService();

        Call<PackResponse> call = apiService.getPackage(pack);

        call.enqueue(new Callback<PackResponse>() {

            @Override
            public void onResponse(@NonNull Call<PackResponse> call, @NonNull Response<PackResponse> response)
            {
                Log.e("Res" , response.toString() + " ");
                if(response.body() != null)
                {
                    packageDetails.setValue(response.body().getData());
                }
                else
                    Log.e("Res" , "Err");
            }

            @Override
            public void onFailure(@NonNull Call<PackResponse> call, @NonNull Throwable t) {
                Log.e("Packages" , t.toString());
            }
        });

        return packageDetails;
    }
}
