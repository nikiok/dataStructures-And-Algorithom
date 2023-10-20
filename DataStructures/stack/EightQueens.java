package Algorithm.DataStructures.stack;

/**
 * @author ��niki
 * @date ��Created in 2023/10/20 9:24
 * @description �� �˻ʺ����⣬��һ�����϶����������⣬�ǻ����㷨�ĵ��Ͱ������������ǹ����������������˹����ɪ����
 * 1848���������8��8��Ĺ��������ϰڷŰ˸��ʺ�ʹ�䲻�ܻ��๥�����������������ʺ󶼲��ܴ���ͬһ�С�
 * ͬһ�л�ͬһб���ϣ����ж����ְڷ�(92)��
 * @version: $
 */
public class EightQueens {
	/**
	 * ������Ӧ�ô���һ����ά��������ʾ���̣�����ʵ���Ͽ���ͨ���㷨����һ��һά���鼴�ɽ������.array[8]=
	 * {0,4,7,5,2,6,1,3},i��Ӧarr�±��ʾ�ڼ��У����ڼ����ʺ�arr[i]=val,val��ʾ��i+1���ʺ󣬷��ڵ�i+1
	 * �еĵ�val+1��
	 */

	int maxSize = 8; //��ʾ�ж��ٸ��ʺ�
	//�������飬����ʺ��λ��
	int array[] = new int[maxSize];
	static int count = 0; //ͳ�ƽⷨ����

	public static void main(String[] args) {
		EightQueens eightQueens = new EightQueens();
		eightQueens.setQueens(0);
		System.out.printf("һ����%d�ֽⷨ\n",count);

	}
	// ��ӡ����
	public void printSolution(){
		count++;
		for (int i = 0; i < array.length; i++) {
			System.out.printf(array[i] + " ");
		}
		System.out.println();
	}

	//�鿴���Ƿ��õ�n���ʺ��Ƿ�ȫ���ж��Ƿ��������ʺ����ڣ�
	public boolean isSafe(int n){
		for (int i = 0; i < n; i++) {
			//1.array[i] == array[n] �� ��ʾ�жϵ�n���ʺ��Ƿ�͵�n-1���ʺ���ͬһ��
			//2. Math.abs(n-i) == Math.abs(array[n] - array[i]) ��ʾ�����ʺ���һ��б��
			if (array[i] == array[n] || Math.abs(n-i) == Math.abs(array[n] - array[i]) ){
				return false;
			}
		}
		return true;
	}

	//���ûʺ�
	public void setQueens(int n){
		if (n == maxSize){ // n = 8,8���ʺ��Ѿ�����
			printSolution();
			return;
		}
		//���η��ûʺ�
		for (int i = 0; i < maxSize; i++) {
			//�Ƚ��ûʺ���õ�һ��
			array[n] = i;
			if (isSafe(n)){
				setQueens(n+1);
			}
		}
	}
}
