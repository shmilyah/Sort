package com.geny.sort;

/**
 * 三路快排
 * @author shmilyahu
 */
public class QuickSort3 {

    private QuickSort3(){}

    public static void sort(Comparable[] arr) {
        int n = arr.length;
        sort(arr, 0, n - 1);
    }

    private static void sort(Comparable[] arr, int l, int r) {
        if (r - l <= 15) {
            InsertionSort.sort(arr, l, r);
            return;
        }

        swap(arr, l, (int)(Math.random()*(r-l+1) + l));

        Comparable v = arr[l];

        int lt = l, gt = r+1, i = l + 1;

        while (i < gt) {
            if (arr[i].compareTo(v) < 0) {
                swap(arr, i, lt + 1);
                lt++;
                i++;
            }
            else if (arr[i].compareTo(v) > 0) {
                swap(arr, i, gt - 1);
                gt--;
            }
            else {
                i++;
            }
        }
        swap(arr, l, lt);
        sort(arr, l, lt - 1);
        sort(arr, gt, r);
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
        SortTestHelper.testSort("com.geny.sort.QuickSort3", arr);

        return;
    }
}
