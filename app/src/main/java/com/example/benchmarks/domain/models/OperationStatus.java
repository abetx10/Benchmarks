package com.example.benchmarks.domain.models;

public enum OperationStatus {
    READY(true),
    NOT_READY(false);

    private boolean status;

    OperationStatus(boolean status) {
        this.status = status;
    }
}