package tt0.Jobs;

import java.util.HashMap;

public class IntByReference extends Job {
    private int value;
    private int value2;
    private static final String NAME = "IntByReference";

    public String getName() {
        return NAME;
    }

    @Override
    public String toString() {
        return Integer.toString(this.value);
    }

    public void swapToLowHighOrder() {
        if (this.value > this.value2) {
            this.value = this.value - this.value2;
            this.value2 = this.value + this.value2;
            this.value = this.value2 - this.value;
        }
    }

    public void run(HashMap<Integer, Job> prompts) {
        this.value = 21;
        this.value2 = 16;

        System.out.println("Before: " + this.value + " " + this.value2);
        this.swapToLowHighOrder();
        System.out.println("After: " + this.value + " " + this.value2);
        System.out.println();
    }
}