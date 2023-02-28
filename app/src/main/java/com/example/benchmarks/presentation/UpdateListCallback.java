package com.example.benchmarks.presentation;

import com.example.benchmarks.domain.models.OperationItem;

import java.util.ArrayList;

public interface UpdateListCallback {
    void onUpdateList(ArrayList<OperationItem> list);
}