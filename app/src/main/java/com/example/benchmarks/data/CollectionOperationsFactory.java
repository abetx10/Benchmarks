package com.example.benchmarks.data;

import com.example.benchmarks.domain.operation.Operation;
import java.util.ArrayList;
import java.util.List;

public class CollectionOperationsFactory {

    CollectionAddOperationFactory collectionAddOperationFactory = new CollectionAddOperationFactory();
    CollectionRemoveOperationFactory collectionRemoveOperationFactory = new CollectionRemoveOperationFactory();
    CollectionSearchOperationFactory collectionSearchOperationFactory = new CollectionSearchOperationFactory();

    public ArrayList<Operation> getOperations(List<Integer> list){
        ArrayList<Operation> arrayList = new ArrayList<>();
        arrayList.addAll(collectionAddOperationFactory.getOperations(list));
        arrayList.addAll(collectionRemoveOperationFactory.getOperations(list));
        arrayList.addAll(collectionSearchOperationFactory.getOperations(list));
        return arrayList;
    }
}