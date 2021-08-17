package com.novel.myal_quran.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class QuranResponse {
    @SerializedName("code")
    private int code;
    @SerializedName("status")
    private String status;
    @SerializedName("data")
    private List<Surah> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Surah> getData() {
        return data;
    }

    public void setData(List<Surah> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "QuranResponse{" +
                "code=" + code +
                ", status='" + status + '\'' +
                ", data=" + data +
                '}';
    }
}
