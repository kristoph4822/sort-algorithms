package sortalgorithms;

import java.util.ArrayList;

public class QuickSort implements SortingAlgorithm {

    @Override
    public double[] sort(double[] vec) {

        if (vec == null) {

            throw new NullArrayException();
        }

        ArrayList<Integer> stack = new ArrayList<>();
        stack.add(0);
        stack.add(vec.length);

        while (!stack.isEmpty()) {

            int end = stack.get(stack.size() - 1);
            stack.remove(stack.size() - 1);

            int start = stack.get(stack.size() - 1);
            stack.remove(stack.size() - 1);

            if (end - start < 2) {
                continue;
            }

            int mid = start + ((end - start) / 2);
            int pivot = getMedian(vec, start, end - 1, mid);

            pivot = partition(vec, pivot, start, end);

            stack.add(pivot + 1);
            stack.add(end);
            stack.add(start);
            stack.add(pivot);

        }

        return vec;
    }

    private static int partition(double[] vec, int pivotIdx, int start, int end) {

        int divider = end - 2;
        int pointer = start;
        double pivot = vec[pivotIdx];
        swap(vec, pivotIdx, end - 1);

        while (pointer < divider) {
            if (vec[pointer] < pivot) {
                pointer++;
            } else if (vec[divider] >= pivot) {
                divider--;
            } else {
                swap(vec, pointer, divider);
            }
        }

        divider += vec[divider] < pivot ? 1 : 0;
        swap(vec, divider, end - 1);

        return divider;
    }

    private static void swap(double[] vec, int a, int b) {

        double temp = vec[a];
        vec[a] = vec[b];
        vec[b] = temp;
    }

    private static int getMedian(double[] vec, int a, int b, int c) {

        return (vec[a] < vec[b] && vec[a] > vec[c]) || (vec[a] > vec[b] && vec[a] < vec[c]) ? a
                : ((vec[a] > vec[b] && vec[b] > vec[c]) || (vec[a] < vec[b] && vec[b] < vec[c]) ? b : c);
    }

}
