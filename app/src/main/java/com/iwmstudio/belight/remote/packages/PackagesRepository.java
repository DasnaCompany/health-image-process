package com.iwmstudio.belight.remote.packages;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.iwmstudio.belight.model.Packages;
import com.iwmstudio.belight.remote.APIService;
import com.iwmstudio.belight.remote.RetroClass;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PackagesRepository {

    private final MutableLiveData<ArrayList<Packages>> liveData = new MutableLiveData<>();

    public MutableLiveData<ArrayList<Packages>> getLiveData(String pack) {

        APIService apiService = RetroClass.getApiService();

        Call<PackageResponse> call = apiService.getPackages(pack);

        call.enqueue(new Callback<PackageResponse>() {
            @Override
            public void onResponse(@NonNull Call<PackageResponse> call, @NonNull Response<PackageResponse> response)
            {
                Log.e("Res" , response.toString() + " ");
                if(response.body() != null)
                {
                    Log.e("Res" , response.body().getData().size() + " ");
                    liveData.setValue(response.body().getData());
                }
                else
                    Log.e("Res" , "Err");
            }

            @Override
            public void onFailure(@NonNull Call<PackageResponse> call, @NonNull Throwable t) {
                Log.e("Packages" , t.toString());
            }
        });

        return liveData;
    }

}
