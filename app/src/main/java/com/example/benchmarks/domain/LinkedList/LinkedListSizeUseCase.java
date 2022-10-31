package com.example.benchmarks.domain.LinkedList;

import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;

public class LinkedListSizeUseCase {
    static final Integer DATA = 0;
    static LinkedList<Integer> numbers;
    private Integer num;

    public LinkedListSizeUseCase(int num) {
        this.num = num;
    }

    public @NonNull Observable<LinkedList<Integer>> linkedListSize = Observable.defer(() -> {
        LinkedList<Integer> fillNumbers = new LinkedList<Integer>(Collections.singleton(num));
        for (int i = 1; i < num ; i++) {
            fillNumbers.add(DATA);
        }
        numbers = fillNumbers;
        return Observable.just(numbers);
    });

//    public LinkedListSizeUseCase(int num) {
//        LinkedList<Integer> fillNumbers = new LinkedList<Integer>(Collections.singleton(num));
//        for (int i = 1; i < num ; i++) {
//            fillNumbers.add(DATA);
//        }
//        numbers = fillNumbers;
//    }
}
