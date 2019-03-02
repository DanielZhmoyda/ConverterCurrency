package com.test.danz.presentation;

import com.test.danz.interactor.Interactor;
import com.test.danz.model.AttributeCurrency;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Presenter {

    private MainActivity view;
    private Interactor interactor;
    private List<AttributeCurrency> listAttCur = new ArrayList<>();

    public Presenter(MainActivity mainActivity) {
        view = mainActivity;
        interactor = new Interactor(this);
    }

    public void setFinalResponse(List<AttributeCurrency> recyclerList, List<AttributeCurrency> requestList) {
        recyclerList.addAll(requestList);
    }
    public MainActivity getView() {
        return view;
    }
    public void setResponseList(List<AttributeCurrency> listCur) {
        setFinalResponse(listAttCur, listCur);
        showRecycler();
    }

    public void attachView(MainActivity mainActivity) {
        view = mainActivity;
    }

    public void detachView() {
        view = null;
    }


    public void initializationRecycler() {
        interactor.setDataForRecycler();
    }

    public void showRecycler() {
        view.setData(listAttCur);
    }
    public void initializationRecyclerAfterEdit(double saveEdit) {
        view.setData(editRecyclerView(saveEdit));
    }


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