package Algorithm.Get_started;

import java.util.Arrays;

public class sort {
    /**
     * ���ڵݹ�ʵ�ֿ�������
     * @param array  Ҫ���������
     * @param startIndex ��ʼ�±�
     * @param endIndex �����±�
     */
    public void quicksort(int[] array,int startIndex,int endIndex){
        // �ݹ������������ʼ�±���ڻ���ڽ����±�
        if(startIndex >= endIndex){
            return;
        }

        //�õ���׼Ԫ�ص�λ��
        int pivotIndex = partition(array,startIndex,endIndex);
        //���ݻ�׼Ԫ�أ��ֳ������ֽ��еݹ�����
        quicksort(array,startIndex,pivotIndex-1);
        quicksort(array,pivotIndex+1,endIndex);
    }

    /**
     * ���Σ�˫��ѭ������
     * @param array  ������������
     * @param startIndex ��ʼ�±�
     * @param endIndex �����±�
     * @return
     */
    public int partition(int[] array,int startIndex,int endIndex){
        // ȡ��һ��Ԫ����Ϊ��׼Ԫ�أ��������ѡ��
        int pivot = array[startIndex];
        int left = startIndex;
        int right = endIndex;
        while (left != right){
            //����rightָ��Ƚϲ�����
            while(left < right  && array[right]> pivot){
                right--;
            }
            //����leftָ��Ƚϲ�����
            while (left < right && array[left] <= pivot){
                left++;
            }
            //����left��rightָ����ָ���Ԫ��
            if(left < right){
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
            }
        }
        // pivot��ָ���غϵ㽻��
        array[startIndex] = array[left];
        array[left] = pivot;

        return left;
    }

    public static void main(String[] args) {
        System.out.println("*********��������*******");
        sort quickSort = new sort();
        int[] array = new int[]{25,34,46,1,5,3,24,29};
        quickSort.quicksort(array,0,array.length-1);
        System.out.println(Arrays.toString(array));
    }

}
