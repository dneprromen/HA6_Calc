package com.roma;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Helper {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static public void startCalculation() throws IOException {
        try {
            Calculator calc = new Calculator();
            messenger("Enter a math expression(example:5+3):\n");
            System.out.print(calc.calculate(reader.readLine()));
        } catch (Exception e) {
            messenger("Wrong expression, try again\n");
            startCalculation();
        }
        finally {
            reader.close();
        }
    }

    private static void messenger(String message){
        System.out.print(message);
    }
}
