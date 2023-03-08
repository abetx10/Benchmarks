package com.example.benchmarks.data;

import java.util.Collections;
import java.util.List;

public class FillListFactory {

    private static final Integer DATA = 0;
    private Integer num;

    public FillListFactory(int num) {
        this.num = num;
    }

    public static List<Integer> getFilledList(int num) {
        return Collections.nCopies(num, DATA);
    }
}