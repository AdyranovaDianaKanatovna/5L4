package com.example.a5l4.network;

import android.app.Application;

import retrofit2.Retrofit;

public class App extends Application {
    public static  LoveApi api;

    @Override
    public void onCreate() {
        super.onCreate();
        RetrofitService retrofitService = new RetrofitService();
        api = retrofitService.getLoveApi();
    }
}
