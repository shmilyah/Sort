package com.geny.sort;

/**
 * 二路快排
 * @author shmilyahu
 */
public class QuickSort2 {

    private QuickSort2(){}

    public static void sort(Comparable[] arr) {
        int n = arr.length;
        sort(arr, 0, n - 1);
    }

    private static void sort(Comparable[] arr, int l, int r) {
        if (r - l <= 15) {
            InsertionSort.sort(arr, l, r);
            return;
        }
        int p = partition(arr, l, r);
        sort(arr, l, p - 1);
        sort(arr, p + 1, r);
    }

    private static int partition(Comparable[] arr, int l, int r) {
        swap(arr, l, (int)(Math.random()*(r-l+1) + l));

        Comparable v = arr[l];

        int i = l + 1, j = r;
        while (true) {
            while (i <= r && arr[i].compareTo(v) < 0)
                i++;
            while (j >= l + 1 && arr[j].compareTo(v) > 0)
                j--;
            if (i > j)
                break;
            swap(arr, i, j);
            i++;
            j--;
        }
        swap(arr, l, j);
        return j;
    }

    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    // 测试 QuickSort
    public static void main(String[] args) {

        // 双路快速排序算法也是一个O(nlogn)复杂度的算法
        // 可以在1秒之内轻松处理100万数量级的数据
        int N = 1000000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 10);
        SortTestHelper.testSort("com.geny.sort.QuickSort2", arr);

        return;
    }
}
