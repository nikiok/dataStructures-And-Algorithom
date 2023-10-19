package Algorithm.Get_started;

import java.util.Arrays;

public class sort {
    /**
     * 基于递归实现快速排序
     * @param array  要排序的数组
     * @param startIndex 开始下标
     * @param endIndex 结束下标
     */
    public void quicksort(int[] array,int startIndex,int endIndex){
        // 递归结束条件：开始下标大于或等于结束下标
        if(startIndex >= endIndex){
            return;
        }

        //得到基准元素的位置
        int pivotIndex = partition(array,startIndex,endIndex);
        //根据基准元素，分成两部分进行递归排序
        quicksort(array,startIndex,pivotIndex-1);
        quicksort(array,pivotIndex+1,endIndex);
    }

    /**
     * 分治（双边循环法）
     * @param array  待交换的数组
     * @param startIndex 开始下标
     * @param endIndex 结束下标
     * @return
     */
    public int partition(int[] array,int startIndex,int endIndex){
        // 取第一个元素作为基准元素（可以随机选择）
        int pivot = array[startIndex];
        int left = startIndex;
        int right = endIndex;
        while (left != right){
            //控制right指针比较并左移
            while(left < right  && array[right]> pivot){
                right--;
            }
            //控制left指针比较并右移
            while (left < right && array[left] <= pivot){
                left++;
            }
            //交换left和right指针所指向的元素
            if(left < right){
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
            }
        }
        // pivot和指针重合点交换
        array[startIndex] = array[left];
        array[left] = pivot;

        return left;
    }

    public static void main(String[] args) {
        System.out.println("*********快速排序*******");
        sort quickSort = new sort();
        int[] array = new int[]{25,34,46,1,5,3,24,29};
        quickSort.quicksort(array,0,array.length-1);
        System.out.println(Arrays.toString(array));
    }

}
