package com.example.benchmarks.domain.CopyOnWriteArrayList;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;

public class CopyOnWriteArrayListSizeUseCase {
    static final Integer DATA = 0;
    static CopyOnWriteArrayList <Integer> numbers;
    private Integer num;

    public CopyOnWriteArrayListSizeUseCase(int num) {
        this.num = num;
    }

    public @NonNull Observable<CopyOnWriteArrayList<Integer>> copyListSize = Observable.defer(() -> {
        ArrayList<Integer> fillNumbers = new ArrayList<Integer>(num);
        for (int i = 1; i < num ; i++) {
            fillNumbers.add(DATA);
        }
        numbers = new CopyOnWriteArrayList<>(fillNumbers);
        return Observable.just(numbers);
    });
}
