package com.test.danz.presentation;

import com.test.danz.model.AttributeCurrency;

import java.lang.ref.WeakReference;
import java.util.List;

public interface IPresenter {
    void setResponseToMainList(List<AttributeCurrency> mainList, List<AttributeCurrency> requestList);
    void attachView(UserView mainActivity);
    void detachView();
    void initializationRecyclerView();
    void showRecycleView();
    void changeRecyclerViewAfterEdit(double saveEdit);
}
