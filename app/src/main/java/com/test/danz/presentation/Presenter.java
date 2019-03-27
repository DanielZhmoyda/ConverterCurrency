package com.test.danz.presentation;

import com.test.danz.interactor.Interactor;
import com.test.danz.model.AttributeCurrency;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class Presenter implements IPresenter{

    private WeakReference<UserView> viewWeakRef = null;
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
    public void attachView(UserView view) {
        viewWeakRef = new WeakReference<>(view);
    }

    @Override
    public void detachView() {
        viewWeakRef = null;
    }

    @Override
    public void initializationRecyclerView() {
        interactor.setDataToIntermediateList();
        interactor.sendDataToPresenter(new Interactor.CallbackToPresenter() {
            @Override
            public void sendDataToPresenter(List<AttributeCurrency> listCur) {
                setResponseToMainList(listAttCur, listCur);
                showRecycleView();
            }
        });
    }

    @Override
    public void showRecycleView() {
        viewWeakRef.get().setDataToRecyclerView(listAttCur);
    }

    @Override
    public void changeRecyclerViewAfterEdit(double saveEdit) {
        viewWeakRef.get().setDataToRecyclerView(interactor.editRecyclerView(saveEdit));
    }

}