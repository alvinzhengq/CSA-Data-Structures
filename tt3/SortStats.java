package tt3;

import tt3.Sort;

public class SortStats {
    public static void main(String[] args) {
        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println("Running tests...");

        Sort s = new Sort(5000);

        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println(s);
    }
}
