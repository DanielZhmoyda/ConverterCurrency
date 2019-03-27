package com.test.danz.di.modules;

import android.content.Context;

import com.test.danz.database.DBHelper;
import com.test.danz.repository.DatabaseActions;
import com.test.danz.repository.networking.IniRetrofit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class UtilsModule {
    @Provides
    @Singleton
    public DBHelper provideDBHelper(Context context) {
        return new DBHelper(context);
    }
    @Provides
    @Singleton
    public DatabaseActions provideDatabaseActions(DBHelper dbHelper) {
        return new DatabaseActions(dbHelper);
    }
    @Provides
    @Singleton
    public IniRetrofit provideIniRetrofit() {
        return new IniRetrofit();
    }
}
