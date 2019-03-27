package com.test.danz.interactor;

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

    public interface CallbackToPresenter{
        void sendDataToPresenter(List<AttributeCurrency> listAttCur);
    }

    @Inject
    public Interactor(IRepository repository) {
        this.repository = repository;
    }

    private void setResponseToIntermediateList(List<AttributeCurrency> intermediateList, List<AttributeCurrency> requestList) {
        intermediateList.addAll(requestList);
    }

    public void setDataToIntermediateList() {
        repository.getIniRetrofit(new Repository.AfterRetroCallback() {
            @Override
            public void sendDataToInteractor(List<AttributeCurrency> listCur) {
                setResponseToIntermediateList(intermediateListAttCur, listCur);
            }
        });
    }

    public void sendDataToPresenter(final CallbackToPresenter callback) {

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
