package com.test.danz.di.modules;

import android.content.Context;

import com.test.danz.database.DBHelper;
import com.test.danz.repository.DatabaseActions;
import com.test.danz.repository.IRepository;
import com.test.danz.repository.Repository;
import com.test.danz.repository.networking.IniRetrofit;

import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;

@Module
public class RepositoryModule {

    @Provides
    @Singleton
    public IRepository provideRepository(DBHelper dbHelper, IniRetrofit iniRetrofit, DatabaseActions databaseActions) {
        return new Repository(dbHelper, iniRetrofit, databaseActions);
    }
}
