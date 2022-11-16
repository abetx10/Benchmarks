package com.example.benchmarks.presentation;

import android.app.Application;
import android.content.res.Resources;
import android.content.res.loader.ResourcesProvider;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.benchmarks.R;
//import com.example.benchmarks.data.OperationsFactory;
import com.example.benchmarks.data.UpdateArrayListFactory;
import com.example.benchmarks.domain.models.TimeDataList;
import com.example.benchmarks.domain.models.TitleData;
import com.example.benchmarks.domain.operation.Operation;

import java.util.ArrayList;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.schedulers.Schedulers;


public class CollectionsTableViewModel extends AndroidViewModel {
    public MutableLiveData<ArrayList<Operation>> operationArrayList = new MutableLiveData<>();
    public MutableLiveData<Integer> itemChangedPosition = new MutableLiveData<>();

    public MutableLiveData<ArrayList<Operation>> arrayListData = new MutableLiveData<>();
    UpdateArrayListFactory updateArrayListFactory = new UpdateArrayListFactory();

    public ArrayList<TitleData> titleDataArrayList;
//    public ArrayList<TimeDataList> timeDataList;

//    OperationsFactory operationsFactory = new OperationsFactory();

    public CollectionsTableViewModel(@NonNull Application application) {
        super(application);
    }



    public void dataInitialize() {
        arrayListData.postValue(updateArrayListFactory.getArraylist());

        arrayListData.getValue().get(0).time = 1;
//        arrayListData.getValue().get(0).state = getApplication().getString(R.string.state_ready);

    }

//    public void updateProgressBar() {
//        arrayListData.getValue().get(0).state = getApplication().getString(R.string.state_progress);
//    }

    public void titleInitialize() {
//        operationArrayList.postValue(operationsFactory.getOperations());
        titleDataArrayList = new ArrayList<>();
        String[] titleData = new String[] {
                getApplication().getString(R.string.title_1),
                getApplication().getString(R.string.title_2),
                getApplication().getString(R.string.title_3),
                getApplication().getString(R.string.title_4),
                getApplication().getString(R.string.title_5),
                getApplication().getString(R.string.title_6),
                getApplication().getString(R.string.title_7)
        };

        for (int i = 0; i < titleData.length; i++) {
            TitleData title = new TitleData(titleData[i]);
            titleDataArrayList.add(title);
        }
    }
//
//    public void dataInitialize() {
//        timeDataList = new ArrayList<>();
//        String[] timeDataArray = new String[]{
//                getApplication().getString(R.string.startArrayListData),
//                getApplication().getString(R.string.startArrayListData),
//                getApplication().getString(R.string.startArrayListData),
//                getApplication().getString(R.string.startArrayListData),
//                getApplication().getString(R.string.startArrayListData),
//                getApplication().getString(R.string.startArrayListData),
//                getApplication().getString(R.string.startArrayListData),
//        };
//
//        String[] stateArray = new String[] {
//                getApplication().getString(R.string.state_ready),
//                getApplication().getString(R.string.state_ready),
//                getApplication().getString(R.string.state_ready),
//                getApplication().getString(R.string.state_ready),
//                getApplication().getString(R.string.state_ready),
//                getApplication().getString(R.string.state_ready),
//                getApplication().getString(R.string.state_ready),
//        };
//
//        String[] timeDataLinked = new String[]{
//                getApplication().getString(R.string.startArrayListData),
//                getApplication().getString(R.string.startArrayListData),
//                getApplication().getString(R.string.startArrayListData),
//                getApplication().getString(R.string.startArrayListData),
//                getApplication().getString(R.string.startArrayListData),
//                getApplication().getString(R.string.startArrayListData),
//                getApplication().getString(R.string.startArrayListData),
//        };
//
//        String[] stateLinked = new String[] {
//                getApplication().getString(R.string.state_ready),
//                getApplication().getString(R.string.state_ready),
//                getApplication().getString(R.string.state_ready),
//                getApplication().getString(R.string.state_ready),
//                getApplication().getString(R.string.state_ready),
//                getApplication().getString(R.string.state_ready),
//                getApplication().getString(R.string.state_ready),
//        };
//
//        String[] timeDataCopy = new String[]{
//                getApplication().getString(R.string.startArrayListData),
//                getApplication().getString(R.string.startArrayListData),
//                getApplication().getString(R.string.startArrayListData),
//                getApplication().getString(R.string.startArrayListData),
//                getApplication().getString(R.string.startArrayListData),
//                getApplication().getString(R.string.startArrayListData),
//                getApplication().getString(R.string.startArrayListData),
//        };
//
//        String[] stateCopy = new String[] {
//                getApplication().getString(R.string.state_ready),
//                getApplication().getString(R.string.state_ready),
//                getApplication().getString(R.string.state_ready),
//                getApplication().getString(R.string.state_ready),
//                getApplication().getString(R.string.state_ready),
//                getApplication().getString(R.string.state_ready),
//                getApplication().getString(R.string.state_ready),
//        };
//
//        for (int i = 0; i < timeDataArray.length; i++) {
//            TimeDataList timeDataList = new TimeDataList(
//                    timeDataArray[i], stateArray[i],
//                    timeDataLinked[i], stateLinked[i],
//                    timeDataCopy[i], stateCopy[i]
//            );
//            this.timeDataList.add(timeDataList);
//        }
//    }
//
//    public void updateProgressBar() {
//        for (int i = 0; i <  operationArrayList.getValue().size(); i++) {
//            int finalI = i;
//            operationArrayList.getValue().get(i).state = getApplication().getString(R.string.state_progress);
//            itemChangedPosition.postValue(finalI);
//
//            operationArrayList.getValue().get(i).executeAndReturnUptime()
//                    .subscribeOn(Schedulers.computation())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe( time -> {
//                    operationArrayList.getValue().get(finalI).time = (Integer) time;
//                    itemChangedPosition.postValue(finalI);
//                });
//
//        }
//        timeDataList.get(0).stateArrayList = getApplication().getString(R.string.state_progress);
//
//        timeDataList.get(1).stateArrayList = getApplication().getString(R.string.state_progress);
//
//        timeDataList.get(2).stateArrayList = getApplication().getString(R.string.state_progress);
//
//        timeDataList.get(3).stateArrayList = getApplication().getString(R.string.state_progress);
//
//        timeDataList.get(4).stateArrayList = getApplication().getString(R.string.state_progress);
//
//        timeDataList.get(5).stateArrayList = getApplication().getString(R.string.state_progress);
//
//        timeDataList.get(6).stateArrayList = getApplication().getString(R.string.state_progress);
//
//        timeDataList.get(0).stateLinkedList = getApplication().getString(R.string.state_progress);
//
//        timeDataList.get(1).stateLinkedList = getApplication().getString(R.string.state_progress);
//
//        timeDataList.get(2).stateLinkedList = getApplication().getString(R.string.state_progress);
//
//        timeDataList.get(3).stateLinkedList = getApplication().getString(R.string.state_progress);
//
//        timeDataList.get(4).stateLinkedList = getApplication().getString(R.string.state_progress);
//
//        timeDataList.get(5).stateLinkedList = getApplication().getString(R.string.state_progress);
//
//        timeDataList.get(6).stateLinkedList = getApplication().getString(R.string.state_progress);
//
//        timeDataList.get(0).stateCopyList = getApplication().getString(R.string.state_progress);
//
//        timeDataList.get(1).stateCopyList = getApplication().getString(R.string.state_progress);
//
//        timeDataList.get(2).stateCopyList = getApplication().getString(R.string.state_progress);
//
//        timeDataList.get(3).stateCopyList = getApplication().getString(R.string.state_progress);
//
//        timeDataList.get(4).stateCopyList = getApplication().getString(R.string.state_progress);
//
//        timeDataList.get(5).stateCopyList = getApplication().getString(R.string.state_progress);
//
//        timeDataList.get(6).stateCopyList = getApplication().getString(R.string.state_progress);
//    }
}




