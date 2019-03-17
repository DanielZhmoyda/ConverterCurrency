package com.test.danz.di.modules;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    private Context appContext;

    public AppModule(Context appContext) {
        this.appContext = appContext;
    }
    @Provides
    @Singleton
    Context provideContext() {
        return appContext;
    }

}
