package com.roma;

public abstract class Result {
    public abstract double getNumber();
    public abstract boolean isOperation();
    public abstract boolean isReady();
    public abstract int getPriority();
}
