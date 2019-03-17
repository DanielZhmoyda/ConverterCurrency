package com.test.danz.di.modules;

import android.content.Context;

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
    IPresenter providePresenter(Interactor interactor) {
        return new Presenter(interactor);
    }
}
