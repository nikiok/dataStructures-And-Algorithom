package Algorithm.DataStructures.sort;

import java.util.Arrays;

/**
 * @author ：niki
 * @version :     $
 * @date ：Created in 2023/10/23 21:32
 * @description ： 归并排序
 */
public class MergeSort {
	public static void main(String[] args) {
		int[] arr = {8,4,5,7,1,3,6,2};
		int[] temp = new int[arr.length];
		mergeSort(arr,0, arr.length-1,temp);
		System.out.println(Arrays.toString(arr));
	}


	public static void mergeSort(int[] arr,int left,int right,int [] temp){
		if (left < right){
			int mid = (left + right) / 2;
			mergeSort(arr,left,mid,temp);
			mergeSort(arr,mid + 1,right,temp);
			merge(arr,left,mid,right,temp);
		}
	}
	/**
	 *  合并
	 * @param arr 待排序的原始数组
	 * @param left 左边有序序列的初始索引
	 * @param mid  中间位置的索引
	 * @param right 右边索引
	 * @param temp 辅助数组
	 */
	public static void merge(int[] arr,int left,int mid,int right,int[] temp){
		int i = left; // 左边序列的初始索引
		int j = mid + 1; //右边序列的初始索引
		int t = 0; //指向temp的当前索引

		//(1)
		//先把左右两边(有序)的数据按照规则填充到temp数组,直到左右两边的有序序列，有一边处理完毕为止

		while (i <= mid && j <= right){
			if (arr[i] <= arr[j]){
				temp[t] = arr[i];
				t += 1;
				i += 1;
			}else {
				temp[t] = arr[j];
				t += 1;
				j += 1;
			}
		}

		//(2)
		//把有剩余数据的一边的数据依次全部填充到temp
		while (i <= mid){ //左边的有序序列还有剩余元素，就全部填充到temp
			temp[t] = arr[i];
			t += 1;
			i += 1;
		}

		while (j <= right ){ //左边的有序序列还有剩余元素，就全部填充到temp
			temp[t] = arr[j];
			t += 1;
			j += 1;
		}

		//(3)
		//将temp数组的元素拷贝到arr
		t = 0;
		int tempLeft = left;
		while (tempLeft <= right){
			arr[tempLeft] = temp[t];
			t += 1;
			tempLeft += 1;
		}
	}
}
