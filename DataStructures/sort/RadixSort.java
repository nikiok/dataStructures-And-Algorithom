package Algorithm.DataStructures.sort;

import java.util.Arrays;

/**
 * @author ：niki
 * @version :     $
 * @date ：Created in 2023/10/28 15:12
 * @description ： 基数排序
 */
public class RadixSort {
	public static void main(String[] args) {
		int arr[] = {53,3,542,748,14,214};
		radixSort(arr);

	}

	public static void radixSort(int [] arr){

		//1.得到数组中最大的数的位数
		int max = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max){
				max = arr[i];
			}
		}
		//判断是几位数
		int maxLen = (max + "").length();

		//定义一个二维数组，表示10个桶,每个桶就是一个一维数组
		int[][] bucket = new int[10][arr.length];
		//为了记录每个桶中，实际存放了多少个数据，我们定义一
		// 个一维数组来记录各个桶的每次放入的数据个数
		int[] bucketElementCounts = new int[10];
		for (int i = 0,n = 1; i < maxLen;i++,n *= 10){
			for (int j = 0; j < arr.length;j++){
				//取出每个元素的个位的值
				int digitOfElement = arr[j] / n % 10;
				//放入到对应的桶中
				bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
				bucketElementCounts[digitOfElement]++;
			}
			//按照这个桶的顺序（一维数组的下标依次取出数据，放入原来数组）
			int index = 0;
			for (int k = 0;k < bucketElementCounts.length;k++){
				//如果桶中，有数据，我们才放入到原数组，
				if (bucketElementCounts[k] != 0){
					//循环该桶即第k个桶（即第k个一维数组），放入
					for (int l = 0;l < bucketElementCounts[k];l++){
						//取出元素放入arr
						arr[index++] = bucket[k][l];
					}
				}
				//第i+1轮处理后，需要将每个bucketElementCounts[k] = 0
				bucketElementCounts[k] = 0;
			}
		System.out.println("第" + (i+1) + "轮，对个位的排序处理 arr =" + Arrays.toString(arr));
		}
	}

}
