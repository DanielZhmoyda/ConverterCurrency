package com.test.danz.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.test.danz.presentation.R;
import com.test.danz.model.AttributeCurrency;
import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecHolder> {
    private List<AttributeCurrency> attCurList = new ArrayList<>();


    public void setDataRV(List<AttributeCurrency> listWithData) {
        attCurList.clear();
        attCurList.addAll(listWithData);
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public RecHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new RecHolder(inflater.inflate(R.layout.item_layout, parent, false));
    }
    @Override
    public void onBindViewHolder(@NonNull RecHolder holder, int position) {
        AttributeCurrency attributeCurrency = attCurList.get(position);
        holder.name.setText(attributeCurrency.getName());
        holder.charCode.setText(attributeCurrency.getCharCode());
        holder.value.setText(String.valueOf(attributeCurrency.getValue()));

    }

    @Override
    public int getItemCount() {
        return attCurList.size();
    }

    static class RecHolder extends RecyclerView.ViewHolder {

        public final TextView name;
        public final TextView charCode;
        public final TextView value;

        public RecHolder(View view) {
            super(view);
            name = view.findViewById(R.id.item_tvName);
            charCode = view.findViewById(R.id.item_tvChar);
            value = view.findViewById(R.id.item_tvValue);
        }
    }
}
