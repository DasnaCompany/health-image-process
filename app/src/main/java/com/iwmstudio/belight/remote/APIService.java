package com.iwmstudio.belight.remote;

import com.iwmstudio.belight.remote.form.FormResponse;
import com.iwmstudio.belight.remote.login.LoginResponse;
import com.iwmstudio.belight.remote.packages.PackResponse;
import com.iwmstudio.belight.remote.packages.PackageResponse;
import com.iwmstudio.belight.remote.register.RegisterResponse;
import com.iwmstudio.belight.remote.settings.SettingsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIService {

    @GET("/~belight/users/register/")
    Call<RegisterResponse> registerUser(
            @Query("phone") String phone,
            @Query("name") String name ,
            @Query("email") String email ,
            @Query("password") String password
    );

    @GET("/~belight/users/login/")
    Call<LoginResponse> loginUser(
            @Query("phone") String phone,
            @Query("password") String password
    );

    @GET("/~belight/form/add/")
    Call<FormResponse> addForm(
            @Query("phone") String phone,
            @Query("weight") String weight,
            @Query("height") String height,
            @Query("arm") String arm,
            @Query("abdomen") String abdomen,
            @Query("thigh") String thigh ,
            @Query("neck") String neck
    );

    @GET("/~belight/pack/receive/")
    Call<PackageResponse> getPackages(
            @Query("pack") String pack
    );

    @GET("/~belight/pack/get/")
    Call<PackResponse> getPackage(
            @Query("pack") String pack
    );

    @GET("/~belight/settings/get/")
    Call<SettingsResponse> getSettings();

}
