package Algorithm.DataStructures.sort;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author ：niki
 * @version :     $
 * @date ：Created in 2023/10/22 15:36
 * @description ： 插入排序
 */
public class InsertSort {

	public static void main(String[] args) {
		int arr[] = {12,3,5,78};
		insertSort(arr);
	}

	public static void insertSort(int arr[]){

		for (int i = 0; i < arr.length ; i++) {
			int insertVal = arr[i];
			int insertIndex = i - 1;
			while (insertIndex >= 0 && insertVal < arr[insertIndex]){ //insertIndex >= 0 防止越界
				arr[insertIndex + 1] = arr[insertIndex]; //后移
				insertIndex--;
			}
			arr[insertIndex + 1] = insertVal;
			System.out.println(Arrays.toString(arr));
		}
	}

}
