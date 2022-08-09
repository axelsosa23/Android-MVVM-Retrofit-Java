package com.example.mvvm_retrofit.Model;

import com.example.mvvm_retrofit.Config.RetrofitClientInstance;
import com.example.mvvm_retrofit.Entities.LoginBody;
import com.example.mvvm_retrofit.Entities.ResponseBody;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainModel {

//    REALIZA LA CONSULTA
    public void loginRemote(LoginBody loginBody, ILoginResponse loginResponse) {
        Call<ResponseBody> initiateLogin = RetrofitClientInstance.getApiService().login(loginBody);

        initiateLogin.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    loginResponse.onResponse(response.body().getToken());
                } else {
                    loginResponse.onFailure(new Throwable(response.message()));
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                loginResponse.onFailure(t);
            }
        });

    }

    //    INTERFAZ PARA ENVIAR EL RESULTADO AL VIEWMODEL
    public interface ILoginResponse {
        void onResponse(String token);
        void onFailure(Throwable t);
    }
}
