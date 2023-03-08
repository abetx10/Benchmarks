package com.example.benchmarks.data;

import java.util.HashMap;
import java.util.Map;

public class FillMapsFactory {
    private static final String VALUE = "default";
    private Integer num;

    public FillMapsFactory(Integer num) {
        this.num = num;
    }

    public static Map<Integer, String> getFilledMap(int num) {
        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < num; i++) {
            map.put(i, VALUE);
        }
        return map;
    }
}