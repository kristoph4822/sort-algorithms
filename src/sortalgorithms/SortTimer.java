package sortalgorithms;

import java.util.concurrent.ThreadLocalRandom;

public class SortTimer {

    static int RAND_AVG = 20;

    public static void main(String[] args) {

        int MAX = 20_000;
        int INTERVAL = 100;
        
        System.out.println("Elements, QS Pessimistic, QS Random, IS Pessimistic, IS Random");
        System.out.println("-------------------------------------------------------------------");

        for (int i = INTERVAL; i <= MAX; i += INTERVAL) {
            System.out.println(i + ",     " + getQsPesTime(i) + ",     " + getQsRandTime(i) + ",     " + getIsPesTime(i) + ",     " + getIsRandTime(i));
        }
    }

    public static long getQsPesTime(int n_elements) {

        double[] vec = new double[n_elements];
        QuickSort qs = new QuickSort();

        for (int i = 0; i < n_elements; i++) {
            vec[i] = 0;
        }

        long startTime = System.nanoTime();
        qs.sort(vec);
        long endTime = System.nanoTime();

        return endTime - startTime;
    }

    public static long getQsRandTime(int n_elements) {

        double[] vec = new double[n_elements];
        QuickSort qs = new QuickSort();
        long time = 0;

        for (int i = 0; i < RAND_AVG; i++) {

            for (int j = 0; j < n_elements; j++) {

                vec[j] = ThreadLocalRandom.current().nextDouble();
            }

            long startTime = System.nanoTime();
            qs.sort(vec);
            long endTime = System.nanoTime();
            time += endTime - startTime;
        }

        return time / RAND_AVG;
    }

    public static long getIsPesTime(int n_elements) {

        double[] vec = new double[n_elements];
        InsertionSort is = new InsertionSort();

        for (int i = 0; i < n_elements; i++) {

            vec[i] = n_elements - 1 - i;
        }

        long startTime = System.nanoTime();
        is.sort(vec);
        long endTime = System.nanoTime();

        return endTime - startTime;
    }

    public static long getIsRandTime(int n_elements) {

        double[] vec = new double[n_elements];
        InsertionSort is = new InsertionSort();
        long time = 0;

        for (int i = 0; i < RAND_AVG; i++) {

            for (int j = 0; j < n_elements; j++) {

                vec[j] = ThreadLocalRandom.current().nextDouble();
            }

            long startTime = System.nanoTime();
            is.sort(vec);
            long endTime = System.nanoTime();
            time += endTime - startTime;
        }

        return time / RAND_AVG;
    }

}
