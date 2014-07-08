package com.roma;

public class Calculator {
    Double firstOperand;
    Double secondOperand;
    String operation;
    Double result;

    public double calculate(String expression) {
        parseExperssion(expression);
        if (operation.equals("+")) {
            result = firstOperand + secondOperand;
        } else if (operation.equals("-")) {
            result = firstOperand - secondOperand;
        } else if (operation.equals("*")) {
            result = firstOperand * secondOperand;
        } else if (operation.equals("/")) {
            result = firstOperand / secondOperand;
        }
        return result;
    }

    private void parseExperssion(String expression) {
        String[] items = expression.split("(?<=[-+*/])|(?=[-+*/])");
        firstOperand = Double.parseDouble(items[0]);
        secondOperand = Double.parseDouble(items[2]);
        operation = items[1];
    }
}