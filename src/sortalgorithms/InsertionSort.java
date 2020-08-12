package sortalgorithms;

public class InsertionSort implements SortingAlgorithm {

    @Override
    public double[] sort(double[] unsorted) {
        
        if (unsorted == null) {

            throw new NullArrayException();
        }
        
        if (unsorted.length == 0) {

            return unsorted;
        }

        int n = unsorted.length;
        int j;
        double[] sorted = new double[n];

        sorted[0] = unsorted[0];

        for (int i = 1; i < n; i++) {

            j = i - 1;

            while (j >= 0 && unsorted[i] < sorted[j]) {

                sorted[j + 1] = sorted[j];
                j--;
            }

            sorted[j + 1] = unsorted[i];
        }

        return sorted;
    }

}
