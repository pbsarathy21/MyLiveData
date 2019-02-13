package com.example.mylivedata;

import android.arch.lifecycle.MutableLiveData;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRepository {

    private MutableLiveData<String> data = new MutableLiveData<>();

    public UserRepository() {
    }

    public MutableLiveData<String> getResponseBodyMutableLiveData() {

        ApiInterface apiInterface = RetrofitClient.getApiInterface();
        Call<List<Model>> call = apiInterface.details();
            call.enqueue(new Callback<List<Model>>() {
    @Override
    public void onResponse(Call<List<Model>> call, Response<List<Model>> response) {
        if (response.code() == 200)
        {
            List<Model> modelList = response.body();
            data.setValue(modelList.get(0).getTitle());
        }

        else
        {
            data.setValue("Error "+response.code());
        }
    }

    @Override
    public void onFailure(Call<List<Model>> call, Throwable t) {

        data.setValue(t.getMessage());

    }
});

        return data;
    }
}
