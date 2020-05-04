import org.junit.Before;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class SortsTest {
    ArrayList<Integer> test1;
    ArrayList<Integer> test2;
    ArrayList<Integer> test3;
    Sorts testSort;

    @Before
    public void setup() {
        test1 = new ArrayList<>(Arrays.asList(1, 2, 0, 3, 4, 7, 8, 1, 1));
        test2 = new ArrayList<>(Arrays.asList(1, 2, 8, 3, 0, 7, 4));
        test3 = new ArrayList<>(Arrays.asList(1));
        testSort = new Sorts();

    }

    @org.junit.Test
    public void insertionSort() {
        ArrayList<Integer> expected1 = new ArrayList<>(Arrays.asList(1, 2, 0, 3, 4, 7, 8, 1, 1));
        ArrayList<Integer> expected2 = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 7, 8));
        ArrayList<Integer> expected3 = new ArrayList<>(Arrays.asList(1));
        testSort.InsertionSort(test1, 2,test1.size()-3);
        testSort.InsertionSort(test2, 0,test2.size()-1);
        testSort.InsertionSort(test3, 0,test3.size()-1);
        assertEquals(expected1, test1);
        assertEquals(expected2, test2);
        assertEquals(expected3, test3);

    }

    @org.junit.Test
    public void mergeSort() {
        ArrayList<Integer> expected1 = new ArrayList<>(Arrays.asList(1, 2, 0, 3, 4, 7, 8, 1, 1));
        ArrayList<Integer> expected2 = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 7, 8));
        ArrayList<Integer> expected3 = new ArrayList<>(Arrays.asList(1));

        testSort.MergeSort(test1, 2,test1.size()-3);
        testSort.MergeSort(test2, 0,test2.size()-1);
        testSort.MergeSort(test3, 0,test3.size()-1);

        assertEquals(expected1, test1);
        assertEquals(expected2, test2);
        assertEquals(expected3, test3);
    }

    @org.junit.Test
    public void quickSort() {
        ArrayList<Integer> expected1 = new ArrayList<>(Arrays.asList(1, 2, 0, 3, 4, 7, 8, 1, 1));
        ArrayList<Integer> expected2 = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 7, 8));
        ArrayList<Integer> expected3 = new ArrayList<>(Arrays.asList(1));

        testSort.QuickSort(test1, 2,test1.size()-3);
        testSort.QuickSort(test2, 0,test2.size()-1);
        testSort.QuickSort(test3, 0,test3.size()-1);

        assertEquals(expected1, test1);
        assertEquals(expected2, test2);
        assertEquals(expected3, test3);
    }

    @org.junit.Test
    public void modified_QuickSort() {
        ArrayList<Integer> expected1 = new ArrayList<>(Arrays.asList(1, 2, 0, 3, 4, 7, 8, 1, 1));
        ArrayList<Integer> expected2 = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 7, 8));
        ArrayList<Integer> expected3 = new ArrayList<>(Arrays.asList(1));

        testSort.Modified_QuickSort(test1, 2,test1.size()-3, 2);
        testSort.Modified_QuickSort(test2, 0,test2.size()-1, 2);
        testSort.Modified_QuickSort(test3, 0,test3.size()-1, 2);

        assertEquals(expected1, test1);
        assertEquals(expected2, test2);
        assertEquals(expected3, test3);
    }

    @org.junit.Test
    public void timSort() {
        ArrayList<Integer> expected1 = new ArrayList<>(Arrays.asList(1, 2, 0, 3, 4, 7, 8, 1, 1));
        ArrayList<Integer> expected2 = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 7, 8));
        ArrayList<Integer> expected3 = new ArrayList<>(Arrays.asList(1));

        testSort.TimSort(test1, 2,test1.size()-3, 4);
        testSort.TimSort(test2, 0,test2.size()-1, 2);
        testSort.TimSort(test3, 0,test3.size()-1, 8);

        assertEquals(expected1, test1);
        assertEquals(expected2, test2);
        assertEquals(expected3, test3);
    }
}