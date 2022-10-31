package com.example.benchmarks.domain.LinkedList;

import java.util.LinkedList;

import io.reactivex.rxjava3.core.Observable;

public class LinkedListAddingBeginUseCase {

    public Observable<Integer> addingBegin = (Observable<Integer>) Observable.defer(() -> {
        LinkedList<Integer> numbersCopy = LinkedListSizeUseCase.numbers;
        long startTime = System.currentTimeMillis();
        numbersCopy.add(0, LinkedListSizeUseCase.DATA);
        return Observable.just(Math.toIntExact(System.currentTimeMillis() - startTime));
    });
}
