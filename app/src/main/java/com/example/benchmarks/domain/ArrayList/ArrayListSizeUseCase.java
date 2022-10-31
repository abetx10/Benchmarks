package com.example.benchmarks.domain.ArrayList;

import java.util.ArrayList;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;

public class ArrayListSizeUseCase {
    static final Integer DATA = 0;
    static ArrayList<Integer> numbers;
    private Integer num;

    public ArrayListSizeUseCase(int num) {
        this.num = num;
    }

    public @NonNull Observable<ArrayList<Integer>> arrayListSize = Observable.defer(() -> {
        ArrayList<Integer> fillNumbers = new ArrayList<Integer>(num);
        for (int i = 0; i < num; i++) {
            fillNumbers.add(DATA);
        }
        numbers = fillNumbers;
        return Observable.just(numbers);
    });

//    public ArrayListSize(int num) {
//        ArrayList<Integer> fillNumbers = new ArrayList<Integer>(num);
//        for (int i = 0; i <num; i++) {
//            fillNumbers.add(DATA);
//        }
//        numbers = fillNumbers;
//    }
}






