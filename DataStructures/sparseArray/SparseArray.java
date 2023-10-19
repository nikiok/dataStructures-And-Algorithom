package Algorithm.DataStructures.sparseArray;

import java.io.*;

/**
 * -----------------------------------------------
 *
 * @author ：niki
 * @date ：Created in 2023/10/2 10:08
 * @description： 稀疏数组  <--->  二维数组
 * @version: $
 * -----------------------------------------------
 */
public class SparseArray {
	public static void main(String[] args) {
		//创建一个原始的二维数组
		// 0: 表示没有棋子 1表示黑子 2表示白子
		int chessArray1[][] = new int[11][11];
		chessArray1[1][2] = 1;
		chessArray1[2][3] = 2;

		// 输出原始的二维数组
		System.out.println("原始二维数组:");
		for (int[] row : chessArray1) {
			for (int data : row) {
				System.out.printf("%d\t", data);
			}
			System.out.println();
		}

		// 将二维数组 转化成  稀疏数组

		// 1.先编历二维数组，得到有效元素的个数
		int sum = 0;
		for (int i = 0; i < 11; i++) {
			for (int j = 0; j < 11; j++) {
				if (chessArray1[i][j] != 0) {
					sum += 1;
				}
			}
		}
		// 2.创建对应的稀疏数组
		int sparseArray[][] = new int[sum + 1][3];

		//给稀疏数组第一行(表头)赋值
		sparseArray[0][0] = 11;
		sparseArray[0][1] = 11;
		sparseArray[0][2] = sum;

		//遍历二维数组，将非0元素存入稀疏数组
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
		// 输出稀疏数组
		System.out.println();
		System.out.println("得到的稀疏数组为:");
		for (int i = 0; i < sparseArray.length; i++) {
			System.out.printf("%d\t%d\t%d\t\n", sparseArray[i][0], sparseArray[i][1], sparseArray[i][2]);
		}
		System.out.println();

		// 将稀疏数组 转化成 二维数组
		/**
		 *
		 稀疏数组 转 二维数组 的思路：
		 IO 先读取稀疏数组的第一行，根据第一行的数据，创建原始的二维数组，比如上面的  chessArr2 = int[11][11]
		 2. 在读取稀疏数组后几行的数组，并赋给 原始的二维数组 即可
		 */
		int row = sparseArray[0][0];
		int col = sparseArray[0][1];

		int chessArray2[][] = new int[row][col];
		for (int i = 1; i < sparseArray.length; i++) {
			chessArray2[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
		}

		System.out.println("转化后的二维数组：");
		for (int[] row2 : chessArray2) {
			for (int data : row2) {
				System.out.printf("%d\t", data);
			}
			System.out.println();
		}

		System.out.println();

		System.out.println("io写入稀疏数组");
		saveToFile(sparseArray);
		System.out.println("写入成功!");
		System.out.println();

		System.out.println("读取稀疏数组文件");
		int sparseArray2[][] = readFromFile("./DataStructures/mdp.data");
		for (int i = 0; i < sparseArray.length; i++) {
			System.out.printf("%d\t%d\t%d\t\n", sparseArray[i][0], sparseArray[i][1], sparseArray[i][2]);
		}
		System.out.println();
	}

	// 课后练习，将稀疏数组存到文件中 mdp.data

	/**
	 * 将稀疏数组写入磁盘文件
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
	 * 从磁盘中读入稀疏数组文件，并转化成二维数组
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
