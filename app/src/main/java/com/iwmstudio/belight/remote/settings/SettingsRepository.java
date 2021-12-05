package com.iwmstudio.belight.remote.settings;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.iwmstudio.belight.model.Settings;
import com.iwmstudio.belight.remote.APIService;
import com.iwmstudio.belight.remote.RetroClass;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SettingsRepository {

    private final MutableLiveData<Settings> settingsMutableLiveData = new MutableLiveData<>();

    public MutableLiveData<Settings> getSettingsMutableLiveData() {

        APIService apiService = RetroClass.getApiService();

        Call<SettingsResponse> call = apiService.getSettings();

        call.enqueue(new Callback<SettingsResponse>() {
            @Override
            public void onResponse(@NonNull Call<SettingsResponse> call, @NonNull Response<SettingsResponse> response)
            {
                if(response.body() != null)
                    settingsMutableLiveData.setValue(response.body().getData());
            }

            @Override
            public void onFailure(@NonNull Call<SettingsResponse> call, @NonNull Throwable t) {
                Log.e("Register" , t.toString());
            }
        });

        return settingsMutableLiveData;
    }
}
