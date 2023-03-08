package com.example.benchmarks.domain.operation;

import android.util.Log;

import java.util.LinkedList;
import java.util.List;

import io.reactivex.rxjava3.core.Observable;

public class Operation {
    private static final Integer ELEMENT = 0;
    private List<Integer> list;
    private OperationType operationType;

    public Operation(List<Integer> list, OperationType operationType) {
        this.list = list;
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
        Log.d("Operation", "Executing operation on thread " + Thread.currentThread().getName());
        switch (operationType) {
            case ADD_START:
                if (list instanceof LinkedList) {
                    ((LinkedList) list).addFirst(ELEMENT);
                } else {
                    list.add(0, ELEMENT);
                }
                break;
            case ADD_MIDDLE:
                list.add(list.size() / 2, ELEMENT);
                break;
            case ADD_END:
                if (list instanceof LinkedList) {
                    ((LinkedList) list).addLast(ELEMENT);
                } else {
                    list.add(ELEMENT);
                }
                break;
            case REMOVE_START:
                if (list instanceof LinkedList) {
                    ((LinkedList) list).removeFirst();
                } else {
                    list.remove(0);
                }
                break;
            case REMOVE_MIDDLE:
                list.remove(list.size() / 2);
                break;
            case REMOVE_END:
                if (list instanceof LinkedList) {
                    ((LinkedList) list).removeLast();
                } else {
                    list.remove(list.size() - 1);
                }
                break;
            case SEARCH:
                list.contains(ELEMENT);
                break;
        }
    }
}

//    ok no rx
//    public int executeAndReturnUptime() {
//        long startTime = System.currentTimeMillis();
//        execute();
//        return Math.toIntExact(System.currentTimeMillis() - startTime);
//    }