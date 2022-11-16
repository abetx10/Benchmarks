package com.example.benchmarks.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class GetLinkedListData {
    private static final Integer DATA = 0;
    private static final Integer SEACHBYVALUE = 1;
    static LinkedList<Integer> numbers;

    public GetLinkedListData(int num) {
        LinkedList<Integer> fillNumbers = new LinkedList<Integer>(Collections.singleton(num));
        for (int i = 1; i < num ; i++) {
            fillNumbers.add(DATA);
        }
        numbers = fillNumbers;
    }

        public static double AddingBegin() {
        LinkedList<Integer> numbersCopy = numbers;
        long startTime = System.currentTimeMillis();
        numbersCopy.add(0, DATA);
        return (double) System.currentTimeMillis() - startTime;
    }

    public static double AddingMiddle() {
        LinkedList<Integer> numbersCopy = numbers;
        long startTime = System.currentTimeMillis();
        numbersCopy.add(numbersCopy.size() / 2, DATA);
        return (double) System.currentTimeMillis() - startTime;
    }

    public static double AddingEnd() {
        LinkedList<Integer> numbersCopy = numbers;
        long startTime = System.currentTimeMillis();
        numbersCopy.add(numbersCopy.size(), DATA);
        return (double) System.currentTimeMillis() - startTime;
    }

    public static double SearchByValue() {
        long startTime = System.currentTimeMillis();
        numbers.contains(SEACHBYVALUE);
        return (double) System.currentTimeMillis() - startTime;
    }

    public static double RemoveBegin() {
        LinkedList<Integer> numbersCopy = numbers;
        long startTime = System.currentTimeMillis();
        numbersCopy.remove(0);
        return (double) System.currentTimeMillis() - startTime;
    }

    public static double RemoveMiddle() {
        LinkedList<Integer> numbersCopy = numbers;
        long startTime = System.currentTimeMillis();
        numbersCopy.remove(numbersCopy.size() / 2);
        return (double) System.currentTimeMillis() - startTime;
    }

    public static double RemoveEnd() {
        LinkedList<Integer> numbersCopy = numbers;
        long startTime = System.currentTimeMillis();
        numbersCopy.remove(numbers.size() - 1);
        return (double) System.currentTimeMillis() - startTime;
    }
}