package com.iwmstudio.belight.remote.register;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.iwmstudio.belight.remote.APIService;
import com.iwmstudio.belight.remote.RetroClass;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterRepository {

    private final MutableLiveData<Boolean> status = new MutableLiveData<>();

    public MutableLiveData<Boolean> getStatus(String name , String phone , String email , String password) {

        APIService apiService = RetroClass.getApiService();

        Call<RegisterResponse> call = apiService.registerUser(phone , name , email , password);

        call.enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(@NonNull Call<RegisterResponse> call, @NonNull Response<RegisterResponse> response)
            {
                status.setValue(true);
            }

            @Override
            public void onFailure(@NonNull Call<RegisterResponse> call, @NonNull Throwable t) {
                Log.e("Register" , t.toString());
            }
        });

        return status;
    }

}
