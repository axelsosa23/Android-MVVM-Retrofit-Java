package com.example.mvvm_retrofit.Api;

import com.example.mvvm_retrofit.Entities.LoginBody;
import com.example.mvvm_retrofit.Entities.ResponseBody;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiService {

    @POST("login")
    Call<ResponseBody> login(@Body LoginBody loginBody);
}
