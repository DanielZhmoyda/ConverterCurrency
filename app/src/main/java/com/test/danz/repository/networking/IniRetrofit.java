package com.test.danz.repository.networking;

import android.util.Log;
import com.test.danz.model.AttributeCurrency;
import com.test.danz.model.CurrencyModel;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class IniRetrofit {
    private Retrofit.Builder builder;

    @Inject
    public IniRetrofit(Retrofit.Builder builder) {
        this.builder = builder;
    }
    private final static String LOG_TAGG = "list";
    private final static String LOG_TAG = "converter";

        public void iNetService(final ResponseCallback callback) {
            Retrofit retrofitBuild = builder.build();
            Log.d(LOG_TAG, "get feed complete");
            Call<CurrencyModel> call = retrofitBuild.create(INetCurrency.class).getCurrencyModel();
            call.enqueue(new Callback<CurrencyModel>()
            {
                @Override
                public void onResponse(Call <CurrencyModel> call, Response<CurrencyModel> response){
                    if (response.isSuccessful()) {
                        Log.d(LOG_TAG, "response is successful ");

                        Log.d(LOG_TAGG, "iniRetroList size = " + parseDataFromServer(response.body()).size());
                        callback.getResponseCallback(parseDataFromServer(response.body()), true);
                    }
                    else {
                        Log.d(LOG_TAG, "Error of loading data from server");
                    }

                }

                @Override
                public void onFailure (Call < CurrencyModel> call, Throwable t){
                    List<AttributeCurrency> atrList = new ArrayList<>();
                    callback.getResponseCallback(atrList, false);
                }
            });
        }


    public interface ResponseCallback {
        void getResponseCallback(List<AttributeCurrency> attList, boolean checkInternet);
    }




    public List<AttributeCurrency> parseDataFromServer(CurrencyModel curModel) {
        Log.d(LOG_TAG, "get data from server");
        List<AttributeCurrency> attCurList = new ArrayList<>();
        AttributeCurrency attCur = new AttributeCurrency();
        AttributeCurrency attCur1 = new AttributeCurrency();
        AttributeCurrency attCur2 = new AttributeCurrency();
        AttributeCurrency attCur3 = new AttributeCurrency();
        AttributeCurrency attCur4 = new AttributeCurrency();
        AttributeCurrency attCur5 = new AttributeCurrency();
        AttributeCurrency attCur6 = new AttributeCurrency();
        AttributeCurrency attCur7 = new AttributeCurrency();
        AttributeCurrency attCur8 = new AttributeCurrency();
        AttributeCurrency attCur9 = new AttributeCurrency();

        attCur.setId(curModel.getValute().getAud().getId());
        attCur.setNumCode(curModel.getValute().getAud().getNumCode());
        attCur.setCharCode(curModel.getValute().getAud().getCharCode());
        attCur.setNominal(curModel.getValute().getAud().getNominal());
        attCur.setName(curModel.getValute().getAud().getName());
        attCur.setValue(curModel.getValute().getAud().getValue());

        attCurList.add(attCur);

        attCur1.setId(curModel.getValute().getAzn().getId());
        attCur1.setNumCode(curModel.getValute().getAzn().getNumCode());
        attCur1.setCharCode(curModel.getValute().getAzn().getCharCode());
        attCur1.setNominal(curModel.getValute().getAzn().getNominal());
        attCur1.setName(curModel.getValute().getAzn().getName());
        attCur1.setValue(curModel.getValute().getAzn().getValue());

        attCurList.add(attCur1);

        attCur2.setId(curModel.getValute().getCad().getId());
        attCur2.setNumCode(curModel.getValute().getCad().getNumCode());
        attCur2.setCharCode(curModel.getValute().getCad().getCharCode());
        attCur2.setNominal(curModel.getValute().getCad().getNominal());
        attCur2.setName(curModel.getValute().getCad().getName());
        attCur2.setValue(curModel.getValute().getCad().getValue());

        attCurList.add(attCur2);

        attCur3.setId(curModel.getValute().getCzk().getId());
        attCur3.setNumCode(curModel.getValute().getCzk().getNumCode());
        attCur3.setCharCode(curModel.getValute().getCzk().getCharCode());
        attCur3.setNominal(curModel.getValute().getCzk().getNominal());
        attCur3.setName(curModel.getValute().getCzk().getName());
        attCur3.setValue(curModel.getValute().getCzk().getValue());

        attCurList.add(attCur3);

        attCur4.setId(curModel.getValute().getEur().getId());
        attCur4.setNumCode(curModel.getValute().getEur().getNumCode());
        attCur4.setCharCode(curModel.getValute().getEur().getCharCode());
        attCur4.setNominal(curModel.getValute().getEur().getNominal());
        attCur4.setName(curModel.getValute().getEur().getName());
        attCur4.setValue(curModel.getValute().getEur().getValue());

        attCurList.add(attCur4);

        attCur5.setId(curModel.getValute().getJpy().getId());
        attCur5.setNumCode(curModel.getValute().getJpy().getNumCode());
        attCur5.setCharCode(curModel.getValute().getJpy().getCharCode());
        attCur5.setNominal(curModel.getValute().getJpy().getNominal());
        attCur5.setName(curModel.getValute().getJpy().getName());
        attCur5.setValue(curModel.getValute().getJpy().getValue());

        attCurList.add(attCur5);

        attCur6.setId(curModel.getValute().getRon().getId());
        attCur6.setNumCode(curModel.getValute().getRon().getNumCode());
        attCur6.setCharCode(curModel.getValute().getRon().getCharCode());
        attCur6.setNominal(curModel.getValute().getRon().getNominal());
        attCur6.setName(curModel.getValute().getRon().getName());
        attCur6.setValue(curModel.getValute().getRon().getValue());

        attCurList.add(attCur6);

        attCur7.setId(curModel.getValute().getUah().getId());
        attCur7.setNumCode(curModel.getValute().getUah().getNumCode());
        attCur7.setCharCode(curModel.getValute().getUah().getCharCode());
        attCur7.setNominal(curModel.getValute().getUah().getNominal());
        attCur7.setName(curModel.getValute().getUah().getName());
        attCur7.setValue(curModel.getValute().getUah().getValue());

        attCurList.add(attCur7);

        attCur8.setId(curModel.getValute().getUsd().getId());
        attCur8.setNumCode(curModel.getValute().getUsd().getNumCode());
        attCur8.setCharCode(curModel.getValute().getUsd().getCharCode());
        attCur8.setNominal(curModel.getValute().getUsd().getNominal());
        attCur8.setName(curModel.getValute().getUsd().getName());
        attCur8.setValue(curModel.getValute().getUsd().getValue());

        attCurList.add(attCur8);

        attCur9.setId(curModel.getValute().getUzs().getId());
        attCur9.setNumCode(curModel.getValute().getUzs().getNumCode());
        attCur9.setCharCode(curModel.getValute().getUzs().getCharCode());
        attCur9.setNominal(curModel.getValute().getUzs().getNominal());
        attCur9.setName(curModel.getValute().getUzs().getName());
        attCur9.setValue(curModel.getValute().getUzs().getValue());

        attCurList.add(attCur9);

        return attCurList;
    }
}