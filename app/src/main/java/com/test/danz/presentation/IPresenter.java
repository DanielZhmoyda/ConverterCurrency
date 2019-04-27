package com.test.danz.presentation;

public interface IPresenter {
    void attachView(UserView mainActivity);
    void detachView();
    void initializationRecyclerView();
    void showRecycleView();
    void changeRecyclerViewAfterEdit(double saveEdit);
}
