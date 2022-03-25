import java.util.Scanner;

import tt0.Terminal;
import tt1.Challenges;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("1. TT0 - Terminal Lab");
        System.out.println("2. TT1 - LinkedList");
        int choice = s.nextInt();

        switch (choice) {
            case 1:
                Terminal.main(args);
                break;

            case 2:
                Challenges.main(args);
                break;
        
            default:
                break;
        }

        s.close();
    }
}
