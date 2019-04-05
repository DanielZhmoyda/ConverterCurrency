package com.test.danz.repository;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.AsyncTask;
import android.util.Log;
import com.test.danz.database.DBHelper;
import com.test.danz.database.DatabaseContract;
import com.test.danz.model.AttributeCurrency;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class DatabaseActions {
    private final DBHelper dbHelper;
    private final static String ANOTNER_LOG = "convDBlogs";

    public interface LoadUserCallback {
        void onLoad(List<AttributeCurrency> attCurList);
    }

    public DatabaseActions(DBHelper dbHelper) {
        this.dbHelper = dbHelper;
    }


    public Cursor getCursor() {
        return dbHelper.getWritableDatabase().query(DatabaseContract.TABLE_NAME,null,null,null,null,null,null);
    }


    public void addCurrency(WeakReference<ContentValues> cvWeakRef){
        AddCurrencyTask addTask = new AddCurrencyTask(new WeakReference<>(dbHelper));
        addTask.execute(cvWeakRef);
    }


    public void loadCurrencies(LoadUserCallback callback) {
        LoadCurrenciesTask loadCurrenciesTask = new LoadCurrenciesTask(callback, new WeakReference<>(dbHelper));
        loadCurrenciesTask.execute();
    }

    public void updateCurrency(WeakReference<ContentValues> cvWeakRef,WeakReference<String> charCodeWeakRef){
        UpdateCurrencyTask updateTask = new UpdateCurrencyTask(charCodeWeakRef, new WeakReference<>(dbHelper));
        updateTask.execute(cvWeakRef);
    }



    static class AddCurrencyTask extends AsyncTask<WeakReference<ContentValues>,Void,Void> {

        private WeakReference<DBHelper> dbHelperWeakRef;

        public AddCurrencyTask(WeakReference<DBHelper> dbHelperWeakRef) {
            this.dbHelperWeakRef = dbHelperWeakRef;
        }
        @Override
        protected Void doInBackground(WeakReference<ContentValues>... contentValues) {
             ContentValues cv = contentValues[0].get();
             DBHelper dbHelper = dbHelperWeakRef.get();

            if (cv != null & dbHelper != null) {
                dbHelper.getWritableDatabase().insert(DatabaseContract.TABLE_NAME, null, cv);
            }

            return null;
        }

    }


    static class LoadCurrenciesTask extends AsyncTask<Void,Void,List<AttributeCurrency>> {
        private final LoadUserCallback callback;
        private WeakReference<DBHelper> dbHelperWeakRef;

        LoadCurrenciesTask(LoadUserCallback callback, WeakReference<DBHelper> dbHelperWeakRef) {
            this.callback = callback;
            this.dbHelperWeakRef = dbHelperWeakRef;
        }

        @Override
        protected List<AttributeCurrency> doInBackground(Void... params) {
            List<AttributeCurrency> listAC = new ArrayList<>();

            DBHelper dbHelper = dbHelperWeakRef.get();
            if (dbHelper != null) {
                Cursor c = dbHelper.getWritableDatabase().query(DatabaseContract.TABLE_NAME, null, null, null, null, null, null);
                if (c.moveToFirst()) {
                    do {

                        AttributeCurrency attCur = new AttributeCurrency();
                        attCur.setCharCode(c.getString(c.getColumnIndex(DatabaseContract.KEY_CHAR_CODE)));
                        attCur.setValue(c.getDouble(c.getColumnIndex(DatabaseContract.KEY_VALUE)));
                        attCur.setName(c.getString(c.getColumnIndex(DatabaseContract.KEY_NAME)));
                        attCur.setNominal(c.getInt(c.getColumnIndex(DatabaseContract.KEY_NOMINAL)));
                        listAC.add(attCur);

                    } while (c.moveToNext());
                }
                c.close();
            }

            return listAC;
        }
        @Override
        protected void onPostExecute(List<AttributeCurrency> attCurForRV) {
            super.onPostExecute(attCurForRV);
            if (callback != null) {
                callback.onLoad(attCurForRV);
            }
        }
    }


    static class UpdateCurrencyTask extends AsyncTask<WeakReference<ContentValues>,Void,Void> {
        private WeakReference<String> charCodeWeakRef;
        private WeakReference<DBHelper> dbHelperWeakRef;

        public UpdateCurrencyTask(WeakReference<String> charCodeWeakRef, WeakReference<DBHelper> dbHelperWeakRef) {
            this.charCodeWeakRef = charCodeWeakRef;
            this.dbHelperWeakRef = dbHelperWeakRef;
        }
        @Override
        protected Void doInBackground(WeakReference<ContentValues>... contentValues) {
            ContentValues cv = contentValues[0].get();
            DBHelper dbHelper = dbHelperWeakRef.get();
            String charCode = charCodeWeakRef.get();
            int j = 0;
            if (cv != null & charCode != null & dbHelper != null) {
                j = dbHelper.getWritableDatabase().update(DatabaseContract.TABLE_NAME,cv,"CHAR_CODE = ?", new String[] {charCode});
            }
            Log.d(ANOTNER_LOG, "updated records = " + j +"\n");

            return null;
        }

    }
}