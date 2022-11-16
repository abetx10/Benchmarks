package com.example.benchmarks.domain.position;

import java.util.Collection;

public class StartPosition implements Position{

    @Override
    public Integer getPosition(Collection num) {
        return 0;
    }
}
