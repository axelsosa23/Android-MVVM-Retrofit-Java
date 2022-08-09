package com.example.mvvm_retrofit.ViewModel;

import android.view.View;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mvvm_retrofit.Entities.LoginBody;
import com.example.mvvm_retrofit.Model.MainModel;

public class MainViewModel extends ViewModel {

    private MutableLiveData<Integer> mProgressMutableData = new MutableLiveData<>();
    private MutableLiveData<String> mLoginResultMutableData = new MutableLiveData<>();

    private MainModel mMainModel;

    public MainViewModel() {
        mProgressMutableData.postValue(View.INVISIBLE);
        mLoginResultMutableData.postValue("Sin logearse aun");
        mMainModel = new MainModel();
    }

    public void login(String email, String password) {
        mProgressMutableData.postValue(View.VISIBLE);
        mLoginResultMutableData.postValue("Cargando...");

        LoginBody loginBody = new LoginBody(email, password);

        mMainModel.loginRemote(loginBody, new MainModel.ILoginResponse() {
            @Override
            public void onResponse(String token) {
                mProgressMutableData.postValue(View.INVISIBLE);
                mLoginResultMutableData.postValue("Login Completado!\nEl token es: " + token);
            }

            @Override
            public void onFailure(Throwable t) {
                mProgressMutableData.postValue(View.INVISIBLE);
                mLoginResultMutableData.postValue("Login falló");
            }
        });
    }

    public LiveData<String> getLoginResult() {
        return mLoginResultMutableData;
    }

    public LiveData<Integer> getProgress() {
        return mProgressMutableData;
    }
}
