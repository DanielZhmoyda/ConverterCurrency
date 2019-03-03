package com.test.danz.presentation;

import com.test.danz.model.AttributeCurrency;

import java.util.List;

public interface IPresenter {
    void setFinalResponse(List<AttributeCurrency> recyclerList, List<AttributeCurrency> requestList);
    MainActivity getView();
    void setResponseList(List<AttributeCurrency> listCur);
    void attachView(MainActivity mainActivity);
    void detachView();
    void initializationRecycler();
    void showRecycler();
    void initializationRecyclerAfterEdit(double saveEdit);
    List<AttributeCurrency> editRecyclerView (Double saveEdit);
}
