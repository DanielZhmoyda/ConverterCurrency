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
import com.test.danz.presentation.R;
import com.test.danz.model.AttributeCurrency;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final static String EDIT_LOG = "editLog";
    private RecyclerView userList;
    private EditText eT;
    private Presenter presenter;
    private RecyclerAdapter recyclerAdapter = new RecyclerAdapter();
    private final static String LOG_TAG = "converterLogs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(LOG_TAG, "hello");

        eT = findViewById(R.id.eT);
        presenter = new Presenter(this);
        presenter.initializationRecycler();

        initEditT();

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        userList = findViewById(R.id.recV);
        userList.setLayoutManager(layoutManager);
        userList.setAdapter(recyclerAdapter);



    }

    public void setData(List<AttributeCurrency> attCurList) {
        recyclerAdapter.setDataRV(attCurList);
    }

    public void initEditT() {

        eT.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                double saveEdit = Double.parseDouble(editable.toString());
                Log.d(EDIT_LOG, "text changed   " + saveEdit);
                presenter.initializationRecyclerAfterEdit(saveEdit);

            }
        });


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();

    }

}