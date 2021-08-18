package com.novel.myal_quran.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.novel.myal_quran.DetailAyat;
import com.novel.myal_quran.R;
import com.novel.myal_quran.entity.Surah;

import java.util.List;

public class AdapterListSurah extends RecyclerView.Adapter<AdapterListSurah.SurahHolder> {

    private Context context;
    private List<Surah>list;

    public AdapterListSurah(Context context, List<Surah> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public SurahHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_detail_surah, parent , false);
        return new SurahHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SurahHolder holder, final int position) {

        final Surah dataSurah = list.get(position);
        holder.tv_namaSurah.setText(dataSurah.getEnglishName());
        holder.tv_terjemahan.setText(dataSurah.getEnglishNameTranslation());
        holder.tv_jumlahAyat.setText(String.valueOf(dataSurah.getNumberOfAyahs()));
        holder.tv_numberSurah.setText(String.valueOf(dataSurah.getNumber()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Surah surah = list.get(position);
                Intent intent = new Intent(holder.itemView.getContext(), DetailAyat.class);
                intent.putExtra("detailAyat" , dataSurah.getNumber());
                holder.itemView.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class SurahHolder extends RecyclerView.ViewHolder {
        TextView tv_numberSurah ,tv_namaSurah ,tv_terjemahan ,
                 tv_jumlahAyat;

        public SurahHolder(@NonNull View itemView) {
            super(itemView);
            tv_numberSurah = (itemView).findViewById(R.id.row_Number);
            tv_namaSurah = (itemView).findViewById(R.id.txt_surah);
            tv_jumlahAyat = (itemView).findViewById(R.id.txt_jumlahAyat);
            tv_terjemahan = (itemView).findViewById(R.id.txt_terjemahSurah);
        }
    }
}
