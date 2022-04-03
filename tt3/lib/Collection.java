package tt3.lib;

public interface Collection<E> {
    public void add(E e);
    public void add(int index, E e);
    public void set(int index, E e);

    public boolean contains(E e);
    public boolean isEmpty();

    public void remove(E e);
    public E get(int index);

    public void clear();
    public int size();

    public static <T extends Comparable<T>> Tuple<Integer, Integer> bubbleSort(ArrayList<T> list) {
        int comparisons = 0;
        int swaps = 0;

        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0; j < list.size() - 1 - i; j++) {
                if (list.get(j).compareTo(list.get(j + 1)) > 0) {
                    T temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);

                    swaps++;
                }
                comparisons++;
            }
        }

        return new Tuple<>(comparisons, swaps);
    }

    public static <T extends Comparable<T>> Tuple<Integer, Integer> selectionSort(ArrayList<T> list) {
        int comparisons = 0;
        int swaps = 0;

        for (int i = 0; i < list.size() - 1; i++) {
            int min = i;

            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j).compareTo(list.get(min)) < 0) {
                    min = j;
                }
                comparisons++;
            }

            T temp = list.get(i);
            list.set(i, list.get(min));
            list.set(min, temp);
            swaps++;
        }

        return new Tuple<>(comparisons, swaps);
    }

    public static <T extends Comparable<T>> Tuple<Integer, Integer> insertionSort(ArrayList<T> list) {
        int comparisons = 0;
        int swaps = 0;
        
        for (int i = 1; i < list.size(); i++) {
            T temp = list.get(i);
            int j = i;
            while (j > 0 && temp.compareTo(list.get(j - 1)) < 0) {
                list.set(j, list.get(j - 1));
                j--;
                comparisons++;
                swaps++;
            }
            list.set(j, temp);
            swaps++;
        }

        return new Tuple<>(comparisons, swaps);
    }

    public static <T extends Comparable<T>> Tuple<Integer, Integer> mergeSort(ArrayList<T> list) {
        int comparisons = 0;
        int swaps = 0;

        if (list.size() > 1) {
            ArrayList<T> left = new ArrayList<T>();
            ArrayList<T> right = new ArrayList<T>();

            for (int i = 0; i < list.size() / 2; i++) {
                left.add(list.get(i));
            }
            for (int i = list.size() / 2; i < list.size(); i++) {
                right.add(list.get(i));
            }

            mergeSort(left);
            mergeSort(right);

            Tuple<Integer, Integer> stats = merge(left, right, list);
            comparisons += stats.x;
            swaps += stats.y;
        }

        return new Tuple<>(comparisons, swaps);
    }

    private static <T extends Comparable<T>> Tuple<Integer, Integer> merge(ArrayList<T> left, ArrayList<T> right, ArrayList<T> list) {
        int i = 0, j = 0, k = 0;
        int comparisons = 0;
        int swaps = 0;

        while (i < left.size() && j < right.size()) {
            if (left.get(i).compareTo(right.get(j)) < 0) {
                list.set(k, left.get(i));
                i++;

                swaps++;
            } else {
                list.set(k, right.get(j));
                j++;

                swaps++;
            }

            comparisons++;
            k++;
        }

        while (i < left.size()) {
            list.set(k, left.get(i));
            i++; k++;

            comparisons++;
            swaps++;
        }
        while (j < right.size()) {
            list.set(k, right.get(j));
            j++; k++;

            comparisons++;
            swaps++;
        }

        return new Tuple<>(comparisons, swaps);
    }
}
