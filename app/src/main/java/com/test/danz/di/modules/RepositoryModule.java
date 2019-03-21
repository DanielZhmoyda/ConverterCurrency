package com.test.danz.di.modules;

import android.content.Context;
import com.test.danz.repository.IRepository;
import com.test.danz.repository.Repository;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;

@Module
public class RepositoryModule {

    @Provides
    @Singleton
    public IRepository provideRepository(Context context) {
        return new Repository(context);
    }
}
