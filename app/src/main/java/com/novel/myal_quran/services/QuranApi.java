package com.novel.myal_quran.services;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class QuranApi {

    public static final String BASE_URL = "http://api.alquran.cloud/";

    public static Retrofit getRetrofit(){
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
