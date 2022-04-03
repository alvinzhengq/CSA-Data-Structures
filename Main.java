import java.util.Scanner;

import tt0.Terminal;
import tt1.Challenges;
import tt2.Tester;
import tt3.SortStats;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        while (true) {
            System.out.println("1. TT0 - Terminal Lab");
            System.out.println("2. TT1 - LinkedList Lab");
            System.out.println("3. TT2 - Calculator Lab");
            System.out.println("4. TT3 - Sorts Lab");
            System.out.println("0. Exit");

            int choice = s.nextInt();

            switch (choice) {
                case 1:
                    Terminal.main(args);
                    break;

                case 2:
                    Challenges.main(args);
                    break;

                case 3:
                    Tester.main(args);
                    break;

                case 4:
                    SortStats.main(args);
                    break;

                case 0:
                    s.close();
                    System.exit(0);
                    break;

                default:
                    break;
            }

            System.out.println();
        }
    }
}
