package com.example.benchmarks.domain;

import java.util.ArrayList;

public class GetArrayListData {
    private static final Integer DATA = 0;
    private static final Integer SEACHBYVALUE = 1;
    static ArrayList<Integer> numbers;

    public GetArrayListData(int num) {
        ArrayList<Integer> fillNumbers = new ArrayList<Integer>(num);
        for (int i = 0; i <num; i++) {
            fillNumbers.add(DATA);
        }
        numbers = fillNumbers;
    }

    public static double AddingBegin() {
        ArrayList<Integer> numbersCopy = numbers;
        long startTime = System.currentTimeMillis();
        numbersCopy.add(0, DATA);
        return (double) System.currentTimeMillis() - startTime;
    }

    public static double AddingMiddle() {
        ArrayList<Integer> numbersCopy = numbers;
        long startTime = System.currentTimeMillis();
        numbersCopy.add(numbersCopy.size() / 2, DATA);
        return (double) System.currentTimeMillis() - startTime;
    }

    public static double AddingEnd() {
        ArrayList<Integer> numbersCopy = numbers;
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
        ArrayList<Integer> numbersCopy = numbers;
        long startTime = System.currentTimeMillis();
        numbersCopy.remove(0);
        return (double) System.currentTimeMillis() - startTime;
    }

    public static double RemoveMiddle() {
        ArrayList<Integer> numbersCopy = numbers;
        long startTime = System.currentTimeMillis();
        numbersCopy.remove(numbersCopy.size() / 2);
        return (double) System.currentTimeMillis() - startTime;
    }

    public static double RemoveEnd() {
        ArrayList<Integer> numbersCopy = numbers;
        long startTime = System.currentTimeMillis();
        numbersCopy.remove(numbers.size() - 1);
        return (double) System.currentTimeMillis() - startTime;
    }
}

