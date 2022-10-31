package com.example.benchmarks.domain.ArrayList;

import static com.example.benchmarks.domain.ArrayList.ArrayListSizeUseCase.numbers;
import java.util.ArrayList;
import io.reactivex.rxjava3.core.Observable;

public class ArrayListRemoveMiddleUseCase {
    public Observable<Integer> removeMiddle = (Observable<Integer>) Observable.defer(() -> {
        ArrayList<Integer> numbersCopy = numbers;
        long startTime = System.currentTimeMillis();
        numbersCopy.remove(numbersCopy.size() / 2);
        return Observable.just(Math.toIntExact(System.currentTimeMillis() - startTime));
    });
}
