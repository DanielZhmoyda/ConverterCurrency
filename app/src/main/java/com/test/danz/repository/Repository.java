package com.test.danz.repository;

import android.content.Context;
import android.util.Log;

import com.test.danz.database.DBHelper;
import com.test.danz.model.AttributeCurrency;
import com.test.danz.repository.networking.IniRetrofit;

import java.util.ArrayList;
import java.util.List;

public class Repository implements IRepository{
    private Context context;
    private final static String LOG_TAG = "converterLogs";

    public interface AfterRetroCallback {
         void afterRetroCallback(List<AttributeCurrency> listCur, boolean checkInternet);
    }

    public Repository(Context context) {
        this.context = context;
        Log.d(LOG_TAG, "repository created + " + context + "\n");
    }

    @Override
    public void getIniRetrofit(final AfterRetroCallback callback) {
        new IniRetrofit().executeRetrofit(new IniRetrofit.ResponseCallback() {
            @Override
            public void getResponseCallback(List<AttributeCurrency> attList, boolean checkInternet) {
                callback.afterRetroCallback(attList, checkInternet);
            }
        });

    }

    @Override
    public DBHelper getDBHelper() {
        return new DBHelper(context);
    }
    @Override
    public DatabaseActions getDatabaseActions() {
        return new DatabaseActions(getDBHelper());
    }

}
