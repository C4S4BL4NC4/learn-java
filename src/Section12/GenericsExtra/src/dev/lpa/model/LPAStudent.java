package dev.lpa.model;

import java.util.Random;

public class LPAStudent extends Student{
    private double percentComplete;

    public LPAStudent() {
        super();
        this.percentComplete = random.nextDouble(0, 100.001);
    }

    @Override
    public String toString() {
        return "%s %8.1f%%".formatted(super.toString(), percentComplete);
    }

    public double getPercentComplete() {
        return percentComplete;
    }
}

