package com.novel.myal_quran.services;

import com.novel.myal_quran.entity.indonesia.IndonesiaResponse;
import com.novel.myal_quran.entity.QuranResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface QuranApiInterface {

    @GET("surah")
    Call<QuranResponse> getAllSurah();

    @GET("surah/{number}/editions/quran-uthmani,id.indonesian")
    Call<IndonesiaResponse> getDetailAyat(@Path("number") String number);
}
