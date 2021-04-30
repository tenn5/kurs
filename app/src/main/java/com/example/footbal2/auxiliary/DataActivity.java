package com.example.footbal2.auxiliary;

import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;

import com.example.footbal2.constants.TypeData;

public class DataActivity {
    private Context context;
    private RecyclerView recyclerView;
    private TypeData typeData;

    public DataActivity(Context context, RecyclerView recyclerView, TypeData typeData) {
        this.context = context;
        this.recyclerView = recyclerView;
        this.typeData = typeData;
    }

    public Context getContext() {
        return context;
    }

    public RecyclerView getRecyclerView() {
        return recyclerView;
    }

    public TypeData getTypeData() {
        return typeData;
    }
}
