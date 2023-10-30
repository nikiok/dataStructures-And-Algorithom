package Algorithm.DataStructures.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：niki
 * @version :     $
 * @date ：Created in 2023/10/30 14:37
 * @description ： 二分查找
 */
public class BinarySearch {
	public static void main(String[] args) {
		int arr[] = {1,8,10,89,100,100,100,1234};
//		int resIndex = binarySearch(arr,0,arr.length-1,100);
//		System.out.println(resIndex);

		List<Integer> resIndexList = binarySearch2(arr,0,arr.length-1,100);
		System.out.println(resIndexList);
	}

	public static int binarySearch(int[] arr,int left,int right,int findval){

		//当left > right时，说明递归l整个数组，但是没有找到该值
		if (left > right){
			return -1;
		}
		int mid = (left + right) / 2;
		int midval = arr[mid];

		if (findval > midval){
			return 	binarySearch(arr,mid+1,right,findval);
		} else if (findval < midval) {
			return binarySearch(arr,left,mid-1,findval);
		} else {
			return mid;
		}
	}

	public static ArrayList binarySearch2(int []arr,int left,int right,int findval){
		if (left > right){
			return new ArrayList<>();
		}
		int mid = (left + right) / 2;
		int midval = arr[mid];

		if (findval > midval){
			return binarySearch2(arr,mid+1,right,findval);
		} else if (findval < midval) {
			return binarySearch2(arr,left,mid-1,findval);
		} else {
			ArrayList<Integer> resIndexList = new ArrayList<>();
			int temp = mid - 1;
			while (true){
				if (temp < 0 || arr[temp] != findval){
					break;
				}
				resIndexList.add(temp);
				temp -= 1;
			}

			resIndexList.add(mid);
			temp = mid + 1;
			while (true){
				if (temp > arr.length - 1 || arr[temp] != findval){
					break;
				}
				resIndexList.add(temp);
				temp += 1;
			}
			return resIndexList;
		}
	}

}
