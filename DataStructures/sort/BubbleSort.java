package Algorithm.DataStructures.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author ��niki
 * @version :     $
 * @date ��Created in 2023/10/22 13:59
 * @description �� ð������
 */
public class BubbleSort {
	public static void main(String[] args) {
		int arr[] = {3,9,-1,10,15};
		System.out.printf("����ǰ������\n" + Arrays.toString(arr));
		maopao(arr);
		System.out.printf("����������\n" + Arrays.toString(arr));



//		//�����Ż�Ч��
//		int [] arr2 = new int[50000];
//		for (int i = 0; i < arr2.length; i++) {
//			arr2[i] = (int)(Math.random() * 50000);
//		}
//
//		Date date1 = new Date();
//		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		String date1str = simpleDateFormat.format(date1);
//		System.out.println("����ǰ��ʱ����:" + date1str);
//
//		maopao(arr2);
//
//		Date date2 = new Date();
//		String date2str = simpleDateFormat.format(date2);
//		System.out.println("������ʱ����:" + date2str);


	}

	public static void maopao(int arr[]){
		int temp = 0;
		boolean flag = false;
		for (int j = 0; j < arr.length - 1; j++) {
			for (int i = 0; i < arr.length - 1 - j ; i++) {
				if (arr[i] > arr[i+1]){
					flag = true;
					temp = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = temp;
				}
			}
//			System.out.printf("��%d������������\n",j+1);
//			System.out.println(Arrays.toString(arr));
			if (!flag ){
				break;
			}else {
				flag = false; //����flag
			}
		}

	}
}
