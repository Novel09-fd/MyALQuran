package com.novel.myal_quran.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class IndonesiaResponse {

    @SerializedName("code")
    private int code;

    @SerializedName("data")
    private List<Surah> data;

    @SerializedName("status")
    private String status;

    public void setCode(int code){
        this.code = code;
    }

    public int getCode(){
        return code;
    }

    public void setData(List<Surah> data){
        this.data = data;
    }

    public List<Surah> getData(){
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
