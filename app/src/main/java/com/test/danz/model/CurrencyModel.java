package com.test.danz.model;

import com.google.gson.annotations.SerializedName;

public class CurrencyModel {

    @SerializedName("Date")
    private String date;
    @SerializedName("PreviousDate")
    private String pDate;
    @SerializedName("PreviousURL")
    private String pUrl;
    @SerializedName("Timestamp")
    private String time;
    @SerializedName("Valute")
    private Valute valute;


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getpDate() {
        return pDate;
    }

    public void setpDate(String pDate) {
        this.pDate = pDate;
    }

    public String getpUrl() {
        return pUrl;
    }

    public void setpUrl(String pUrl) {
        this.pUrl = pUrl;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Valute getValute() {
        return valute;
    }

    public void setValute(Valute valute) {
        this.valute = valute;
    }
}


