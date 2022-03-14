import java.util.Scanner;

import tt0.Terminal;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("1. TT0 - Terminal Lab");
        int choice = s.nextInt();

        switch (choice) {
            case 1:
                Terminal.main(args);
                break;
        
            default:
                break;
        }

        s.close();
    }
}
