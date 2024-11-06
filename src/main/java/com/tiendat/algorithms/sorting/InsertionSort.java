package com.tiendat.algorithms.sorting;

public class InsertionSort implements InplaceSort {
    @Override
    public void sort(int[] values) {
        InsertionSort.insertionSort(values);
    }

    // Sort the given array using insertion sort. The idea behind
    // insertion sort is that at the array is already sorted from
    // [0, i] and you want to add the element at position i+1, so
    // you 'insert' it at the appropriate location.
    private static void insertionSort(int[] ar) {
        if (ar == null) {
            return;
        }

        for (int i = 1; i < ar.length; i++) {
            for (int j = i; j > 0 && ar[j] < ar[j - 1]; j--) {
                swap(ar, j - 1, j);
            }
        }
    }

    private static void swap(int[] ar, int i, int j) {
        int tmp = ar[i];
        ar[i] = ar[j];
        ar[j] = tmp;
    }
}
