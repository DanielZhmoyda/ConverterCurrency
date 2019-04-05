package com.test.danz.presentation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import com.test.danz.adapter.RecyclerAdapter;
import com.test.danz.app.App;
import com.test.danz.model.AttributeCurrency;

import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements UserView {

    private final static String EDIT_LOG = "editLog";
    private RecyclerView userList;
    private EditText editText;
    @Inject IPresenter presenter;
    private RecyclerAdapter recyclerAdapter = new RecyclerAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        App.getAppComponent().inject(this);

        editText = findViewById(R.id.eT);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        userList = findViewById(R.id.recV);
        userList.setLayoutManager(layoutManager);
        userList.setAdapter(recyclerAdapter);



    }

    @Override
    public void setDataToRecyclerView(List<AttributeCurrency> attCurList) {
        recyclerAdapter.setDataRV(attCurList);
    }

    @Override
    public void initEditText() {

        editText.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                double saveEdit;
                try {
                    saveEdit = Double.parseDouble(editable.toString());
                } catch (NumberFormatException e) {
                    saveEdit = 0;
                }

                Log.d(EDIT_LOG, "text changed   " + saveEdit);
                presenter.changeRecyclerViewAfterEdit(saveEdit);

            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.attachView(this);
        initEditText();
    }

    @Override
    protected void onPause() {
        super.onPause();
        presenter.detachView();
    }

}