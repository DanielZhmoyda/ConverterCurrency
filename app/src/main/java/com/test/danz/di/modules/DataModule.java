package com.test.danz.di.modules;

import android.content.Context;

import com.test.danz.database.DBHelper;
import com.test.danz.repository.DatabaseActions;
import com.test.danz.repository.networking.IniRetrofit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class DataModule {
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
    public HttpLoggingInterceptor provideHttpLoggingInterceptor() {
        return new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
    }
    @Provides
    @Singleton
    public OkHttpClient provideOkHttpClient(HttpLoggingInterceptor logger) {
        return new OkHttpClient.Builder().addInterceptor(logger).build();
    }
    @Provides
    @Singleton
    public Retrofit.Builder provideRetrofitBuilder(OkHttpClient client) {
        return new Retrofit
                .Builder()
                .client(client)
                .baseUrl("https://www.cbr-xml-daily.ru/")
                .addConverterFactory(GsonConverterFactory.create());
    }
    @Provides
    @Singleton
    public IniRetrofit provideIniRetrofit(Retrofit.Builder builder) {
        return new IniRetrofit(builder);
    }
}
