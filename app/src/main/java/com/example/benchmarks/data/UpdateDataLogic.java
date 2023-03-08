package com.example.benchmarks.data;

import com.example.benchmarks.domain.models.OperationStatus;
import com.example.benchmarks.domain.operation.Operation;
import com.example.benchmarks.presentation.CollectionsViewModel;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class UpdateDataLogic {
    public void updateData(CollectionsViewModel collectionsViewModel, Integer num, boolean stopRequested) {
        Observable.fromCallable(() -> new CollectionOperationsFactory().getOperations(FillListFactory.getFilledList(num)))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(operations -> {
                    for (int i = 0; i < collectionsViewModel.updateOperationItemsList.size(); i++) {
                        Operation operation = operations.get(i);
                        int finalI = i;
                        operation.executeAndReturnUptime()
                                .subscribeOn(Schedulers.computation())
                                .observeOn(AndroidSchedulers.mainThread())
                                .subscribe(time -> {
                                    collectionsViewModel.updateOperationItemsList.get(finalI).time = String.valueOf(time);
                                    collectionsViewModel.updateOperationItemsList.get(finalI).statusReady = OperationStatus.READY;
                                    if (!stopRequested) {
                                        collectionsViewModel.updateListCallback.onUpdateList(collectionsViewModel.updateOperationItemsList);
                                    }
                                });
                    }
                });
    }
}