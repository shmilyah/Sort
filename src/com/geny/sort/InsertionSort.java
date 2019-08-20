package com.geny.sort;

/**
 * 插入排序
 * @author shmilyahu
 */
public class InsertionSort {

    private InsertionSort(){}

    public static void sort(Comparable[] arr) {
        for (int i = 1; i < arr.length; i++) {
            Comparable t = arr[i];
            int j = i;
            for (; j > 0 && arr[j - 1].compareTo(t) > 0; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = t;
        }
    }

    public static void sort(Comparable[] arr, int l, int r) {
        for (int i = l + 1; i <= r; i++) {
            Comparable t = arr[i];
            int j = i;
            for (; j > l && arr[j - 1].compareTo(t) > 0; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = t;
        }
    }
    // 测试InsertionSort
    public static void main(String[] args) {

        int N = 20000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("com.geny.sort.InsertionSort", arr);
        return;
    }

}
