package com.roma;

public abstract class Operation extends Result {
    private Result res1;
    private Result res2;
    private boolean readiness = false;

    public double getNumber() {
        return calculate(res1, res2);
    }

    public abstract double calculate(Result res1, Result res2);

    public void setNumber1(Result number1) {
        this.res1 = number1;
        if(res2 != null){
            readiness = true;
        }
    }

    public void setNumber2(Result number2) {
        this.res2 = number2;
        if(res1 != null){
            readiness = true;
        }
    }

    public boolean isOperation() {
        return true;
    }

    public boolean isReady() {
        return readiness;
    }

    abstract public int getPriority();
}
