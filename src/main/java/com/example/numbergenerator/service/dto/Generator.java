package com.example.numbergenerator.service.dto;

public class Generator {
    private int goal, step;

    public int getGoal() {
        return goal;
    }

    public void setGoal(int goal) {
        this.goal = goal;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    @Override
    public String toString() {
        return "TaskDto{" +
                "goal=" + goal +
                ", step=" + step +
                '}';
    }
}
