package com.roma;

import java.io.IOException;
import java.util.Scanner;

public class Calculator {

    private static Scanner sc;

    public static void main(String[] args) throws IOException {

        sc = new Scanner(System.in);
        do {
            startCalculation();
        } while (sc.nextLine().equals("y"));
    }

    private static void startCalculation() {
        try {
            Preparator prep = new Preparator();
            System.out.print("Enter a math expression(example: 2+2*2+2):\n");
            prep.parseAndExecute(sc.nextLine());
            System.out.print("\nDo you want to continue?(y/n)\n");

        } catch (Exception e) {
            System.out.print("Wrong expression, try again\n");
            startCalculation();
        }
    }

}
