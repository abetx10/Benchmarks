package com.example.benchmarks.domain.models;

public class OperationItem {
    public String time = "N/A";
    public String statusReady = "ready";
    public String title;

    public OperationItem(String titleId) {
        this.title = titleId;
    }

    public String getTitle() {
        return title;
    }
}
