package com.test.danz.repository.networking;

import com.test.danz.model.CurrencyModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface INetCurrency {
    @GET("daily_json.js")
    Call<CurrencyModel> getCurrencyModel();

}

