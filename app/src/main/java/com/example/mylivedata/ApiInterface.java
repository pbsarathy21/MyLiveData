package com.example.mylivedata;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("posts")
    Call<Model> details();
}
