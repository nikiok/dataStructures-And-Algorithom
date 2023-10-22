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
		maze[4][3] = 1;
		maze[5][3] = 1;
		maze[6][5] = 1;

		//�����ͼ
		System.out.println("�Թ���ͼΪ");
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 7; j++) {
				System.out.print(maze[i][j] + " " );
			}
			System.out.println();
		}
		//ʹ�õݹ鷽����С����·
		boolean flag = setWay(maze,1,1,6,5);
		if (flag){
			//С���߹�����ʶ����·
			System.out.println("С���߹������ʶ��·");
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 7; j++) {
					System.out.print(maze[i][j] + " " );
				}
				System.out.println();
			}
		}else {
			System.out.println("�յ㲻ͨ������쳣");
		}
	}

	//���ݵݹ��������С����·

	/**
	 * ˵��
	 * TODO:  Լ��
	 *  ��map[i][j]Ϊ0 ��ʾ�õ�û���߹���
	 *  ��Ϊ1��ʾΪǽ��
	 *  ��Ϊ2��ʾ�����ߡ�
	 *  ��Ϊ3��ʾ�߹����߲�ͨ
	 * @param map ��ͼ
	 * @param i   ������λ�����꣨i,j��
	 * @param j
	 * @param m  Ŀ�ĵص�����(m,n)
	 * @param n
	 * @return
	 */
	public static boolean setWay(int[][] map,int i ,int j,int m,int n){
		if (i < 0 || i > 7 || j < 0 || j > 6 ||m < 0 || m > 7 || n < 0 ||n > 6){
			System.out.println("�յ������������ô���");
			return false;
		}
		if (map[m][n] == 2){//
			return true;
		}else {
			if (map[i][j] == 0){ //�����ǰ����㻹û���߹�
				//���ղ����� -> �� -> �� ->�� ��·����
				map[i][j] =2; //�ٶ��õ��ǿ�����ͨ
				if (setWay(map,i+1,j,6,5)||setWay(map,i,j+1,6,5)||setWay(map,i-1,j,6,5)||setWay(map,i,j-1,6,5)){
					return true;
				}else {
					map[i][j] =3; //3��ʾ˼·
					return false;
				}

			}else {
				return false;
			}
		}
	}
}