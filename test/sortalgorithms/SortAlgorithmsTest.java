package sortalgorithms;

import org.junit.Test;
import static org.junit.Assert.*;

public class SortAlgorithmsTest {

    @Test
    public void testInserionSort() {

        double[] test = new double[]{4, 2, 5, 1, 3};
        double[] validation = new double[]{1, 2, 3, 4, 5};
        InsertionSort is = new InsertionSort();
        assertArrayEquals(is.sort(test), validation, 0);
        
        double[] test2 = new double[0];
        double[] validation2 = new double[0];
        assertArrayEquals(is.sort(test2), validation2, 0);
    }

    @Test
    public void testQuickSort() {

        double[] test = new double[]{4, 2, 5, 8, 1, 3, 7, 6};
        double[] validation = new double[]{1, 2, 3, 4, 5, 6, 7, 8};
        QuickSort qs = new QuickSort();
        assertArrayEquals(qs.sort(test), validation, 0);
    }

    @Test(expected = NullArrayException.class)
    public void testNullInputQS() {

        double[] vec = null;
        QuickSort qs = new QuickSort();
        qs.sort(vec);

    }

    @Test(expected = NullArrayException.class)
    public void testNullInputIS() {

        double[] vec = null;
        InsertionSort is = new InsertionSort();
        is.sort(vec);

    }
}
