package com.example.benchmarks.presentation;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.benchmarks.R;
import com.example.benchmarks.data.OperationItemsFactory;
import com.example.benchmarks.data.UpdateDataLogic;
import com.example.benchmarks.domain.models.OperationItem;
import com.example.benchmarks.domain.models.OperationStatus;
import com.example.benchmarks.presentation.callbacks.UpdateListCallback;

import java.util.ArrayList;

import javax.inject.Inject;

public class CollectionsViewModel extends AndroidViewModel {

    OperationItemsFactory operationItemsFactory = new OperationItemsFactory();
    public ArrayList<OperationItem> operationItemsList = new ArrayList<>();
    public ArrayList<OperationItem> updateOperationItemsList = new ArrayList<>();
    public UpdateListCallback updateListCallback;
    private UpdateDataLogic updateDataLogic;

    public void setUpdateListCallback(UpdateListCallback updateListCallback) {
        this.updateListCallback = updateListCallback;
    }

//    public CollectionsViewModel(@NonNull Application application) {
//        super(application);
//    }

    @Inject
    public CollectionsViewModel(@NonNull Application application, UpdateDataLogic updateDataLogic) {
        super(application);
        this.updateDataLogic = updateDataLogic;
    }

    public void getOperationItemList() {
        operationItemsList.addAll(operationItemsFactory.getTitleData(getApplication().getResources().getStringArray(R.array.collection_operation_titles)));
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

    public void updateData(Integer num) {
        updateDataLogic.updateData(this, num);
    }
}

//    public void updateData(Integer num) {
//        Observable.fromCallable(() -> new CollectionOperationsFactory().getOperations(FillListFactory.getFilledList(num)))
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(operations -> {
//                    for (int i = 0; i < updateOperationItemsList.size(); i++) {
//                        Operation operation = operations.get(i);
//                        int finalI = i;
//                        operation.executeAndReturnUptime()
//                                .subscribeOn(Schedulers.computation())
//                                .observeOn(AndroidSchedulers.mainThread())
//                                .subscribe(time -> {
//                                    updateOperationItemsList.get(finalI).time = String.valueOf(time);
//                                    updateOperationItemsList.get(finalI).statusReady = OperationStatus.READY;
//                                    updateListCallback.onUpdateList(updateOperationItemsList);
//                                    Log.d("updateO", "Index: " + finalI + " Value: " + updateOperationItemsList.get(finalI) + "Executing operation on thread " + Thread.currentThread().getName());
//                                    Log.d("updateO", "Index: " + finalI + " Value: " + updateOperationItemsList.get(finalI).statusReady);
//                                    Log.d("updateO", "Index: " + finalI + " Value: " + updateOperationItemsList.get(finalI).time);
//                                });
//                    }
//                });
//    }


//    private void updateListOnMainThread(ArrayList<OperationItem> updateOperationItemsList) {
//        Handler mainHandler = new Handler(Looper.getMainLooper());
//        Runnable myRunnable = () -> updateListCallback.onUpdateList(updateOperationItemsList);
//        mainHandler.post(myRunnable);
//    }

//    public void updateData(Integer num) {
//        Observable.fromCallable(() -> new CollectionOperationsFactory().getOperations(FillListFactory.getFilledList(num)))
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(operations -> {
//                    for (int i = 0; i < updateOperationItemsList.size(); i++) {
//                        Operation operation = operations.get(i);
//                        int finalI = i;
//                        operation.executeAndReturnUptime()
//                                .subscribeOn(Schedulers.computation())
//                                .observeOn(AndroidSchedulers.mainThread())
//                                .doOnNext(time -> {
//                                    updateOperationItem(finalI, String.valueOf(time), getApplication().getString(R.string.state_ready));
//                                })
//                                .subscribe(time -> {
//                                    synchronized (this) {
//                                        updateListCallback.onUpdateList(updateOperationItemsList);
//                                    }
//                                });
//                    }
//                });
//    }
//
//    private synchronized void updateOperationItem(int index, String time, String status) {
//        updateOperationItemsList.get(index).time = time;
//        updateOperationItemsList.get(index).statusReady = status;
//    }
//}

//    public void updateData(Integer num) {
//        Observable.fromCallable(() -> new CollectionOperationsFactory().getOperations(FillListFactory.getFilledList(num)))
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(operations -> {
//                    for (int i = 0; i < updateOperationItemsList.size(); i++) {
//                        Operation operation = operations.get(i);
//                        int finalI = i;
//                        operation.executeAndReturnUptime()
//                                .subscribeOn(Schedulers.computation())
//                                .observeOn(Schedulers.io()) // переключаем на фоновый поток
//                                .subscribe(time -> {
//                                    // выполняем обновление в фоновом потоке
//                                    updateOperationItemsList.get(finalI).time = String.valueOf(time);
//                                    updateOperationItemsList.get(finalI).statusReady = getApplication().getString(R.string.state_ready);
//                                    Log.d("updateO", "Index: " + finalI + " Value: " + updateOperationItemsList.get(finalI) + "Executing operation on thread " + Thread.currentThread().getName());
//
//                                    // переключаемся на главный поток для обновления UI-элементов
//                                    Observable.just(updateOperationItemsList)
//                                            .observeOn(AndroidSchedulers.mainThread())
//                                            .subscribe(list -> updateListCallback.onUpdateList(list));
//                                });
//                    }
//                });
//    }
//}

// ok no rx
//    public void updateData(Integer num) {
//        List<Operation> operations = new CollectionOperationsFactory().getOperations(FillListFactory.getFilledList(num));
//        for (int i = 0; i < updateOperationItemsList.size(); i++) {
//            Operation operation = operations.get(i);
//            int time = operation.executeAndReturnUptime();
//            updateOperationItemsList.get(i).time = String.valueOf(time);
//            updateOperationItemsList.get(i).statusReady = getApplication().getString(R.string.state_ready);
//            if (updateListCallback != null) {
//                updateListCallback.onUpdateList(updateOperationItemsList);
//            }
//        }
//    }