package com.example.benchmarks.domain.collection;

import com.example.benchmarks.domain.position.Position;

import java.util.Collection;

public interface CustomCollection extends Collection<Integer> {
    public void add(Position position, Integer data);
}
