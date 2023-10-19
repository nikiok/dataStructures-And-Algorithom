package Algorithm.DataStructures.recursion;

/**
 * -----------------------------------------------
 *
 * @author ：niki
 * @date ：Created in 2023/10/18 10:43
 * @description：迷宫问题
 * @version: $
 * -----------------------------------------------
 */
public class migong {
	public static void main(String[] args) {
		int maze[][] = new int[8][7];
		//使用1表示墙
		//上下全布置为1
		for (int i = 0; i < 7 ; i++) {
			maze[0][i] = 1;
			maze[7][i] = 1;
		}
		//左右全布置为1
		for (int i = 0; i < 8;i++){
			maze[i][0] = 1;
			maze[i][6] = 1;
		}

		//设置挡板，1表示墙
		maze[3][1] = 1;
		maze[3][2] = 1;

		//输出地图
		System.out.println("迷宫地图为");
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 7; j++) {
				System.out.print(maze[i][j] + " " );
			}
			System.out.println();
		}
	}

	//根据递归回溯来给小球找路

	/**
	 * 说明
	 * TODO:  约定---当map[i][j]为0 表示该点没有走过、当为1表示为墙、
	 *  当为2表示可以走  ， 当为3表示走过但走不通
	 * @param map 地图
	 * @param i   出发的位置坐标（i,j）
	 * @param j
	 * @return
	 */
	public static boolean setWay(int[][] map,int i ,int j){
		return true;
	}
}