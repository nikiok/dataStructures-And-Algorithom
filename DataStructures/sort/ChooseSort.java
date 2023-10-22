package Algorithm.DataStructures.sort;

import java.util.Arrays;

/**
 * @author ��niki
 * @version :     $
 * @date ��Created in 2023/10/22 14:53
 * @description �� ѡ������
 */
public class ChooseSort {

	public static void main(String[] args) {
		int arr[] = {2,4,-2,5,-1};
		System.out.println(Arrays.toString(arr));
		chooseSort(arr);
	}

	public static void chooseSort(int[]arr){
		for (int i = 0; i < arr.length - 1; i++) {
			int min = arr[i];
			int minIndex = i;
			for (int j = 1 + i; j < arr.length; j++) {
				if (min > arr[j]) {
					min = arr[j];
					minIndex = j;
				}
			}
			if (minIndex != i) {
				arr[minIndex] = arr[i];
				arr[i] = min;
			}
			System.out.println("��"+(i +1)+ "�ֺ�");
			System.out.println(Arrays.toString(arr));
		}
	}

}
