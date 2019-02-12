package com.example.mylivedata;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/";


    private static Retrofit getRetroInstance() {

        Gson gson = new GsonBuilder().setLenient().create();


        return new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create(gson)).build();

    }


    public static ApiInterface getApiInterface() {

        return getRetroInstance().create(ApiInterface.class);
    }

}
