package com.test.danz.presentation;

import com.test.danz.interactor.Interactor;
import com.test.danz.model.AttributeCurrency;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class Presenter implements IPresenter{

    private UserView view;
    private Interactor interactor;
    private List<AttributeCurrency> listAttCur = new ArrayList<>();

    @Inject
    public Presenter(Interactor interactor) {
        this.interactor = interactor;
    }

    @Override
    public void setResponseToMainList(List<AttributeCurrency> mainList, List<AttributeCurrency> requestList) {
        mainList.addAll(requestList);
    }

    @Override
    public void attachView(UserView mainActivity) {
        view = mainActivity;
    }

    @Override
    public void detachView() {
        view = null;
    }

    @Override
    public void initializationRecyclerView() {
        interactor.setDataForRecycler(new Interactor.CallbackToPresenter() {
            @Override
            public void sendDataToPresenter(List<AttributeCurrency> listCur) {
                setResponseToMainList(listAttCur, listCur);
                showRecycleView();
            }
        });
    }

    @Override
    public void showRecycleView() {
        view.setDataToRecyclerView(listAttCur);
    }

    @Override
    public void changeRecyclerViewAfterEdit(double saveEdit) {
        view.setDataToRecyclerView(editRecyclerView(saveEdit));
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