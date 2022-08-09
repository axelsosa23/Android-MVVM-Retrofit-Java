package com.example.mvvm_retrofit.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.example.mvvm_retrofit.R;
import com.example.mvvm_retrofit.ViewModel.MainViewModel;
import com.example.mvvm_retrofit.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private MainViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

//        VIEWMODEL

        mViewModel = new ViewModelProvider(this).get(MainViewModel.class);

//        OBSERVADORES

//        mensaje
        mViewModel.getLoginResult().observe(this, s -> binding.tvLoginResult.setText(s));

//        carga
        mViewModel.getProgress().observe(this, visibility -> binding.progressBar.setVisibility(visibility));

//        BOTONES

        binding.bLogin.setOnClickListener(v -> mViewModel.login(binding.etEmail.getText().toString(), binding.etPassword.getText().toString()));
    }
}