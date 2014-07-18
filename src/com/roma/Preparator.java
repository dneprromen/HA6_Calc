package com.roma;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.ListIterator;

public class Preparator {
    LinkedList<Result> allItems = new LinkedList<Result>();

    public void parseAndExecute(String expression) {
        parseExperssion(expression);
        createHierarchy();
        System.out.print(executeHierarchy(allItems.get(0)));

    }

    private double executeHierarchy(Result operation) {
        return operation.getNumber();
    }

    private void prepareExecution(Operation operation, Result number1, Result number2) {
        operation.setNumber1(number1);
        operation.setNumber2(number2);
    }

    private void parseExperssion(String expression) {
        LinkedList<String> items = new LinkedList<String>(Arrays.asList(expression.split("(?<=[-+*/])|(?=[-+*/])")));
        checkNegativeValues(items);
        TypesFactory typeFactory = new TypesFactory();
        for (int i = 0; i < items.size(); i++) {
            allItems.add(typeFactory.getType(items.get(i)));
        }
    }

    public void createHierarchy() {
        int numberOfRepetitions = countNumberOfOperations(allItems);
        for (int i = 0; i < numberOfRepetitions; i++) {
            ListIterator<Result> iter = allItems.listIterator(1);
            while (iter.hasNext()) {
                int a = getIndex(iter);
                if (!allItems.get(a).isReady() && allItems.get(a).getPriority() >= getNextOperationPriority(a)) {
                    prepareExecution((Operation) allItems.get(a), allItems.get(a - 1), (allItems.get(a + 1)));
                    allItems.remove(a + 1);
                    allItems.remove(a - 1);
                    break;
                }
                iter.next();
            }
        }
    }

    private int getIndex(ListIterator<Result> iter) {
        int a = 0;
        if (iter.hasNext()) {
            a = iter.nextIndex() - 1;
        } else if (iter.hasPrevious()) {
            a = iter.previousIndex() + 1;
        }
        return a;
    }

    private int getNextOperationPriority(int index) {
        for (int i = index + 1; i < allItems.size(); i++) {
            if (allItems.get(i).isOperation() && !allItems.get(i).isReady()) {
                return allItems.get(i).getPriority();
            }
        }
        return 0;
    }

    private int countNumberOfOperations(LinkedList<Result> items) {
        int counter = 0;
        for (Result item : items) {
            if (item.isOperation()) {
                counter++;
            }
        }
        return counter;
    }

    private void checkNegativeValues(LinkedList<String> items) {
        if (items.get(0).isEmpty()) {
            items.remove(0);
        }
        for (int i = 0; i < items.size(); i++)
            if (items.get(i).equals("-")) {
                try {
                    Double.parseDouble(items.get(i - 1));
                } catch (Exception e) {
                    items.add(i + 1, String.format("%s" + items.get(i + 1), "-"));
                    items.remove(i + 2);
                    items.remove(i);
                }
            }
    }
}
