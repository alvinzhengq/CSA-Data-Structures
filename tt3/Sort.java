package tt3;

import java.time.Duration;
import java.time.Instant;

import tt3.lib.ArrayList;
import tt3.lib.Collection;
import tt3.lib.Tuple;

public class Sort {
    private final ArrayList<Integer> data = new ArrayList<>();
    private Tuple<Integer, Integer> stats;
    private Instant start, end;

    private final long[] timeElasped = new long[4];
    private final long[] comparisons = new long[4];
    private final long[] swaps = new long[4];

    public Sort(int size) {

        for (int i = 0; i < 16; i++) {

            // #################### Bubble Sort ####################

            randomizeData(size);

            start = Instant.now();
            stats = Collection.bubbleSort(data);
            end = Instant.now();

            timeElasped[0] += Duration.between(start, end).toMillis();
            comparisons[0] += stats.x;
            swaps[0] += stats.y;

            // #################### Selection Sort ####################

            randomizeData(size);

            start = Instant.now();
            stats = Collection.selectionSort(data);
            end = Instant.now();

            timeElasped[1] += Duration.between(start, end).toMillis();
            comparisons[1] += stats.x;
            swaps[1] += stats.y;

            // #################### Insertion Sort ####################

            randomizeData(size);

            start = Instant.now();
            stats = Collection.insertionSort(data);
            end = Instant.now();

            timeElasped[2] += Duration.between(start, end).toMillis();
            comparisons[2] += stats.x;
            swaps[2] += stats.y;

            // #################### Merge Sort ####################

            randomizeData(size);

            start = Instant.now();
            stats = Collection.mergeSort(data);
            end = Instant.now();

            timeElasped[3] += Duration.between(start, end).toMillis();
            comparisons[3] += stats.x;
            swaps[3] += stats.y;

        }

    }

    private void randomizeData(int size) {
        data.clear();

        for (int i = 0; i < size; i++) {
            data.add((int) (Math.random() * size));
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("");

        sb.append("Average Bubble Sort Time: " + timeElasped[0]/16.0 + "ms\n");
        sb.append("Average Bubble Sort Comparisons: " + comparisons[0]/16.0 + "\n");
        sb.append("Average Bubble Sort Swaps: " + swaps[0]/16.0 + "\n");

        sb.append("\n");

        sb.append("Average Selection Sort Time: " + timeElasped[1]/16.0 + "ms\n");
        sb.append("Average Selection Sort Comparisons: " + comparisons[1]/16.0 + "\n");
        sb.append("Average Selection Sort Swaps: " + swaps[1]/16.0 + "\n");

        sb.append("\n");

        sb.append("Average Insertion Sort Time: " + timeElasped[2]/16.0 + "ms\n");
        sb.append("Average Insertion Sort Comparisons: " + comparisons[2]/16.0 + "\n");
        sb.append("Average Insertion Sort Swaps: " + swaps[2]/16.0 + "\n");

        sb.append("\n");

        sb.append("Average Merge Sort Time: " + timeElasped[3]/16.0 + "ms\n");
        sb.append("Average Merge Sort Comparisons: " + comparisons[3]/16.0 + "\n");
        sb.append("Average Merge Sort Swaps: " + swaps[3]/16.0 + "\n");

        return sb.toString();
    }
}
