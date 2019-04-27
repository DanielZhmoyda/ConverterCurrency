package com.test.danz.di.modules;

import com.test.danz.interactor.Interactor;
import com.test.danz.presentation.IPresenter;
import com.test.danz.presentation.Presenter;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;

@Module
public class PresenterModule {

    @Provides
    @Singleton
    public IPresenter providePresenter(Interactor interactor) {
        return new Presenter(interactor);
    }
}
