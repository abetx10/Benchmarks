package com.example.benchmarks.domain.operation;

import java.util.Map;

import io.reactivex.rxjava3.core.Observable;

public class OperationMaps {
    private static final Integer KEY = 100000;
    private static final String VALUE = "default";
    private Map<Integer, String> map;
    private OperationTypeMaps operationType;

    public OperationMaps(Map<Integer, String> map, OperationTypeMaps operationType) {
        this.map = map;
        this.operationType = operationType;
    }

    public Observable<Integer> executeAndReturnUptime() {
        long startTime = System.currentTimeMillis();
        return (Observable<Integer>) Observable.defer(() -> {
            execute();
            return Observable.just(Math.toIntExact(System.currentTimeMillis() - startTime));
        });
    }

    public void execute() {
        switch (operationType) {
            case ADD_NEW:
                map.put(KEY, VALUE);
                break;
            case SEARCH:
                map.get(KEY);
                break;
            case REMOVE:
                map.remove(KEY);
                break;
        }
    }
}