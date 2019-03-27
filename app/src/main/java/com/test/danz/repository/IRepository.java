package com.test.danz.repository;

import com.test.danz.model.AttributeCurrency;
import java.util.List;

public interface IRepository {
    void getIniRetrofit(Repository.AfterRetroCallback callback);
    void setDataToDB(List<AttributeCurrency> listCur);
    void cvAdd(AttributeCurrency attCur);
    void cvUpdate(AttributeCurrency attCur, String charCode);

}
