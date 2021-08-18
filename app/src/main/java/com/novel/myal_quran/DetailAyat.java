package com.novel.myal_quran;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.novel.myal_quran.adapter.AdapterListAyat;

import com.novel.myal_quran.entity.indonesia.AyatIndonesia;
import com.novel.myal_quran.entity.indonesia.IndonesiaResponse;
import com.novel.myal_quran.services.QuranApi;
import com.novel.myal_quran.services.QuranApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailAyat extends AppCompatActivity {
    Toolbar toolbar;
    int id;
    private RecyclerView recyclerViewAyat;
    private List<AyatIndonesia> detailAyat ;
    private AdapterListAyat adapterListAyat;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_ayat);
        toolbar = findViewById(R.id.toolbar);
        recyclerViewAyat = findViewById(R.id.rv_ayat);
        id = getIntent().getIntExtra("detailAyat",0);
        setupList();
        loadData();
    }

    private void setupList() {
        adapterListAyat = new AdapterListAyat(this, detailAyat,detailAyat);
        recyclerViewAyat.setLayoutManager(new LinearLayoutManager(this));
    }


    private void loadData(){
        final QuranApiInterface quranApiInterface = QuranApi.getRetrofit().create(QuranApiInterface.class);
        Call <IndonesiaResponse> call =quranApiInterface.getDetailAyat(String.valueOf(id));
        call.enqueue(new Callback<IndonesiaResponse>() {
            @Override
            public void onResponse(Call<IndonesiaResponse> call, Response<IndonesiaResponse> response) {
                if (response.isSuccessful()){
                    IndonesiaResponse ayats = response.body();
                    adapterListAyat.setData(ayats.getData().get(0).getAyahs() , ayats.getData().get(1).getAyahs());
                    recyclerViewAyat.setAdapter(adapterListAyat);
                }
            }

            @Override
            public void onFailure(Call<IndonesiaResponse> call, Throwable t) {

            }
        });
    }
}
