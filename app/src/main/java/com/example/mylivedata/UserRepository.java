package com.example.mylivedata;

import android.arch.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRepository {

    private MutableLiveData<Model> modelMutableLiveData = new MutableLiveData<>();

    public UserRepository() {
    }

    public MutableLiveData<Model> getResponseBodyMutableLiveData() {

        ApiInterface apiInterface = RetrofitClient.getApiInterface();
        Call<Model> call = apiInterface.details();

        call.enqueue(new Callback<Model>() {
            @Override
            public void onResponse(Call<Model> call, Response<Model> response) {
                modelMutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<Model> call, Throwable t) {

            }
        });

        return modelMutableLiveData;
    }
}
