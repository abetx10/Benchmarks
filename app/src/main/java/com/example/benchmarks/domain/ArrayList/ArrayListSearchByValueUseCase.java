package com.example.benchmarks.domain.ArrayList;

import static com.example.benchmarks.domain.ArrayList.ArrayListSizeUseCase.numbers;
import java.util.ArrayList;
import io.reactivex.rxjava3.core.Observable;

public class ArrayListSearchByValueUseCase {
    private static final Integer SEACHBYVALUE = 1;

    public Observable<Integer> searchByValue = (Observable<Integer>) Observable.defer(() -> {
        ArrayList<Integer> numbersCopy = numbers;
        long startTime = System.currentTimeMillis();
        numbers.contains(SEACHBYVALUE);
        return Observable.just(Math.toIntExact(System.currentTimeMillis() - startTime));
    });
}
