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
		maze[4][3] = 1;
		maze[5][3] = 1;
		maze[6][5] = 1;

		//输出地图
		System.out.println("迷宫地图为");
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 7; j++) {
				System.out.print(maze[i][j] + " " );
			}
			System.out.println();
		}
		//使用递归方法给小球找路
		boolean flag = setWay(maze,1,1,6,5);
		if (flag){
			//小球走过并标识过的路
			System.out.println("小球走过并表标识的路");
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 7; j++) {
					System.out.print(maze[i][j] + " " );
				}
				System.out.println();
			}
		}else {
			System.out.println("终点不通或存在异常");
		}
	}

	//根据递归回溯来给小球找路

	/**
	 * 说明
	 * TODO:  约定
	 *  当map[i][j]为0 表示该点没有走过、
	 *  当为1表示为墙、
	 *  当为2表示可以走、
	 *  当为3表示走过但走不通
	 * @param map 地图
	 * @param i   出发的位置坐标（i,j）
	 * @param j
	 * @param m  目的地的坐标(m,n)
	 * @param n
	 * @return
	 */
	public static boolean setWay(int[][] map,int i ,int j,int m,int n){
		if (i < 0 || i > 7 || j < 0 || j > 6 ||m < 0 || m > 7 || n < 0 ||n > 6){
			System.out.println("终点或起点坐标设置错误！");
			return false;
		}
		if (map[m][n] == 2){//
			return true;
		}else {
			if (map[i][j] == 0){ //如果当前这个点还没有走过
				//按照策略下 -> 右 -> 上 ->左 的路线走
				map[i][j] =2; //假定该点是可以走通
				if (setWay(map,i+1,j,6,5)||setWay(map,i,j+1,6,5)||setWay(map,i-1,j,6,5)||setWay(map,i,j-1,6,5)){
					return true;
				}else {
					map[i][j] =3; //3表示思路
					return false;
				}

			}else {
				return false;
			}
		}
	}
}