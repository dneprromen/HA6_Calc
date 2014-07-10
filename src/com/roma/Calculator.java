package com.roma;

public class Calculator {
    Double firstOperand;
    Double secondOperand;
    String operation;

    public void calculate(String expression) {
        parseExperssion(expression);
        if (operation.equals("+")) {
            summ(firstOperand, secondOperand);
        } else if (operation.equals("-")) {
            subtract(firstOperand, secondOperand);
        } else if (operation.equals("*")) {
            multy(firstOperand, secondOperand);
        } else if (operation.equals("/")) {
            divide(firstOperand, secondOperand);
        }
    }

    private void parseExperssion(String expression) {
        String[] items = expression.split("(?<=[-+*/])|(?=[-+*/])");
        firstOperand = Double.parseDouble(items[0]);
        secondOperand = Double.parseDouble(items[2]);
        operation = items[1];
    }

    private void divide(Double firstOperand, Double secondOperand) {
        System.out.print("Result: "+(firstOperand/secondOperand));
    }

    private void multy(Double firstOperand, Double secondOperand) {
        System.out.print("Result: "+(firstOperand*secondOperand));
    }

    private void summ(Double firstOperand, Double secondOperand) {
        System.out.print("Result: "+(firstOperand+secondOperand));
    }

    private void subtract(Double firstOperand, Double secondOperand) {
        System.out.print("Result: "+(firstOperand-secondOperand));
    }
}