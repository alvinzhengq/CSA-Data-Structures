package tt0.Jobs;

import java.util.HashMap;

public abstract class Job {
    abstract public String getName();
    abstract public void run(HashMap<Integer, Job> prompts);
}
