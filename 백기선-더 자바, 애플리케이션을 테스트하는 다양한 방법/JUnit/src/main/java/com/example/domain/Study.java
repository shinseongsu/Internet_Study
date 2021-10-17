package com.example.domain;

public class Study {

    private StudyStatus studyStatus;
    private int limit;

    public Study() { }

    public Study(int limit){
        if(limit < 0) throw new IllegalArgumentException("limit은 0보다 커야한다.");
        this.limit = limit;
    }

    public StudyStatus getStatus() {
        return this.studyStatus;
    }

    public int getLimit() {
        return limit;
    }

}
