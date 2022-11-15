package com.example.benchmarks.presentation.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.example.benchmarks.R;
import com.example.benchmarks.domain.models.TimeDataList;
import com.example.benchmarks.domain.models.TitleData;
import com.example.benchmarks.domain.operation.Operation;

import java.util.ArrayList;

public class CollectionsDataLineAdapter extends RecyclerView.Adapter<CollectionsDataLineAdapter.CollectionsViewHolder> {
//    ArrayList<TimeDataList> timeDataList;
    MutableLiveData<ArrayList<Operation>> arrayListData;
    ArrayList<TitleData> titleDataArrayList;
    Context context;

    public CollectionsDataLineAdapter(Context context, MutableLiveData<ArrayList<Operation>> arrayListData, ArrayList<TitleData> titleDataArrayList) {
        this.context = context;
        this.arrayListData = arrayListData;
        this.titleDataArrayList = titleDataArrayList;
    }

    @NonNull
    @Override
    public CollectionsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.data_line_item, parent, false);
        return new CollectionsViewHolder(view);
    }

//    @Override
//    public void onBindViewHolder(@NonNull CollectionsViewHolder holder, int position) {
//        TimeData timeData = timeDataArrayList.get(position);
//        holder.titleTv.setText(timeData.title);
//        holder.arrayListItemTv.setText(timeData.timeArrayList);
//    }

    @Override
    public void onBindViewHolder(@NonNull CollectionsViewHolder holder, int position) {
        TimeDataList timeDataList = this.arrayListData.(position);
        TitleData titleData = titleDataArrayList.get(position);
        holder.titleTv.setText(titleData.title);

        if (timeDataList.stateArrayList.equals("ready")) {
            holder.itemArrayPb.setVisibility(View.GONE);
            holder.arrayListItemTv.setVisibility(View.VISIBLE);
            if (timeDataList.timeArrayList.equals("0")) {
                holder.arrayListItemTv.setText("N/A");
            } else {
                holder.arrayListItemTv.setText(timeDataList.timeArrayList);
            }
        } else if (timeDataList.stateArrayList.equals("progress")) {
            holder.itemArrayPb.setVisibility(View.VISIBLE);
            holder.arrayListItemTv.setVisibility(View.GONE);
        }

        if (timeDataList.stateLinkedList.equals("ready")) {
            holder.itemLinkedPb.setVisibility(View.GONE);
            holder.linkedListItemTV.setVisibility(View.VISIBLE);
            if (timeDataList.timeLinkedList.equals("0")) {
                holder.linkedListItemTV.setText("N/A");
            } else {
                holder.linkedListItemTV.setText(timeDataList.timeLinkedList);
            }
        } else if (timeDataList.stateLinkedList.equals("progress")) {
            holder.itemLinkedPb.setVisibility(View.VISIBLE);
            holder.linkedListItemTV.setVisibility(View.GONE);
        }

        if (timeDataList.stateCopyList.equals("ready")) {
            holder.itemCopyPb.setVisibility(View.GONE);
            holder.copyItemTV.setVisibility(View.VISIBLE);
            if (timeDataList.timeLinkedList.equals("0")) {
                holder.copyItemTV.setText("N/A");
            } else {
                holder.copyItemTV.setText(timeDataList.timeCopyList);
            }
        } else if (timeDataList.stateCopyList.equals("progress")) {
            holder.itemCopyPb.setVisibility(View.VISIBLE);
            holder.copyItemTV.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return timeDataList.size();
    }

    public static class CollectionsViewHolder extends RecyclerView.ViewHolder {
        TextView titleTv;
        TextView arrayListItemTv;
        ProgressBar itemArrayPb;
        TextView linkedListItemTV;
        ProgressBar itemLinkedPb;
        TextView copyItemTV;
        ProgressBar itemCopyPb;


        public CollectionsViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTv = itemView.findViewById(R.id.tv_title);
            arrayListItemTv = itemView.findViewById(R.id.tv_item_Array);
            itemArrayPb = itemView.findViewById(R.id.pb_array);
            linkedListItemTV = itemView.findViewById(R.id.tv_item_linked);
            itemLinkedPb = itemView.findViewById(R.id.pb_linked);
            copyItemTV = itemView.findViewById(R.id.tv_item_copyOn);
            itemCopyPb = itemView.findViewById(R.id.pb_copy);
        }
    }
}
