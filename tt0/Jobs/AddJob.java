package tt0.Jobs;

import java.util.HashMap;
import java.util.Scanner;

public class AddJob extends Job {
    private static final String NAME = "Add Job";

    private void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public String getName() {
        return NAME;
    }

    public void run(HashMap<Integer, Job> prompts) {
        clear();

        Scanner s = new Scanner(System.in);
        
        System.out.print("Enter Menu Number: ");
        int key = s.nextInt();

        System.out.print("Enter Job Name: ");
        String value = s.next();

        clear();

        try {
            prompts.put(key, (Job) Class.forName("tt0.Jobs." + value).getDeclaredConstructor().newInstance());

        } catch (Exception e) {
            System.out.println("No such class exists.");

        }
    }
}