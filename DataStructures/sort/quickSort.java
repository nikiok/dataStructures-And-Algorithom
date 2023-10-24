package Algorithm.DataStructures.sort;

import java.util.Arrays;

/**
 * @author ：niki
 * @version :     $
 * @date ：Created in 2023/10/23 11:40
 * @description ： 快速排序
 */
public class quickSort {
	public static void main(String[] args) {
		int[] arr = {-8,45,0,23,-16,66};
		quickSort(arr,0, arr.length-1);
	}

	public static void quickSort(int[] arr,int left,int right){
		int l = left;
		int r = right;
		int temp = 0;
		//privot 中轴值
		int privot = arr[(left + right) / 2];
		while(l < r){
			while (arr[l] < privot){ //让比privot值小的放到左边
				l += 1;
			}
			while (arr[r] > privot){ //比privot值大的放在右边
			   r -= 1;
			}
			if (l >= r){
				break;
			}
			temp = arr[l];
			arr[l] = arr[r];
			arr[r] = temp;

			if (arr[l] == privot){
				r -= 1;
			}
			if (arr[r] == privot){
				l += 1;
			}
		}
		System.out.println(Arrays.toString(arr));
	}
}
