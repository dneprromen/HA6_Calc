package com.roma;

import com.roma.Operations.Divide;
import com.roma.Operations.Minus;
import com.roma.Operations.Multy;
import com.roma.Operations.Plus;

public class TypesFactory {

    public Result getType(String numberOrOperation) {
        try {
            return new Number(Double.parseDouble(numberOrOperation));
        } catch (NumberFormatException e) {
            return getOperationClass(numberOrOperation);
        }
    }

    public Result getOperationClass(String operation) {
        if (operation.equals("+")) {
            return new Plus();
        } else if (operation.equals("-")) {
            return new Minus();
        } else if (operation.equals("*")) {
            return new Multy();
        } else if (operation.equals("/")) {
            return new Divide();
        } else {
            throw new UnsupportedOperationException("Unsaported operation \"" + operation + "\"");
        }
    }
}
