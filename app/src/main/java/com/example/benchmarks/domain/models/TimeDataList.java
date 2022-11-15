package com.example.benchmarks.domain.models;

public class TimeDataList {
    public String timeArrayList;
    public String stateArrayList;
    public String timeLinkedList;
    public String stateLinkedList;
    public String timeCopyList;
    public String stateCopyList;

    public TimeDataList(String timeArrayList, String stateArrayList, String timeLinkedList, String stateLinkedList, String timeCopyList, String stateCopyList) {
        this.timeArrayList = timeArrayList;
        this.stateArrayList = stateArrayList;
        this.timeLinkedList = timeLinkedList;
        this.stateLinkedList = stateLinkedList;
        this.timeCopyList = timeCopyList;
        this.stateCopyList = stateCopyList;
    }
}
