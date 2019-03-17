package com.test.danz.di;

import com.test.danz.di.modules.AppModule;
import com.test.danz.di.modules.InteractorModule;
import com.test.danz.di.modules.PresenterModule;
import com.test.danz.di.modules.RepositoryModule;
import com.test.danz.interactor.Interactor;
import com.test.danz.presentation.MainActivity;
import com.test.danz.presentation.Presenter;
import com.test.danz.repository.Repository;


import javax.inject.Singleton;

import dagger.Component;

@Component(modules = {AppModule.class, InteractorModule.class, PresenterModule.class, RepositoryModule.class})
@Singleton
public interface AppComponent {
    void inject(MainActivity mainActivity);
    void injectRepository(Repository repository);
    void injectRresenter(Presenter presenter);
    void injectInteractor(Interactor interactor);

}
