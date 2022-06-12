package com.example.a5l4.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.a5l4.network.App;
import com.example.a5l4.network.LoveApi;
import com.example.a5l4.network.LoveModel;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repository {
    private final String HOST = "love-calculator.p.rapidapi.com";
    public static final String KEY = "7f31bf3e6fmshc9fe327e036f21dp1d7268jsnc447467dd4ff";
    LoveApi api;
    @Inject
    public Repository(LoveApi loveApi){
        api = loveApi;
    }

    public MutableLiveData<LoveModel> getData(String first, String second) {
        MutableLiveData<LoveModel> localMutableLiveData = new MutableLiveData<>();
        api.loveCalculate(first, second, HOST, KEY).enqueue(new Callback<LoveModel>() {
            @Override
            public void onResponse(Call<LoveModel> call, Response<LoveModel> response) {
                if (response.isSuccessful()) {
                    localMutableLiveData.postValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<LoveModel> call, Throwable t) {
                Log.e("ololo", "onFailure:" + t.getLocalizedMessage());

            }
        });
        return localMutableLiveData;
    }
}
