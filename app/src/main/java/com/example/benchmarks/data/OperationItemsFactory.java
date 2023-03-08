package com.example.benchmarks.data;

import com.example.benchmarks.domain.models.OperationItem;

import java.util.ArrayList;

public class OperationItemsFactory {

    public ArrayList<OperationItem> getTitleData(String[] titles) {
        ArrayList<OperationItem> arrayList = new ArrayList<>();
        for (String title : titles) {
            arrayList.add(new OperationItem(title));
        }
        return arrayList;
    }
}