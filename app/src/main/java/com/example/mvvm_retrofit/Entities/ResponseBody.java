package com.example.mvvm_retrofit.Entities;

import com.google.gson.annotations.SerializedName;

public class ResponseBody {

    @SerializedName("token")
    String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
