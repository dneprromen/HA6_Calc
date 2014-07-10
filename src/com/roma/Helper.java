import java.io.IOException;
import java.util.Scanner;

public class Helper {
    static Scanner sc = new Scanner(System.in);

    static public void startCalculation() throws IOException {
        try {
            Calculator calc = new Calculator();
            messenger("Enter a math expression(example: 5 + 3):\n");
            calc.calculate(sc.nextLine());
            messenger("\nDo you want to continue?(y/n)\n");

        } catch (Exception e) {
            messenger("Wrong expression, try again\n");
            startCalculation();
        }
    }

    static public void runTheProgramm() throws IOException {
        do{
            startCalculation();
        }
        while(sc.nextLine().equals("y"));
    }

    private static void messenger(String message){
        System.out.print(message);
    }
}
