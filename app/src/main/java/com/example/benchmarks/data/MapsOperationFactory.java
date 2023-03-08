package com.example.benchmarks.data;

import com.example.benchmarks.domain.operation.OperationMaps;
import com.example.benchmarks.domain.operation.OperationTypeMaps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapsOperationFactory {
    public ArrayList<OperationMaps> getOperations(Map<Integer, String> maps) {
        ArrayList<OperationMaps> operationArrayList = new ArrayList<>();
        Map<Integer, String> hashMap = new HashMap<>(maps);
        Map<Integer, String> treeMap = new TreeMap<>(maps);

        operationArrayList.add(new OperationMaps(hashMap, OperationTypeMaps.ADD_NEW));
        operationArrayList.add(new OperationMaps(treeMap, OperationTypeMaps.ADD_NEW));
        operationArrayList.add(new OperationMaps(hashMap, OperationTypeMaps.SEARCH));
        operationArrayList.add(new OperationMaps(treeMap, OperationTypeMaps.SEARCH));
        operationArrayList.add(new OperationMaps(hashMap, OperationTypeMaps.REMOVE));
        operationArrayList.add(new OperationMaps(treeMap, OperationTypeMaps.REMOVE));

        return operationArrayList;
    }
}