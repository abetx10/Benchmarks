package com.example.benchmarks.presentation.callbacks;

import androidx.recyclerview.widget.DiffUtil;

import com.example.benchmarks.domain.models.OperationItem;

import java.util.ArrayList;
import java.util.List;

public class OperationItemDiffCallback extends DiffUtil.Callback {
    public List<OperationItem> newList;
    public List<OperationItem> oldList;

    public OperationItemDiffCallback(ArrayList<OperationItem> operationItemsList, ArrayList<OperationItem> updateOperationItemsList) {
        this.oldList = operationItemsList;
        this.newList = updateOperationItemsList;
    }

    @Override
    public int getOldListSize() {
        return oldList.size();
    }

    @Override
    public int getNewListSize() {
        return newList.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        int oldPos = Integer.parseInt(String.valueOf(oldItemPosition));
        int newPos = Integer.parseInt(String.valueOf(newItemPosition));
        return oldList.get(oldPos).getTitle().equals(newList.get(newPos).getTitle());
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        int oldPos = Integer.parseInt(String.valueOf(oldItemPosition));
        int newPos = Integer.parseInt(String.valueOf(newItemPosition));
        return oldList.get(oldPos).equals(newList.get(newPos));
    }
}