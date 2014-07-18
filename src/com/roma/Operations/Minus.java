package com.roma.Operations;

import com.roma.Operation;
import com.roma.Result;

public class Minus extends Operation {
    int priority = 2;

    @Override
    public double calculate(Result res1, Result res2) {
        return res1.getNumber() - res2.getNumber();
    }

    @Override
    public int getPriority() {
        return priority;
    }
}
