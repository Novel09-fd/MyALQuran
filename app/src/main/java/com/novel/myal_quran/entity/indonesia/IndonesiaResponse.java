package com.novel.myal_quran.entity.indonesia;

import com.google.gson.annotations.SerializedName;
import com.novel.myal_quran.entity.Surah;

import java.util.List;

public class IndonesiaResponse {

    @SerializedName("code")
    private int code;

    @SerializedName("data")
    private List<SurahIndonesia> data;

    @SerializedName("status")
    private String status;

    public void setCode(int code){
        this.code = code;
    }

    public int getCode(){
        return code;
    }

    public void setData(List<SurahIndonesia> data){
        this.data = data;
    }

    public List<SurahIndonesia> getData(){
        return data;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public String getStatus(){
        return status;
    }

    @Override
    public String toString(){
        return
                "IndonesiaResponse{" +
                        "code = '" + code + '\'' +
                        ",data = '" + data + '\'' +
                        ",status = '" + status + '\'' +
                        "}";
    }
}
