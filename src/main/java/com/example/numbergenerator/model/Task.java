package com.example.numbergenerator.model;

import java.util.List;

public class Task {

    private Status status;

    private List<String> numberSequences;

    public Task() {
        status = Status.IN_PROGRESS;
    }

    public List<String> getNumberSequences() {
        return numberSequences;
    }

    public void setNumberSequences(List<String> numberSequences) {
        this.numberSequences = numberSequences;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Task{" +
                ", status=" + status +
                ", numberSequences=" + numberSequences +
                '}';
    }
}
