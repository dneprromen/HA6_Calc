package com.roma;

public class Number extends Result {
    double number;

    @Override
    public boolean isOperation() {
        return false;
    }

    @Override
    public boolean isReady() {
        return true;
    }

    @Override
    public int getPriority() {
        return 0;
    }

    @Override
    public double getNumber() {
        return number;
    }

    public Number(Double number) {
        this.number = number;
    }
}
