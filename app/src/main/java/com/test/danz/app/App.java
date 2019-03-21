package com.test.danz.app;

import android.app.Application;
import com.test.danz.di.AppComponent;
import com.test.danz.di.DaggerAppComponent;
import com.test.danz.di.modules.AppModule;

public class App extends Application {
    private static AppComponent appComponent;

    public static AppComponent getAppComponent() {
        return appComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = buildComponent();
    }

    protected AppComponent buildComponent() {
        return DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

}
