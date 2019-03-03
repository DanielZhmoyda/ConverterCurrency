package com.test.danz.interactor;

import com.test.danz.model.AttributeCurrency;

import java.util.List;

public interface IInteractor {
    void setDataForRecycler();
    void setDataToDB(List<AttributeCurrency> listCur);
    void cvAdd(AttributeCurrency attCur );
    void cvUpdate(AttributeCurrency attCur, String charCode);
}
