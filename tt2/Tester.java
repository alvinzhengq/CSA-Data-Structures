package tt2;

import java.util.Scanner;

public class Tester {
    public static void main(String[] args) {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        
        Scanner s = new Scanner(System.in);
        
        System.out.println("Enter an expression: ");
        String expression = s.nextLine();

        Calculator calculator = new Calculator(expression);
        System.out.println(calculator);
    }
}
