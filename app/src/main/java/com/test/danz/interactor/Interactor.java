package com.test.danz.interactor;

import com.test.danz.model.AttributeCurrency;
import com.test.danz.repository.IRepository;
import com.test.danz.repository.Repository;
import java.util.List;
import javax.inject.Inject;

public class Interactor {

    private IRepository repository;

    public interface CallbackToPresenter{
        void sendDataToPresenter(List<AttributeCurrency> listAttCur);
    }

    @Inject
    public Interactor(IRepository repository) {
        this.repository = repository;
    }



    public void setDataForRecycler(final CallbackToPresenter callback) {
        repository.getIniRetrofit(new Repository.AfterRetroCallback() {
            @Override
            public void sendDataToInteractor(List<AttributeCurrency> listCur) {
                callback.sendDataToPresenter(listCur);
            }
        });
    }
}
