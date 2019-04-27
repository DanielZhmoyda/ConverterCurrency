package com.test.danz.presentation;

import android.util.Log;

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
    private static final String LOG_TAG = "list";

    @Inject
    public Presenter(Interactor interactor) {
        this.interactor = interactor;
    }

    @Override
    public void attachView(UserView view) {
        viewWeakRef = new WeakReference<>(view);
        initializationRecyclerView();
    }

    @Override
    public void detachView() {
        viewWeakRef = null;
    }

    @Override
    public void initializationRecyclerView() {
        interactor.sendDataToPresenter(new Interactor.CallbackToPresenter() {
            @Override
            public void sendDataToPresenter(List<AttributeCurrency> listCur) {
                listAttCur.clear();
                listAttCur.addAll(listCur);
                showRecycleView();
            }
        });
    }

    @Override
    public void showRecycleView() {
        UserView userView = viewWeakRef.get();
        if (userView != null)
        userView.setDataToRecyclerView(listAttCur);
        Log.d(LOG_TAG, "list size = " + listAttCur.size());
    }

    @Override
    public void changeRecyclerViewAfterEdit(double saveEdit) {
        UserView userView = viewWeakRef.get();
        if (userView != null)
        userView.setDataToRecyclerView(interactor.editRecyclerView(saveEdit));
    }

}