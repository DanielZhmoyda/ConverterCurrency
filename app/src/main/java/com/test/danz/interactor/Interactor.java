package com.test.danz.interactor;

import android.content.ContentValues;
import android.util.Log;
import android.widget.Toast;
import com.test.danz.database.DatabaseContract;
import com.test.danz.model.AttributeCurrency;
import com.test.danz.presentation.Presenter;
import com.test.danz.repository.DatabaseActions;
import com.test.danz.repository.IRepository;
import com.test.danz.repository.Repository;
import java.util.List;

public class Interactor implements IInteractor{
    private IRepository repository;

    private Presenter presenter;
    private final static String LOG_TAG = "converterLogs";

    public Interactor(Presenter presenter) {
        this.presenter = presenter;
        repository = new Repository(presenter.getView());
    }


    @Override
    public void setDataForRecycler() {
        Log.d(LOG_TAG, "INTERACTOR Attack: " + "\n");
        repository.getIniRetrofit(new Repository.AfterRetroCallback() {
            @Override
            public void afterRetroCallback(List<AttributeCurrency> listCur, boolean checkInternet) {
                setDataToDB(listCur);
                     if (checkInternet) {
                presenter.setResponseList(listCur);
                } else {
                    repository.getDatabaseActions().loadForRecycler(new DatabaseActions.LoadUserCallback() {
                        @Override
                        public void onLoad(List<AttributeCurrency> attCurList) {
                            presenter.setResponseList(attCurList);
                        }
                    });
                         Toast.makeText(presenter.getView() , "Произошла ошибка при загрузке данных с сервера. Проверьте интернет соединение. Возможно загружены старые данные" , Toast.LENGTH_LONG).show();
                }
                repository.getDBHelper().close();
            }
        });



    }


    @Override
    public void setDataToDB(List<AttributeCurrency> listCur) {
        for (AttributeCurrency attCur : listCur){

            if (repository.getDatabaseActions().getCursor().getCount()!= 0) {
                cvUpdate(attCur,attCur.getCharCode());
            }
            else
                cvAdd(attCur);

        }
    }

    @Override
    public void cvAdd(AttributeCurrency attCur ) {
        ContentValues cv = new ContentValues();
        cv.put(DatabaseContract.KEY_ID,attCur.getId());
        cv.put(DatabaseContract.KEY_NUM_CODE,attCur.getNumCode());
        cv.put(DatabaseContract.KEY_CHAR_CODE,attCur.getCharCode());
        cv.put(DatabaseContract.KEY_NOMINAL,attCur.getNominal());
        cv.put(DatabaseContract.KEY_NAME,attCur.getName());
        cv.put(DatabaseContract.KEY_VALUE,attCur.getValue());

        repository.getDatabaseActions().addCurrency(cv);

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

        repository.getDatabaseActions().updateCurrency(cv, charCode);

    }

}
