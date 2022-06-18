package com.example.a5l4.hit;

import com.example.a5l4.network.LoveApi;
import com.example.a5l4.prefs.Prefs;
import com.example.a5l4.repository.Repository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
@InstallIn(SingletonComponent.class)
public class AppModule {
    @Provides
    @Singleton
    public LoveApi provideApi() {
        return new Retrofit.Builder().baseUrl("https://love-calculator.p.rapidapi.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(LoveApi.class);
    }

    @Provides
    public Repository provideRepository() {
        return new Repository(provideApi());
    }
    @Provides
    @Singleton
    public Prefs providePrefs(){
        return  new Prefs();
    }
}