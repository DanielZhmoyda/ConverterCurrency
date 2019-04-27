package com.test.danz.interactor;

import android.util.Log;

import com.test.danz.model.AttributeCurrency;
import com.test.danz.repository.IRepository;
import com.test.danz.repository.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

public class Interactor {

    private IRepository repository;
    private List<AttributeCurrency> intermediateListAttCur = new ArrayList<>();
    private final static String LOG_TAGG = "list";

    public interface CallbackToPresenter{
        void sendDataToPresenter(List<AttributeCurrency> listAttCur);
    }

    @Inject
    public Interactor(IRepository repository) {
        this.repository = repository;
    }

    private void setDataToIntermediateList() {
        repository.getIniRetrofit(new Repository.AfterRetroCallback() {
            @Override
            public void sendDataToInteractor(List<AttributeCurrency> listCur) {
                Log.d(LOG_TAGG, "interactorList1 size = " + listCur.size());
                intermediateListAttCur.clear();
                intermediateListAttCur.addAll(listCur);
            }
        });
    }

    public void sendDataToPresenter(final CallbackToPresenter callback) {

        setDataToIntermediateList();
        Log.d(LOG_TAGG, "interactorList2 size = " + intermediateListAttCur.size() + "\n");
        callback.sendDataToPresenter(intermediateListAttCur);
    }

    public List<AttributeCurrency> editRecyclerView (Double saveEdit) {
        List<AttributeCurrency> localList = new ArrayList<>();
        for(AttributeCurrency attCur: intermediateListAttCur) {
            AttributeCurrency attributeCurrency = new AttributeCurrency();
            attributeCurrency.setName(attCur.getName());
            attributeCurrency.setValue(attCur.getValue());
            attributeCurrency.setCharCode(attCur.getCharCode());
            attributeCurrency.setNominal(attCur.getNominal());
            localList.add(attributeCurrency);
        }

        for(AttributeCurrency attCur: localList) {
            double value =  saveEdit * attCur.getNominal() / attCur.getValue();
            attCur.setValue(Double.valueOf(String.valueOf(new BigDecimal(value).setScale(3, BigDecimal.ROUND_HALF_UP))));
        }
        return localList;
    }
}
