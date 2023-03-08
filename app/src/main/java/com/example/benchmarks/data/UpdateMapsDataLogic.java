package com.example.benchmarks.data;

import com.example.benchmarks.domain.models.OperationStatus;
import com.example.benchmarks.domain.operation.OperationMaps;
import com.example.benchmarks.presentation.MapsViewModel;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class UpdateMapsDataLogic {
    public void updateData(MapsViewModel mapsViewModel, Integer num, boolean stopRequested) {
        Observable.fromCallable(() -> new MapsOperationFactory().getOperations(FillMapsFactory.getFilledMap(num)))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(operations -> {
                    for (int i = 0; i < mapsViewModel.updateOperationItemsList.size(); i++) {
                        OperationMaps operation = operations.get(i);
                        int finalI = i;
                        operation.executeAndReturnUptime()
                                .subscribeOn(Schedulers.computation())
                                .observeOn(AndroidSchedulers.mainThread())
                                .subscribe(time -> {
                                    mapsViewModel.updateOperationItemsList.get(finalI).time = String.valueOf(time);
                                    mapsViewModel.updateOperationItemsList.get(finalI).statusReady = OperationStatus.READY;
                                    if (!stopRequested) {
                                        mapsViewModel.updateListCallback.onUpdateList(mapsViewModel.updateOperationItemsList);
                                    }
                                });
                    }
                });
    }
}