package com.example.benchmarks.domain.ArrayList;

import static com.example.benchmarks.domain.ArrayList.ArrayListSizeUseCase.DATA;
import static com.example.benchmarks.domain.ArrayList.ArrayListSizeUseCase.numbers;
import java.util.ArrayList;
import io.reactivex.rxjava3.core.Observable;

public class ArrayListAddingMiddleUseCase {
    public Observable<Integer> addingMiddle = (Observable<Integer>) Observable.defer(() -> {
        ArrayList<Integer> numbersCopy = numbers;
        long startTime = System.currentTimeMillis();
        numbersCopy.add(numbersCopy.size() / 2, DATA);
        return Observable.just(Math.toIntExact(System.currentTimeMillis() - startTime));
    });
}
