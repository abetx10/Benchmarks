package com.example.benchmarks.presentation.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.benchmarks.R;
import com.example.benchmarks.domain.models.OperationItem;
import com.example.benchmarks.domain.models.OperationStatus;
import com.example.benchmarks.presentation.callbacks.OperationItemDiffCallback;

import java.util.ArrayList;

public class CollectionsDataAdapter extends RecyclerView.Adapter<CollectionsDataAdapter.CollectionsViewHolder> {
//        MutableLiveData<ArrayList<OperationItem>> operationItemsList;

    private ArrayList<OperationItem> operationItemsList;
    Context context;

    public CollectionsDataAdapter(Context context, ArrayList<OperationItem> operationItemsList) {
        this.context = context;
        this.operationItemsList = operationItemsList;
    }

//    public void updateList(ArrayList<OperationItem> updateOperationItemsList) {
//        DiffUtil.Callback diffCallback = new OperationItemDiffCallback(operationItemsList, updateOperationItemsList);
//        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(diffCallback);
//        ArrayList<OperationItem> currentList = operationItemsList;
//        ArrayList<OperationItem> updatedList = updateOperationItemsList;
//        for (int i = 0; i < updateOperationItemsList.size(); i++) {
//            Log.d("updateO", "Index: " + i + " Value: " + updateOperationItemsList.get(i).statusReady);
//            Log.d("updateO", "Index: " + i + " Value: " + updateOperationItemsList.get(i).time);
//        }
//        currentList.clear();
//        currentList.addAll(updatedList);
//        diffResult.dispatchUpdatesTo(this);
//    }

    public void updateList(ArrayList<OperationItem> updateOperationItemsList) {
        DiffUtil.Callback diffCallback = new OperationItemDiffCallback(operationItemsList, updateOperationItemsList);
        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(diffCallback);

        for (int i = 0; i < updateOperationItemsList.size(); i++) {
            OperationItem updatedItem = updateOperationItemsList.get(i);
            if (i < operationItemsList.size()) {
                OperationItem currentItem = operationItemsList.get(i);
                currentItem.statusReady = updatedItem.statusReady;
                currentItem.time = updatedItem.time;
            } else {
                operationItemsList.add(updatedItem);
            }
        }
        diffResult.dispatchUpdatesTo(this);
    }

    @NonNull
    @Override
    public CollectionsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.data_item, parent, false);
        return new CollectionsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CollectionsViewHolder holder, int position) {
        OperationItem operationItem = operationItemsList.get(position);
        holder.titleTv.setText(operationItem.title);
        if (operationItem.statusReady == OperationStatus.NOT_READY) {
            holder.itemPb.setVisibility(View.VISIBLE);
        } else {
            holder.itemPb.setVisibility(View.GONE);
        }
        holder.timeTv.setText(operationItem.time);
    }

    @Override
    public int getItemCount() {
        return operationItemsList.size();
    }

    public static class CollectionsViewHolder extends RecyclerView.ViewHolder {
        TextView titleTv;
        TextView timeTv;
        ProgressBar itemPb;

        public CollectionsViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTv = itemView.findViewById(R.id.tv_title);
            timeTv = itemView.findViewById(R.id.tv_time);
            itemPb = itemView.findViewById(R.id.pb_item);
        }
    }
}