package com.example.benchmarks.data;
import java.util.ArrayList;
import java.util.List;

public class FillListFactory {

    private static final Integer DATA = 0;
    private Integer num;

    public FillListFactory(int num) {
        this.num = num;
    }

    public static List<Integer> getFilledList(int num) {
        List<Integer> filledList = new ArrayList<Integer>(num);
        for (int i = 0; i < num; i++) {
            filledList.add(DATA);
        }
        return filledList;
    }
}