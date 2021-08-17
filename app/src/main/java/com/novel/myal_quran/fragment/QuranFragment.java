package com.novel.myal_quran.fragment;


import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toolbar;

import com.novel.myal_quran.R;
import com.novel.myal_quran.adapter.AdapterListSurah;
import com.novel.myal_quran.entity.QuranResponse;
import com.novel.myal_quran.entity.Surah;
import com.novel.myal_quran.services.QuranApi;
import com.novel.myal_quran.services.QuranApiInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class QuranFragment extends Fragment {
    List<Surah> surahList = new ArrayList<>();
    Toolbar toolbar;
    ProgressDialog progressDialog;
    private RecyclerView recyclerView;
    private AdapterListSurah adapterListSurah;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        progressDialog = new ProgressDialog(getContext());
        View view = inflater.inflate(R.layout.activity_quran_fragment, viewGroup, false);
        recyclerView = view.findViewById(R.id.rv_surah);
        recyclerView.setAdapter(adapterListSurah);

        new loadAsync().execute();
        return view;
    }

    private class loadAsync extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog.setMessage(getResources().getString(R.string.loading));
            progressDialog.show();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            final QuranApiInterface quranApiInterface = QuranApi.getRetrofit().create(QuranApiInterface.class);
            Call<QuranResponse> call = quranApiInterface.getAllSurah();
            call.enqueue(new Callback<QuranResponse>() {
                @Override
                public void onResponse(Call<QuranResponse> call, Response<QuranResponse> response) {
                    if (response.isSuccessful()) {
                        surahList.clear();
                        surahList.addAll(response.body().getData());
                        recyclerView.setAdapter(adapterListSurah);
                        adapterListSurah.notifyDataSetChanged();

                    }
                    progressDialog.dismiss();

                }

                @Override
                public void onFailure(Call<QuranResponse> call, Throwable t) {

                }
            });
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            adapterListSurah = new AdapterListSurah(getActivity(), surahList);
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            recyclerView.setHasFixedSize(true);
            recyclerView.setDrawingCacheEnabled(true);
            recyclerView.setItemViewCacheSize(View.DRAWING_CACHE_QUALITY_HIGH);
            recyclerView.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
        }
    }

}