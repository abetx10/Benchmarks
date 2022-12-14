package com.example.benchmarks.domain.ArrayList;

import static com.example.benchmarks.domain.ArrayList.ArrayListSizeUseCase.DATA;
import static com.example.benchmarks.domain.ArrayList.ArrayListSizeUseCase.numbers;


import com.example.benchmarks.domain.collection.CustomCollection;
import com.example.benchmarks.domain.operation.AddClass;
import com.example.benchmarks.domain.position.StartPosition;

import java.util.ArrayList;
import io.reactivex.rxjava3.core.Observable;

public class ArrayListAddingBeginUseCase<CustomArrayList extends CustomCollection> {

        public Observable <Integer> addingBegin = (Observable<Integer>) Observable.defer(() -> {
        ArrayList<Integer> numbersCopy = numbers;
        long startTime = System.currentTimeMillis();
        numbersCopy.add(0, DATA);
        return Observable.just(Math.toIntExact(System.currentTimeMillis() - startTime));
    });

//        AddClass<StartPosition, CustomArrayList> arrayListAddClass = new AddClass<>("");
}