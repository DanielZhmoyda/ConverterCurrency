package com.test.danz.repository;

import com.test.danz.database.DBHelper;

public interface IRepository {
    void getIniRetrofit(Repository.AfterRetroCallback callback);
    DBHelper getDBHelper();
    DatabaseActions getDatabaseActions();


}
