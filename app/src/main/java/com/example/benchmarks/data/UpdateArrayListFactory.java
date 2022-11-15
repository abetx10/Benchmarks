package com.example.benchmarks.data;

import android.util.Log;

import com.example.benchmarks.domain.collection.CustomArrayList;
import com.example.benchmarks.domain.operation.AddClass;
import com.example.benchmarks.domain.operation.Operation;
//import com.example.benchmarks.domain.operation.RemoveClass;
import com.example.benchmarks.domain.operation.SearchClass;
import com.example.benchmarks.domain.position.EndPosition;
import com.example.benchmarks.domain.position.MiddlePosition;
import com.example.benchmarks.domain.position.StartPosition;

import java.util.ArrayList;
import java.util.Arrays;

public class UpdateArrayListFactory {
    public static String START_STATE = "";

        public ArrayList<Operation> getArraylist() {
            final ArrayList<Operation> arrayList = new ArrayList<>();


            arrayList.add(new AddClass(new CustomArrayList(), new StartPosition()));
//            arrayList.add(new AddClass<MiddlePosition, CustomArrayList>(START_STATE));
//            arrayList.add(new AddClass<EndPosition, CustomArrayList>(START_STATE));
//            arrayList.add(new SearchClass<>(START_STATE));
//            arrayList.add(new RemoveClass<StartPosition, CustomArrayList>(START_STATE));
//            arrayList.add(new RemoveClass<MiddlePosition, CustomArrayList>(START_STATE));
//            arrayList.add(new RemoveClass<EndPosition, CustomArrayList>(START_STATE));

            return arrayList;
        }
}
