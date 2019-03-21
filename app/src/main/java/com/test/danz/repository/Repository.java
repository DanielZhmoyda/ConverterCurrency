package com.test.danz.repository;

import android.content.ContentValues;
import android.content.Context;
import android.util.Log;
import com.test.danz.database.DBHelper;
import com.test.danz.database.DatabaseContract;
import com.test.danz.model.AttributeCurrency;
import com.test.danz.repository.networking.IniRetrofit;
import java.util.List;
import javax.inject.Inject;

public class Repository implements IRepository{
    private Context context;
    private final static String LOG_TAG = "converterLogs";

    public interface AfterRetroCallback {
         void sendDataToInteractor(List<AttributeCurrency> listCur);
    }

    @Inject
    public Repository(Context context) {
        this.context = context;
        Log.d(LOG_TAG, "repository created + " + context + "\n");
    }

    @Override
    public void getIniRetrofit(final AfterRetroCallback callback) {
        new IniRetrofit().iNetService(new IniRetrofit.ResponseCallback() {
            @Override
            public void getResponseCallback(List<AttributeCurrency> attList, boolean checkInternet) {
                setDataToDB(attList);
                if (checkInternet) {
                        callback.sendDataToInteractor(attList);
                } else {
                    getDatabaseActions().loadCurrencies(new DatabaseActions.LoadUserCallback() {
                        @Override
                        public void onLoad(List<AttributeCurrency> attCurList) {
                            callback.sendDataToInteractor(attCurList);
                        }
                    });
                 //   Toast.makeText(presenter.getView() , "Произошла ошибка при загрузке данных с сервера. Проверьте интернет соединение. Возможно загружены старые данные" , Toast.LENGTH_LONG).show();
                }
                getDBHelper().close();
            }
        });

    }

    @Override
    public void setDataToDB(List<AttributeCurrency> listCur) {
        for (AttributeCurrency attCur : listCur){

            if (getDatabaseActions().getCursor().getCount()!= 0) {
                cvUpdate(attCur,attCur.getCharCode());
            }
            else
                cvAdd(attCur);

        }
    }

    @Override
    public void cvAdd(AttributeCurrency attCur) {
        ContentValues cv = new ContentValues();
        cv.put(DatabaseContract.KEY_ID,attCur.getId());
        cv.put(DatabaseContract.KEY_NUM_CODE,attCur.getNumCode());
        cv.put(DatabaseContract.KEY_CHAR_CODE,attCur.getCharCode());
        cv.put(DatabaseContract.KEY_NOMINAL,attCur.getNominal());
        cv.put(DatabaseContract.KEY_NAME,attCur.getName());
        cv.put(DatabaseContract.KEY_VALUE,attCur.getValue());

        getDatabaseActions().addCurrency(cv);

    }

    @Override
    public void cvUpdate(AttributeCurrency attCur, String charCode) {
        ContentValues cv = new ContentValues();
        cv.put(DatabaseContract.KEY_ID,attCur.getId());
        cv.put(DatabaseContract.KEY_NUM_CODE,attCur.getNumCode());
        cv.put(DatabaseContract.KEY_CHAR_CODE,attCur.getCharCode());
        cv.put(DatabaseContract.KEY_NOMINAL,attCur.getNominal());
        cv.put(DatabaseContract.KEY_NAME,attCur.getName());
        cv.put(DatabaseContract.KEY_VALUE,attCur.getValue());

        getDatabaseActions().updateCurrency(cv, charCode);

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
