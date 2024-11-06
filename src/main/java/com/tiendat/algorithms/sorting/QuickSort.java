package com.tiendat.algorithms.sorting;

public class QuickSort implements InplaceSort {
    @Override
    public void sort(int[] values) {
        QuickSort.quicksort(values);
    }

    public static void quicksort(int[] ar) {
        if (ar == null) return;
        quicksort(ar, 0, ar.length - 1);
    }

    // Sort interval [lo, hi] inplace recursively
    private static void quicksort(int[] ar, int lo, int hi) {
        if (lo < hi) {
            int splitPoint = partition(ar, lo, hi);
            quicksort(ar, lo, splitPoint);
            quicksort(ar, splitPoint + 1, hi);
        }
    }

    // Performs Hoare partition algorithm for quicksort
    private static int partition(int[] ar, int lo, int hi) {
        int pivot = ar[lo];
        int i = lo - 1, j = hi + 1;
        while (true) {
            do {
                i++;
            } while (ar[i] < pivot);
            do {
                j--;
            } while (ar[j] > pivot);
            if (i < j) swap(ar, i, j);
            else return j;
        }
    }

    // Swap two elements
    private static void swap(int[] ar, int i, int j) {
        int tmp = ar[i];
        ar[i] = ar[j];
        ar[j] = tmp;
    }
}
