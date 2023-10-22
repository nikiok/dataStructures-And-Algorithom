package Algorithm.DataStructures.sort;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author ：niki
 * @version :     $
 * @date ：Created in 2023/10/22 20:03
 * @description ： 希尔排序
 */
public class ShellSort {
	public static void main(String[] args) {
		int arr[] = {8,9,1,7,2,3,5,4,6,0};
		shellSort(arr);

//		int [] arr2 = new int[100000];
//		for (int i = 0; i < arr2.length; i++) {
//			arr2[i] = (int)(Math.random() * 100000);
//		}
//
//		Date date1 = new Date();
//		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		String date1str = simpleDateFormat.format(date1);
//		System.out.println("排序前的时间是:" + date1str);
//
//		shellSort(arr2);
//
//		Date date2 = new Date();
//		String date2str = simpleDateFormat.format(date2);
//		System.out.println("排序后的时间是:" + date2str);
	}

	public static void shellSort(int arr[]){
		int temp = 0;
		int count = 0;
		for (int gap = arr.length / 2;gap > 0; gap /= 2){
			for (int i = gap;i < arr.length;i++){
				for (int j = i - gap; j >= 0 ; j -= gap) {
					if (arr[j] > arr[j + gap]){
						temp = arr[j];
						arr[j] = arr[j + gap];
						arr[j + gap] = temp;
					}
				}
			}
			count++;
			System.out.printf("第%d轮希尔排序\n",count);
			System.out.println(Arrays.toString(arr));
		}
	}
}
