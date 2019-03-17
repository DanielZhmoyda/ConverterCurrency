package com.test.danz.app;

import android.app.Application;

import com.test.danz.di.AppComponent;
import com.test.danz.di.DaggerAppComponent;
import com.test.danz.di.modules.AppModule;
import com.test.danz.di.modules.InteractorModule;
import com.test.danz.di.modules.PresenterModule;
import com.test.danz.di.modules.RepositoryModule;

public class App extends Application {
    private static AppComponent component;

    public static AppComponent getComponent() {
        return component;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        component = buildAppComponent();
    }

    protected AppComponent buildAppComponent() {
        return DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

}
