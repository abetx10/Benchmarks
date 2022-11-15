package com.example.benchmarks.domain.position;

import java.util.Collection;

public class EndPosition implements Position{

    @Override
    public Integer getPosition(Collection num) {
        return num.size() -1;
    }
}
