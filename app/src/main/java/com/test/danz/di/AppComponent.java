package com.test.danz.di;

import com.test.danz.di.modules.AppModule;
import com.test.danz.di.modules.InteractorModule;
import com.test.danz.di.modules.PresenterModule;
import com.test.danz.di.modules.RepositoryModule;
import com.test.danz.presentation.MainActivity;
import javax.inject.Singleton;
import dagger.Component;

@Component(modules = {AppModule.class, RepositoryModule.class, InteractorModule.class, PresenterModule.class    })
@Singleton
public interface AppComponent {
    void inject(MainActivity mainActivity);
}
