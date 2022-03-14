package tt0.Jobs;

import java.util.HashMap;

public class Matrix extends Job {
    private int[][] matrix;
    private static final String NAME = "Matrix";

    public String getName() {
        return NAME;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == -1) {
                    sb.append("  ");
                } else {
                    sb.append(matrix[i][j] + " ");
                }
            }
            sb.append("\n");
        }

        sb.append("\n");
        
        for (int i = matrix.length - 1; i >= 0; i--) {
            for (int j = matrix[i].length - 1; j >= 0; j--) {
                if (matrix[i][j] == -1) {
                    sb.append("  ");
                } else {
                    sb.append(matrix[i][j] + " ");
                }
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    static int[][] keypad() {
        return new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { -1, 0, -1 } };
    }

    static int[][] numbers() {
        return new int[][] { { 0, 1 },
                { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 },
                { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 } };
    }

    public void run(HashMap<Integer, Job> prompts) {
        this.matrix = keypad();
        System.out.println("Keypad:");
        System.out.println(this);

        this.matrix = numbers();
        System.out.println("Number System:");
        System.out.println(this);
    }

}
