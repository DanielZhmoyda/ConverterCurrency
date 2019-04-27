package com.test.danz.presentation;

import com.test.danz.model.AttributeCurrency;
import java.util.List;

public interface UserView {
    void setDataToRecyclerView(List<AttributeCurrency> attCurList);
    void initEditText();
}
