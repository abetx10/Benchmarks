package com.example.benchmarks.presentation.adapter;

import android.content.Context;
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

public class MapsDataAdapter extends RecyclerView.Adapter<MapsDataAdapter.MapViewHolder> {
    private ArrayList<OperationItem> operationItemsList;
    Context context;

    public MapsDataAdapter(Context context, ArrayList<OperationItem> operationItemsList) {
        this.context = context;
        this.operationItemsList = operationItemsList;
    }

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
    public MapViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.data_item, parent, false);
        return new MapViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MapViewHolder holder, int position) {
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

    public class MapViewHolder extends RecyclerView.ViewHolder {
        TextView titleTv;
        TextView timeTv;
        ProgressBar itemPb;

        public MapViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTv = itemView.findViewById(R.id.tv_title);
            timeTv = itemView.findViewById(R.id.tv_time);
            itemPb = itemView.findViewById(R.id.pb_item);
        }
    }
}