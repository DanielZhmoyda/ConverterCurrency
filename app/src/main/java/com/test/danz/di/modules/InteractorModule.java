package com.test.danz.di.modules;

import com.test.danz.interactor.Interactor;
import com.test.danz.repository.IRepository;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;

@Module
public class InteractorModule {

    @Provides
    @Singleton
    public Interactor provideInteractor(IRepository repository) {
        return new Interactor(repository);
    }
}
