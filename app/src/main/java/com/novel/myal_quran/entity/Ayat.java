package com.novel.myal_quran.entity;

import com.google.gson.annotations.SerializedName;

public class Ayat {
    @SerializedName("number")
    private int number;
    @SerializedName("text")
    private String text;
    @SerializedName("numberInSurah")
    private int numberInSurah;
    @SerializedName("juz")
    private int juz;
    @SerializedName("manzil")
    private int manzil;
    @SerializedName("page")
    private int page;
    @SerializedName("ruku")
    private int ruku;
    @SerializedName("hizbQuarter")
    private int hizbQuarter;
    @SerializedName("sajda")
    private boolean sajda;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getNumberInSurah() {
        return numberInSurah;
    }

    public void setNumberInSurah(int numberInSurah) {
        this.numberInSurah = numberInSurah;
    }

    public int getJuz() {
        return juz;
    }

    public void setJuz(int juz) {
        this.juz = juz;
    }

    public int getManzil() {
        return manzil;
    }

    public void setManzil(int manzil) {
        this.manzil = manzil;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRuku() {
        return ruku;
    }

    public void setRuku(int ruku) {
        this.ruku = ruku;
    }

    public int getHizbQuarter() {
        return hizbQuarter;
    }

    public void setHizbQuarter(int hizbQuarter) {
        this.hizbQuarter = hizbQuarter;
    }

    public boolean isSajda() {
        return sajda;
    }

    public void setSajda(boolean sajda) {
        this.sajda = sajda;
    }


    @Override
    public String toString() {
        return "Ayat{" +
                "number=" + number +
                ", text='" + text + '\'' +
                ", numberInSurah=" + numberInSurah +
                ", juz=" + juz +
                ", manzil=" + manzil +
                ", page=" + page +
                ", ruku=" + ruku +
                ", hizbQuarter=" + hizbQuarter +
                ", sajda=" + sajda +
                '}';
    }
}
