package com.example.benchmarks.presentation;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.benchmarks.R;
import com.example.benchmarks.data.OperationItemsFactory;
import com.example.benchmarks.data.UpdateMapsDataLogic;
import com.example.benchmarks.domain.models.OperationItem;
import com.example.benchmarks.domain.models.OperationStatus;
import com.example.benchmarks.presentation.callbacks.UpdateListCallback;

import java.util.ArrayList;

import javax.inject.Inject;

public class MapsViewModel extends AndroidViewModel {
    public ArrayList<OperationItem> operationItemsList = new ArrayList<>();
    OperationItemsFactory operationItemsFactory = new OperationItemsFactory();
    public ArrayList<OperationItem> updateOperationItemsList = new ArrayList<>();
    public UpdateListCallback updateListCallback;
    UpdateMapsDataLogic updateMapsDataLogic;

    public void setUpdateListCallback(UpdateListCallback updateListCallback) {
        this.updateListCallback = updateListCallback;
    }

    @Inject
    public MapsViewModel(@NonNull Application application, UpdateMapsDataLogic updateMapsDataLogic) {
        super(application);
        this.updateMapsDataLogic = updateMapsDataLogic;
    }

    public void getOperationItemList() {
        operationItemsList.addAll(operationItemsFactory.getTitleData(getApplication().getResources().getStringArray(R.array.maps_operation_titles)));
    }

    public void startProgressBar() {
        ArrayList<OperationItem> updatedList = new ArrayList<>();
        for (int i = 0; i < operationItemsList.size(); i++) {
            OperationItem operationItem = operationItemsList.get(i);
            updatedList.add(new OperationItem(operationItem.getTitle()));
            updatedList.get(i).statusReady = OperationStatus.NOT_READY;
        }
        updateOperationItemsList.addAll(updatedList);

    }

    public void updateData(Integer num, boolean stopRequested) {
        updateMapsDataLogic.updateData(this, num, stopRequested);
    }
}