package com.example.benchmarks.domain.operation;

import com.example.benchmarks.domain.collection.CustomCollection;
import com.example.benchmarks.domain.position.Position;

public class AddClass extends Operation {
    public AddClass(CustomCollection customCollection, Position position) {
        super(customCollection, position);
    }

    @Override
    void execute() {
        customCollection.add(position, 1);
    }
}
