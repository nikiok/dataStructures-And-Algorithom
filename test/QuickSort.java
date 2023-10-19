package Algorithm.test;

//快速查找
/*使用了递归函数quickSort()来进行快速排序。函数partition()用于确定一个枢轴点（pivot），并将数组中的元素分为两个子数组，以便在这两个子数组上递归地进行快速排序。
在每次递归时，我们选择一个新的枢轴点，并将数组中的元素分为两个子数组。
最终，当子数组的大小小于或等于1时，排序完成。
*/
public class QuickSort {
    public static void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            int pivot = partition(arr, start, end);
            quickSort(arr, start, pivot - 1);
            quickSort(arr, pivot + 1, end);
        }
    }

    public static int partition(int[] arr, int start, int end) {
        int pivot = arr[end];
        int i = start - 1;
        for (int j = start; j <= end - 1; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[end];
        arr[end] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 3, 8, 4, 0, 1, 6, 7};
        int start = 0;
        int end = arr.length - 1;
        quickSort(arr, start, end);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
