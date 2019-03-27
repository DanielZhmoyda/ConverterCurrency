package com.test.danz.repository;

import android.content.ContentValues;
import com.test.danz.database.DBHelper;
import com.test.danz.database.DatabaseContract;
import com.test.danz.model.AttributeCurrency;
import com.test.danz.repository.networking.IniRetrofit;
import java.util.List;
import javax.inject.Inject;

public class Repository implements IRepository{
    private IniRetrofit iniRetrofit;
    private DatabaseActions databaseActions;
    private DBHelper dbHelper;

    public interface AfterRetroCallback {
         void sendDataToInteractor(List<AttributeCurrency> listCur);
    }

    @Inject
    public Repository(DBHelper dbHelper, IniRetrofit iniRetrofit, DatabaseActions databaseActions) {
        this.dbHelper = dbHelper;
        this.iniRetrofit = iniRetrofit;
        this.databaseActions = databaseActions;
    }

    @Override
    public void getIniRetrofit(final AfterRetroCallback callback) {
        iniRetrofit.iNetService(new IniRetrofit.ResponseCallback() {
            @Override
            public void getResponseCallback(List<AttributeCurrency> attList, boolean checkInternet) {
                setDataToDB(attList);
                if (checkInternet) {
                        callback.sendDataToInteractor(attList);
                } else {
                    databaseActions.loadCurrencies(new DatabaseActions.LoadUserCallback() {
                        @Override
                        public void onLoad(List<AttributeCurrency> attCurList) {
                            callback.sendDataToInteractor(attCurList);
                        }
                    });
                 //   Toast.makeText(presenter.getView() , "Произошла ошибка при загрузке данных с сервера. Проверьте интернет соединение. Возможно загружены старые данные" , Toast.LENGTH_LONG).show();
                }
                dbHelper.close();
            }
        });

    }

    @Override
    public void setDataToDB(List<AttributeCurrency> listCur) {
        for (AttributeCurrency attCur : listCur){

            if (databaseActions.getCursor().getCount()!= 0) {
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

        databaseActions.addCurrency(cv);

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

        databaseActions.updateCurrency(cv, charCode);

    }
}
