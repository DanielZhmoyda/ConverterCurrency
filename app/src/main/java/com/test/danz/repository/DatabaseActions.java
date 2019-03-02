package com.test.danz.repository;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.AsyncTask;
import android.util.Log;

import com.test.danz.database.DBHelper;
import com.test.danz.database.DatabaseContract;
import com.test.danz.model.AttributeCurrency;

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


    public void addCurrency(ContentValues cv){
        AddCurrencyTask addTask = new AddCurrencyTask();
        addTask.execute(cv);
    }


    public void loadForRecycler(LoadUserCallback callback) {
        LoadForRecyclerTask lfrt = new LoadForRecyclerTask(callback);
        lfrt.execute();
    }

    public void updateCurrency(ContentValues cv, String charCode){
        UpdateCurrencyTask updateTask = new UpdateCurrencyTask(charCode);
        updateTask.execute(cv);
    }



    class AddCurrencyTask extends AsyncTask<ContentValues,Void,Void> {


        @Override
        protected Void doInBackground(ContentValues... contentValues) {
             ContentValues cv = contentValues[0];

            long i = dbHelper.getWritableDatabase().insert(DatabaseContract.TABLE_NAME, null, cv);

            return null;
        }

    }


    class LoadForRecyclerTask extends AsyncTask<Void,Void,List<AttributeCurrency>> {

        private List<AttributeCurrency> resultAttCur = new ArrayList<>();
        private final LoadUserCallback callback;

        LoadForRecyclerTask(LoadUserCallback callback) {
            this.callback = callback;
        }

        @Override
        protected List<AttributeCurrency> doInBackground(Void... params) {
            List<AttributeCurrency> listAC = new ArrayList<>();
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

            return listAC;
        }
        @Override
        protected void onPostExecute(List<AttributeCurrency> attCurForRV) {

            if (callback != null) {
                callback.onLoad(attCurForRV);
            }
        }
    }


    class UpdateCurrencyTask extends AsyncTask<ContentValues,Void,Void> {
        String charCode;

        public UpdateCurrencyTask(String charCode) {
            this.charCode = charCode;
        }
        @Override
        protected Void doInBackground(ContentValues... contentValues) {
            ContentValues cv = contentValues[0];
           int j = dbHelper.getWritableDatabase().update(DatabaseContract.TABLE_NAME,cv,"CHAR_CODE = ?", new String[] {charCode});
            Log.d(ANOTNER_LOG, "updated records = " + j +"\n");

            return null;
        }

    }
}