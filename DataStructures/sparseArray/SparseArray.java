package Algorithm.DataStructures.sparseArray;

import java.io.*;

/**
 * -----------------------------------------------
 *
 * @author ��niki
 * @date ��Created in 2023/10/2 10:08
 * @description�� ϡ������  <--->  ��ά����
 * @version: $
 * -----------------------------------------------
 */
public class SparseArray {
	public static void main(String[] args) {
		//����һ��ԭʼ�Ķ�ά����
		// 0: ��ʾû������ 1��ʾ���� 2��ʾ����
		int chessArray1[][] = new int[11][11];
		chessArray1[1][2] = 1;
		chessArray1[2][3] = 2;

		// ���ԭʼ�Ķ�ά����
		System.out.println("ԭʼ��ά����:");
		for (int[] row : chessArray1) {
			for (int data : row) {
				System.out.printf("%d\t", data);
			}
			System.out.println();
		}

		// ����ά���� ת����  ϡ������

		// 1.�ȱ�����ά���飬�õ���ЧԪ�صĸ���
		int sum = 0;
		for (int i = 0; i < 11; i++) {
			for (int j = 0; j < 11; j++) {
				if (chessArray1[i][j] != 0) {
					sum += 1;
				}
			}
		}
		// 2.������Ӧ��ϡ������
		int sparseArray[][] = new int[sum + 1][3];

		//��ϡ�������һ��(��ͷ)��ֵ
		sparseArray[0][0] = 11;
		sparseArray[0][1] = 11;
		sparseArray[0][2] = sum;

		//������ά���飬����0Ԫ�ش���ϡ������
		int count = 0;
		for (int i = 0; i < 11; i++) {
			for (int j = 0; j < 11; j++) {
				if (chessArray1[i][j] != 0) {
					count++;
					sparseArray[count][0] = i;
					sparseArray[count][1] = j;
					sparseArray[count][2] = chessArray1[i][j];
				}
			}
		}
		// ���ϡ������
		System.out.println();
		System.out.println("�õ���ϡ������Ϊ:");
		for (int i = 0; i < sparseArray.length; i++) {
			System.out.printf("%d\t%d\t%d\t\n", sparseArray[i][0], sparseArray[i][1], sparseArray[i][2]);
		}
		System.out.println();

		// ��ϡ������ ת���� ��ά����
		/**
		 *
		 ϡ������ ת ��ά���� ��˼·��
		 IO �ȶ�ȡϡ������ĵ�һ�У����ݵ�һ�е����ݣ�����ԭʼ�Ķ�ά���飬���������  chessArr2 = int[11][11]
		 2. �ڶ�ȡϡ��������е����飬������ ԭʼ�Ķ�ά���� ����
		 */
		int row = sparseArray[0][0];
		int col = sparseArray[0][1];

		int chessArray2[][] = new int[row][col];
		for (int i = 1; i < sparseArray.length; i++) {
			chessArray2[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
		}

		System.out.println("ת����Ķ�ά���飺");
		for (int[] row2 : chessArray2) {
			for (int data : row2) {
				System.out.printf("%d\t", data);
			}
			System.out.println();
		}

		System.out.println();

		System.out.println("ioд��ϡ������");
		saveToFile(sparseArray);
		System.out.println("д��ɹ�!");
		System.out.println();

		System.out.println("��ȡϡ�������ļ�");
		int sparseArray2[][] = readFromFile("./DataStructures/mdp.data");
		for (int i = 0; i < sparseArray.length; i++) {
			System.out.printf("%d\t%d\t%d\t\n", sparseArray[i][0], sparseArray[i][1], sparseArray[i][2]);
		}
		System.out.println();
	}

	// �κ���ϰ����ϡ������浽�ļ��� mdp.data

	/**
	 * ��ϡ������д������ļ�
	 *
	 * @param sparseArray
	 */
	public static void saveToFile(int[][] sparseArray) {
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(new File("./DataStructures/mdp.data"));
			for (int[] array : sparseArray) {
				fileWriter.write(array[0] + "\t" + array[1] + "\t" + array[2]);
				fileWriter.write("\r\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fileWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * �Ӵ����ж���ϡ�������ļ�����ת���ɶ�ά����
	 *
	 * @return
	 */
	public static int[][] readFromFile(String filepath) {
		int[][] sparseArray2 = null;
		boolean isNotRead = false;
		BufferedReader bufferedReader = null;
		try {
			bufferedReader = new BufferedReader(new FileReader(new File(filepath)));
			String lineStr = null;
			int curCount = 0;
			while ((lineStr = bufferedReader.readLine()) != null) {
				String[] tempStr = lineStr.split("\t");
				if (!isNotRead) {
					sparseArray2 = new int[Integer.parseInt(tempStr[2]) + 1][3];
					sparseArray2[curCount][0] = Integer.parseInt(tempStr[0]);
					sparseArray2[curCount][1] = Integer.parseInt(tempStr[1]);
					sparseArray2[curCount][2] = Integer.parseInt(tempStr[2]);
					curCount++;
					isNotRead = true;
				} else {
					sparseArray2[curCount][0] = Integer.parseInt(tempStr[0]);
					sparseArray2[curCount][1] = Integer.parseInt(tempStr[1]);
					sparseArray2[curCount][2] = Integer.parseInt(tempStr[2]);
					curCount++;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bufferedReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return sparseArray2;
	}

}
