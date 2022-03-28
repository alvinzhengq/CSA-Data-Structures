package tt2;

import java.util.Scanner;

public class Tester {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        System.out.println("Enter an expression: ");
        String expression = s.nextLine();

        Calculator calculator = new Calculator(expression);
        System.out.println(calculator);

        s.close();
    }
}
