package Algorithm.DataStructures.recursion;

/**
 * -----------------------------------------------
 *
 * @author ��niki
 * @date ��Created in 2023/10/18 10:43
 * @description���Թ�����
 * @version: $
 * -----------------------------------------------
 */
public class migong {
	public static void main(String[] args) {
		int maze[][] = new int[8][7];
		//ʹ��1��ʾǽ
		//����ȫ����Ϊ1
		for (int i = 0; i < 7 ; i++) {
			maze[0][i] = 1;
			maze[7][i] = 1;
		}
		//����ȫ����Ϊ1
		for (int i = 0; i < 8;i++){
			maze[i][0] = 1;
			maze[i][6] = 1;
		}

		//���õ��壬1��ʾǽ
		maze[3][1] = 1;
		maze[3][2] = 1;

		//�����ͼ
		System.out.println("�Թ���ͼΪ");
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 7; j++) {
				System.out.print(maze[i][j] + " " );
			}
			System.out.println();
		}
	}

	//���ݵݹ��������С����·

	/**
	 * ˵��
	 * TODO:  Լ��---��map[i][j]Ϊ0 ��ʾ�õ�û���߹�����Ϊ1��ʾΪǽ��
	 *  ��Ϊ2��ʾ������  �� ��Ϊ3��ʾ�߹����߲�ͨ
	 * @param map ��ͼ
	 * @param i   ������λ�����꣨i,j��
	 * @param j
	 * @return
	 */
	public static boolean setWay(int[][] map,int i ,int j){
		return true;
	}
}