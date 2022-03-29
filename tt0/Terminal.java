package tt0;

import java.util.HashMap;
import java.util.Scanner;

import tt0.Jobs.AddJob;
import tt0.Jobs.Matrix;
import tt0.Jobs.Print;
import tt0.Jobs.IntByReference;
import tt0.Jobs.Job;

public class Terminal {
    static HashMap<Integer, Job> prompts = new HashMap<>();

    static public void main(String[] args) {
        prompts.put(1, new AddJob());

        clear();
        menu();
    }

    private static void print_menu() {
        System.out.println("-------------------------\n");
        System.out.println("Choose from these choices");
        System.out.println("-------------------------\n");

        for (Integer key : prompts.keySet()) {
            System.out.printf("%d - %s\n", key, prompts.get(key).getName());
        }

        System.out.println("0 - Quit");
        System.out.print("\n> ");
    }

    private static void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void menu() {

        int selection = 0;
        Scanner scan = new Scanner(System.in);

        print_menu();
        try {

            selection = scan.nextInt();
            clear();

            if (selection == 0) {
                return;

            } else if (prompts.containsKey(selection)) {
                prompts.get(selection).run(prompts);

            } else {
                System.out.println("Invalid choice.");

            }

        } catch (Exception e) {
            clear();
            System.out.println("Invalid choice.");
            scan.nextLine();
        }

        menu();
    }

}