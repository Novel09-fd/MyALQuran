package com.novel.myal_quran.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.novel.myal_quran.R;
import com.novel.myal_quran.entity.indonesia.AyatIndonesia;

import java.util.List;

public class AdapterListAyat extends RecyclerView.Adapter<AdapterListAyat.AyatHolder> {

    private Context context;
    private List<AyatIndonesia> listAyat;
    private List<AyatIndonesia> listAyat2;

    public AdapterListAyat (Context context,List<AyatIndonesia> detailAyat,List<AyatIndonesia>data2){
        this.context = context;
        this.listAyat = detailAyat;
        this.listAyat2 = data2;
    }
    @NonNull
    @Override
    public AyatHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_detail_ayat , parent ,false);

        return new AyatHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AyatHolder holder, int position) {

        com.novel.myal_quran.entity.indonesia.AyatIndonesia ayatIndonesia = listAyat.get(position);
        com.novel.myal_quran.entity.indonesia.AyatIndonesia ayatIndonesia2 = listAyat2.get(position);

        holder.tv_numberAyat.setText(String.valueOf(ayatIndonesia.getNumberInSurah()));
        holder.tv_arabic.setText(ayatIndonesia.getText());
        holder.tv_terjemahIndo.setText(ayatIndonesia2.getText());
    }

    @Override
    public int getItemCount() {
        return listAyat.size();
    }

    public void setData(List<AyatIndonesia> data,
                        List<AyatIndonesia> data2 ){
        this.listAyat = data;
        this.listAyat2 = data2;
    }

    public class AyatHolder extends RecyclerView.ViewHolder {
        TextView tv_arabic , tv_terjemahIndo ,tv_numberAyat ;

        public AyatHolder(@NonNull View itemView) {
            super(itemView);
            tv_arabic = (itemView).findViewById(R.id.txt_arab);
            tv_terjemahIndo = (itemView).findViewById(R.id.txt_terjemahAyat);
            tv_numberAyat = (itemView).findViewById(R.id.rowAyat);

        }
    }
}
