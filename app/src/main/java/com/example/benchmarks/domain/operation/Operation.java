package com.example.benchmarks.domain.operation;

import com.example.benchmarks.domain.collection.CustomCollection;
import com.example.benchmarks.domain.position.Position;
import io.reactivex.rxjava3.core.Observable;

public abstract class Operation {
CustomCollection customCollection;
Position position;


    public Operation(CustomCollection customCollection, Position position) {
        this.customCollection = customCollection;
        this.position = position;
    }

    public Observable<Integer> executeAndReturnUptime() {
        long startTime = System.currentTimeMillis();
        return (Observable<Integer>) Observable.defer(() -> {
            execute();
            return Observable.just(Math.toIntExact(System.currentTimeMillis() - startTime));
        });
    }
    abstract void execute();
}


