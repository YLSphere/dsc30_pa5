/*
 * NAME: Yin Lam Lai
 * PID:  A15779757
 */
import java.util.ArrayList;

/**
 * Sorts class
 * @param <T> Generic type
 * @author Yin Lam Lai
 * @since  3/5/2020
 */
public class Sorts<T extends Comparable<? super T>> {

    private static final int HALF_LIST = 2;

    /**
     * This method performs insertion sort on the input arraylist
     *
     * @param list  The arraylist we want to sort
     * @param start The inital index on subsection of Arraylist we want to sort
     * @param end   The final index of the subsection of Arraylist we want to sort
     */
    public void InsertionSort(ArrayList<T> list, int start, int end) {
        for (int i = start + 1; i < end + 1; i++) {
            T key = list.get(i);
            int j = i - 1;
            while (j >= start && list.get(j).compareTo(key) == 1) {
                list.set(j + 1, list.get(j));
                j = j - 1;
            }
            list.set(j + 1, key);
        }
    }

    /**
     * This method performs merge sort on the input arraylist
     *
     * @param list  The arraylist we want to sort
     * @param start The inital index on subsection of Arraylist we want to sort
     * @param end   The final index of the subsection of Arraylist we want to sort
     */
    public void MergeSort(ArrayList<T> list, int start, int end) {

        if (start < end) {
            int mid = start + (end - start) / HALF_LIST;
            MergeSort(list, start, mid);
            MergeSort(list, mid + 1, end);

            merge(list, start, mid, end);
        }
    }

    /**
     * merge helper function for MergeSort
     *
     * @param arr The arraylist we want to sort
     * @param l   left-most index we want to merge
     * @param m   the middle index we want to merge
     * @param r   right-most index we want to merge
     */
    private void merge(ArrayList<T> arr, int l, int m, int r) {

        int mergedSize = r - l + 1;

        ArrayList<T> mergedNums = new ArrayList<>();
        int left = l, right = m + 1;
        while (left <= m && right <= r) {
            if (arr.get(left).compareTo(arr.get(right)) <= 0) {
                mergedNums.add(arr.get(left));
                left++;
            } else {
                mergedNums.add(arr.get(right));
                right++;
            }
        }

        while (left <= m) {
            mergedNums.add(arr.get(left));
            left++;
        }
        while (right <= r) {
            mergedNums.add(arr.get(right));
            right++;
        }
        for (int i = 0; i < mergedSize; i++) {
            arr.set(l + i, mergedNums.get(i));
        }
    }

    /**
     * This method performs quick sort on the input arraylist
     *
     * @param list  The arraylist we want to sort
     * @param start The inital index on subsection of Arraylist we want to sort
     * @param end   The final index of the subsection of Arraylist we want to sort
     */
    public void QuickSort(ArrayList<T> list, int start, int end) {
        if (start < end) {
            int part = partition(list, start, end);
            QuickSort(list, start, part - 1);
            QuickSort(list, part + 1, end);
        }

    }

    /**
     * partition helper function for QuickSort
     *
     * @param arr The arraylist we want to sort
     * @param l   left-most index we want to merge
     * @param h   right-most index we want to merge
     */
    private int partition(ArrayList<T> arr, int l, int h) {

        T pivot = arr.get(((h - l) / 2) + l);
        T tempShift = arr.get(h);
        arr.set(h, pivot);
        arr.set(((h - l) / 2) + l, tempShift);

        int i = (l - 1);

        for (int j = l; j < h; j++) {
            if (arr.get(j).compareTo(pivot) == - 1) {
                i++;
                T temp = arr.get(i);
                arr.set(i, arr.get(j));
                arr.set(j, temp);
            }
        }

        T temp = arr.get(i + 1);
        arr.set(i + 1, arr.get(h));
        arr.set(h, temp);
        return i + 1;
    }

    /**
     * This method performs a modified QuickSort that switches to insertion sort after a certina cutoff
     *
     * @param list   The arraylist we want to sort
     * @param start  The inital index on subsection of Arraylist we want to sort
     * @param end    The final index of the subsection of Arraylist we want to sort
     * @param cutoff the minimum length of an subsection of the arraylist such that we switch to Insertion Sort
     */
    public void Modified_QuickSort(ArrayList<T> list, int start, int end, int cutoff) {
        while (start < end) {
            if (end - start + 1 < cutoff) {
                InsertionSort(list, start, end);
                break;
            } else {
                int pivot = partition(list, start, end);
                if (pivot - start < end - pivot) {
                    Modified_QuickSort(list, start, pivot - 1, cutoff);
                    start = pivot + 1;
                } else {
                    Modified_QuickSort(list, pivot + 1, end, cutoff);
                    end = pivot - 1;
                }
            }
        }
    }

    /**
     * This method performs a modified QuickSort that switches to insertion sort after a certain cutoff
     *
     * @param list  The arraylist we want to sort
     * @param start The inital index on subsection of Arraylist we want to sort
     * @param end   The final index of the subsection of Arraylist we want to sort
     * @param param The length of the initial splits that are sorted prior to merging
     */
    public void TimSort(ArrayList<T> list, int start, int end, int param) {
        for (int i = start; i < end; i += param) {
            InsertionSort(list, i, Math.min((i + param - 1), end));
        }
        for (int s = param; s < end; s = s * HALF_LIST) {
            for (int left = start; left < end+ 1; left += s * HALF_LIST) {
                int mid = left + s - 1;
                int right = Math.min((left +  s * HALF_LIST - 1), end);
                merge(list, left, mid, right);
            }
        }
    }
}