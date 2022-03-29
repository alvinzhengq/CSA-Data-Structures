package tt2;

import java.util.Scanner;

public class Tester {
    public static void main(String[] args) {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        
        Scanner s = new Scanner(System.in);
        
        System.out.println("1. Enter Custom Expression");
        System.out.println("2. Hardcoded Test Cases");

        int choice = s.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Enter an expression: ");
                s.nextLine();
                String expression = s.nextLine();
        
                Calculator calc = new Calculator(expression);
                System.out.println(calc);
                break;

            case 2:
                String[] tests = {
                    "100 + 200  * 3",
                    "(100 + 200)  * 3",
                    "100.2 - 99.3",
                    "300 % 200",
                    "300/200",
                    "300 * 200",
                    "200 % 300 + 5 + 300 / 200 + 1 * 100",
                    "200 % (300 + 5 + 300) / 200 + 1 * 100",
                    "200%(300+5+300)/200+1*100",
                    "SQRT( 3^2 + 4^2 )",
                };

                for (String test : tests) {
                    Calculator calc_1 = new Calculator(test);
                    System.out.println(calc_1);
                    System.out.println();
                }

                break;
        }
    }
}
