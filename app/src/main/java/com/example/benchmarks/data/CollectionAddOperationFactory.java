package com.example.benchmarks.data;

import com.example.benchmarks.domain.operation.Operation;
import com.example.benchmarks.domain.operation.OperationType;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CollectionAddOperationFactory {
    public ArrayList<Operation> getOperations(List<Integer> list) {
        ArrayList<Operation> operationArrayList = new ArrayList<>();
        List<Integer> arrayList = new ArrayList<>(list);
        List<Integer> linkedList = new LinkedList<>(list);
        List<Integer> copyOnWriteArrayList = new CopyOnWriteArrayList<>(list);

        operationArrayList.add(new Operation(arrayList, OperationType.ADD_START));
        operationArrayList.add(new Operation(linkedList, OperationType.ADD_START));
        operationArrayList.add(new Operation(copyOnWriteArrayList, OperationType.ADD_START));
        operationArrayList.add(new Operation(arrayList, OperationType.ADD_MIDDLE));
        operationArrayList.add(new Operation(linkedList, OperationType.ADD_MIDDLE));
        operationArrayList.add(new Operation(copyOnWriteArrayList, OperationType.ADD_MIDDLE));
        operationArrayList.add(new Operation(arrayList, OperationType.ADD_END));
        operationArrayList.add(new Operation(linkedList, OperationType.ADD_END));
        operationArrayList.add(new Operation(copyOnWriteArrayList, OperationType.ADD_END));

        return operationArrayList;
    }
}