package Algorithm.test;

import java.util.Arrays;
//二路并归排序
/*
mergeSort()方法用于排序，首先对数组进行分割，然后递归地对左右两个子数组进行排序，最后将排好序的左右子数组合并为一个有序的数组。merge()方法用于合并两个有序数组。
在合并两个有序数组时，使用三个指针，分别指向左右两个子数组的开头和合并后数组的当前位置，比较左右两个指针所指元素的大小，将较小的元素放入合并后数组中，并将相应指针向后移动。
最后，如果有一个子数组的元素未全部放入合并后数组中，则将剩余元素全部放入合并后数组中。
在main()方法中，创建一个整数数组并调用mergeSort()方法进行排序，最后输出排序后的数组。
*
* */
public class MergeSort {
    public static void mergeSort(int[] arr) {
        int n = arr.length;
        if (n <= 1) {
            return;
        }
        int mid = n / 2;
        int[] left = new int[mid];
        int[] right = new int[n - mid];
        for (int i = 0; i < mid; i++) {
            left[i] = arr[i];
        }
        for (int i = mid; i < n; i++) {
            right[i - mid] = arr[i];
        }
        mergeSort(left);
        mergeSort(right);
        merge(left, right, arr);
    }

    public static void merge(int[] left, int[] right, int[] arr) {
        int nL = left.length;
        int nR = right.length;
        int i = 0, j = 0, k = 0;
        while (i < nL && j < nR) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }
        while (i < nL) {
            arr[k] = left[i];
            i++;
            k++;
        }
        while (j < nR) {
            arr[k] = right[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        int[] arr = {38, 27, 43, 3, 9, 82, 10};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
