package Algorithm.DataStructures.sort;

import java.util.Arrays;

/**
 * @author ��niki
 * @version :     $
 * @date ��Created in 2023/10/28 15:12
 * @description �� ��������
 */
public class RadixSort {
	public static void main(String[] args) {
		int arr[] = {53,3,542,748,14,214};
		radixSort(arr);

	}

	public static void radixSort(int [] arr){

		//1.�õ���������������λ��
		int max = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max){
				max = arr[i];
			}
		}
		//�ж��Ǽ�λ��
		int maxLen = (max + "").length();

		//����һ����ά���飬��ʾ10��Ͱ,ÿ��Ͱ����һ��һά����
		int[][] bucket = new int[10][arr.length];
		//Ϊ�˼�¼ÿ��Ͱ�У�ʵ�ʴ���˶��ٸ����ݣ����Ƕ���һ
		// ��һά��������¼����Ͱ��ÿ�η�������ݸ���
		int[] bucketElementCounts = new int[10];
		for (int i = 0,n = 1; i < maxLen;i++,n *= 10){
			for (int j = 0; j < arr.length;j++){
				//ȡ��ÿ��Ԫ�صĸ�λ��ֵ
				int digitOfElement = arr[j] / n % 10;
				//���뵽��Ӧ��Ͱ��
				bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
				bucketElementCounts[digitOfElement]++;
			}
			//�������Ͱ��˳��һά������±�����ȡ�����ݣ�����ԭ�����飩
			int index = 0;
			for (int k = 0;k < bucketElementCounts.length;k++){
				//���Ͱ�У������ݣ����ǲŷ��뵽ԭ���飬
				if (bucketElementCounts[k] != 0){
					//ѭ����Ͱ����k��Ͱ������k��һά���飩������
					for (int l = 0;l < bucketElementCounts[k];l++){
						//ȡ��Ԫ�ط���arr
						arr[index++] = bucket[k][l];
					}
				}
				//��i+1�ִ������Ҫ��ÿ��bucketElementCounts[k] = 0
				bucketElementCounts[k] = 0;
			}
		System.out.println("��" + (i+1) + "�֣��Ը�λ�������� arr =" + Arrays.toString(arr));
		}
	}

}
