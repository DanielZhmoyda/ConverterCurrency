package com.test.danz.presentation;

import com.test.danz.model.AttributeCurrency;

import java.util.List;

public interface UserView {
    void setData(List<AttributeCurrency> attCurList);
    void initEditT();
}
