package com.test.danz.presentation;

import com.test.danz.interactor.IInteractor;
import com.test.danz.interactor.Interactor;
import com.test.danz.model.AttributeCurrency;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Presenter implements IPresenter{

    private MainActivity view;
    private IInteractor interactor;
    private List<AttributeCurrency> listAttCur = new ArrayList<>();

    public Presenter(MainActivity mainActivity) {
        view = mainActivity;
        interactor = new Interactor(this);
    }

    @Override
    public void setFinalResponse(List<AttributeCurrency> recyclerList, List<AttributeCurrency> requestList) {
        recyclerList.addAll(requestList);
    }
    @Override
    public MainActivity getView() {
        return view;
    }
    @Override
    public void setResponseList(List<AttributeCurrency> listCur) {
        setFinalResponse(listAttCur, listCur);
        showRecycler();
    }

    @Override
    public void attachView(MainActivity mainActivity) {
        view = mainActivity;
    }
    @Override
    public void detachView() {
        view = null;
    }

    @Override
    public void initializationRecycler() {
        interactor.setDataForRecycler();
    }
    @Override
    public void showRecycler() {
        view.setData(listAttCur);
    }
    @Override
    public void initializationRecyclerAfterEdit(double saveEdit) {
        view.setData(editRecyclerView(saveEdit));
    }

    @Override
    public List<AttributeCurrency> editRecyclerView (Double saveEdit) {
        List<AttributeCurrency> localList = new ArrayList<>();
        for(AttributeCurrency attCur: listAttCur) {
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