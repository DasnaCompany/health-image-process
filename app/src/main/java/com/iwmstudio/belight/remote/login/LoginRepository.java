package com.iwmstudio.belight.remote.login;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.iwmstudio.belight.model.Login;
import com.iwmstudio.belight.remote.APIService;
import com.iwmstudio.belight.remote.RetroClass;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginRepository {

    private final MutableLiveData<Login> login = new MutableLiveData<>();

    public MutableLiveData<Login> getLogin(String phone , String password) {

        APIService apiService = RetroClass.getApiService();

        Log.e("Login" , phone + " - " + password);

        Call<LoginResponse> call = apiService.loginUser(phone , password);

        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(@NonNull Call<LoginResponse> call, @NonNull Response<LoginResponse> response)
            {
                Log.e("Login" , response + " - ");
                if(response.body() != null)
                    login.setValue(response.body().getData());
            }

            @Override
            public void onFailure(@NonNull Call<LoginResponse> call, @NonNull Throwable t) {
                Log.e("Login" , t.toString());
            }
        });

        return login;
    }
}
