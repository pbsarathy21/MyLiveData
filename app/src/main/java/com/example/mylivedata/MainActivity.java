package com.example.mylivedata;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.mylivedata.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private UserModel userModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        userModel = ViewModelProviders.of(this).get(UserModel.class);

        binding.setLifecycleOwner(this);

        binding.setUserModel(userModel);

        userModel.getData().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

                userModel.textValue.set(s);
            }
        });

        binding.setIUser(new IUser() {
            @Override
            public void onLoginClicked() {
                    userModel.showText();
            }

        });
    }
}
