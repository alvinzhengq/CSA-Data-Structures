package tt0.Jobs;

import java.util.HashMap;

public class Print extends Job {
    private static final String NAME = "Printer";

    public String getName() {
        return NAME;
    }

    public void run(HashMap<Integer, Job> prompts) {
        System.out.println("Hello World!");
    }
}
