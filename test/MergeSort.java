package Algorithm.test;

import java.util.Arrays;
//��·��������
/*
mergeSort()���������������ȶ�������зָȻ��ݹ�ض��������������������������ź��������������ϲ�Ϊһ����������顣merge()�������ںϲ������������顣
�ںϲ�������������ʱ��ʹ������ָ�룬�ֱ�ָ����������������Ŀ�ͷ�ͺϲ�������ĵ�ǰλ�ã��Ƚ���������ָ����ָԪ�صĴ�С������С��Ԫ�ط���ϲ��������У�������Ӧָ������ƶ���
��������һ���������Ԫ��δȫ������ϲ��������У���ʣ��Ԫ��ȫ������ϲ��������С�
��main()�����У�����һ���������鲢����mergeSort()���������������������������顣
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
