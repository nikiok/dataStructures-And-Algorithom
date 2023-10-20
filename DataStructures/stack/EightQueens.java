package Algorithm.DataStructures.stack;

/**
 * @author ：niki
 * @date ：Created in 2023/10/20 9:24
 * @description ： 八皇后问题，是一个古老而著名的问题，是回溯算法的典型案例。该问题是国际西洋棋棋手马克斯·贝瑟尔于
 * 1848年提出：在8×8格的国际象棋上摆放八个皇后，使其不能互相攻击，即：任意两个皇后都不能处于同一行、
 * 同一列或同一斜线上，问有多少种摆法(92)。
 * @version: $
 */
public class EightQueens {
	/**
	 * 理论上应该创建一个二维数组来表示棋盘，但是实际上可以通过算法，用一个一维数组即可解决间题.array[8]=
	 * {0,4,7,5,2,6,1,3},i对应arr下标表示第几行，即第几个皇后，arr[i]=val,val表示第i+1个皇后，放在第i+1
	 * 行的第val+1列
	 */

	int maxSize = 8; //表示有多少个皇后
	//定义数组，保存皇后的位置
	int array[] = new int[maxSize];
	static int count = 0; //统计解法次数

	public static void main(String[] args) {
		EightQueens eightQueens = new EightQueens();
		eightQueens.setQueens(0);
		System.out.printf("一共有%d种解法\n",count);

	}
	// 打印数组
	public void printSolution(){
		count++;
		for (int i = 0; i < array.length; i++) {
			System.out.printf(array[i] + " ");
		}
		System.out.println();
	}

	//查看我们放置第n个皇后，是否安全（判断是否于其他皇后相邻）
	public boolean isSafe(int n){
		for (int i = 0; i < n; i++) {
			//1.array[i] == array[n] ： 表示判断第n个皇后是否和第n-1个皇后在同一列
			//2. Math.abs(n-i) == Math.abs(array[n] - array[i]) 表示两个皇后在一条斜线
			if (array[i] == array[n] || Math.abs(n-i) == Math.abs(array[n] - array[i]) ){
				return false;
			}
		}
		return true;
	}

	//放置皇后
	public void setQueens(int n){
		if (n == maxSize){ // n = 8,8个皇后已经放完
			printSolution();
			return;
		}
		//依次放置皇后
		for (int i = 0; i < maxSize; i++) {
			//先将该皇后放置第一列
			array[n] = i;
			if (isSafe(n)){
				setQueens(n+1);
			}
		}
	}
}
