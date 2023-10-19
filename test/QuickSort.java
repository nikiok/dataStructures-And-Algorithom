package Algorithm.test;

//���ٲ���
/*ʹ���˵ݹ麯��quickSort()�����п������򡣺���partition()����ȷ��һ������㣨pivot�������������е�Ԫ�ط�Ϊ���������飬�Ա����������������ϵݹ�ؽ��п�������
��ÿ�εݹ�ʱ������ѡ��һ���µ�����㣬���������е�Ԫ�ط�Ϊ���������顣
���գ���������Ĵ�СС�ڻ����1ʱ��������ɡ�
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
