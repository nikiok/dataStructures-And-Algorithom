package Algorithm.DataStructures.sort;

import java.util.Arrays;

/**
 * @author ��niki
 * @version :     $
 * @date ��Created in 2023/10/23 21:32
 * @description �� �鲢����
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
	 *  �ϲ�
	 * @param arr �������ԭʼ����
	 * @param left ����������еĳ�ʼ����
	 * @param mid  �м�λ�õ�����
	 * @param right �ұ�����
	 * @param temp ��������
	 */
	public static void merge(int[] arr,int left,int mid,int right,int[] temp){
		int i = left; // ������еĳ�ʼ����
		int j = mid + 1; //�ұ����еĳ�ʼ����
		int t = 0; //ָ��temp�ĵ�ǰ����

		//(1)
		//�Ȱ���������(����)�����ݰ��չ�����䵽temp����,ֱ���������ߵ��������У���һ�ߴ������Ϊֹ
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
		//����ʣ�����ݵ�һ�ߵ���������ȫ����䵽temp
		while (i <= mid){ //��ߵ��������л���ʣ��Ԫ�أ���ȫ����䵽temp
			temp[t] = arr[i];
			t += 1;
			i += 1;
		}
		while (j <= right ){ //��ߵ��������л���ʣ��Ԫ�أ���ȫ����䵽temp
			temp[t] = arr[j];
			t += 1;
			j += 1;
		}
		//(3)
		//��temp�����Ԫ�ؿ�����arr
		t = 0;
		int tempLeft = left;
		while (tempLeft <= right){
			arr[tempLeft] = temp[t];
			t += 1;
			tempLeft += 1;
		}
	}
}
