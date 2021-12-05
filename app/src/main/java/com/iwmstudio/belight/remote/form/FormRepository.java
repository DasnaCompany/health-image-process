package com.iwmstudio.belight.remote.form;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.iwmstudio.belight.remote.APIService;
import com.iwmstudio.belight.remote.RetroClass;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FormRepository {

    private final MutableLiveData<Boolean> result = new MutableLiveData<>();

    public MutableLiveData<Boolean> getResult(String phone , String weight , String height , String arm , String abdomen , String thigh , String neck) {

        APIService apiService = RetroClass.getApiService();

        Log.e("Vars" , phone + " - " + weight+ " - " + height+ " - " + arm+ " - " + abdomen+ " - " + thigh+ " - " + neck);

        Call<FormResponse> call = apiService.addForm(phone , weight , height , arm , abdomen , thigh , neck);

        call.enqueue(new Callback<FormResponse>() {
            @Override
            public void onResponse(@NonNull Call<FormResponse> call, @NonNull Response<FormResponse> response)
            {
                result.setValue(true);
            }

            @Override
            public void onFailure(@NonNull Call<FormResponse> call, @NonNull Throwable t) {
                Log.e("Story" , t.toString());
            }
        });

        return result;
    }
}
