package Algorithm.DataStructures.queue;


import java.util.Scanner;

/**
 * -----------------------------------------------
 *
 * @author ��niki
 * @date ��Created in 2023/10/5 14:49
 * @description�����ζ���
 * @version: $
 * -----------------------------------------------
 */
public class circleQueue {

	public static void main(String[] args) {
		CirCleArray cirCleArray = new CirCleArray(4);
		char key = ' ';
		Scanner scanner = new Scanner(System.in);
		boolean loop = true;
		while (loop){
			System.out.println("s(show): ��ʾ����");
			System.out.println("e(exit): �˳�����");
			System.out.println("a(add): ������ݵ�����");
			System.out.println("g(get): �Ӷ���ȡ������");
			System.out.println("h(head): �鿴����ͷ������");
			key = scanner.next().charAt(0);
			switch (key) {
				case 's':
					cirCleArray.showQueue();
					break;
				case 'a':
					System.out.println("����һ����");
					int value = scanner.nextInt();
					cirCleArray.addQueue(value);
					break;
				case 'g':
					try {
						int res = cirCleArray.getQueue();
						System.out.printf("ȡ������Ϊ��%d\n",res);
					}catch (Exception e){
						System.out.println(e.getMessage());
					}
					break;
				case 'h':
					try {
						int res = cirCleArray.headQueue();
						System.out.printf("����ͷ��������%d\n",res);
					}catch (Exception e){
						System.out.println(e.getMessage());
					}
					break;
				case 'e':
					scanner.close();
					loop = false;
					break;
				default:
					break;
			}
			System.out.println("�����˳�");
		}
	}

	static class CirCleArray{
		/** -----------------------------------------------
		* description: ʹ������ģ�⻷�ζ���
		* create time: 14:53 2023/10/5
		*    * @Param: null
		* @return
		----------------------------------------------- */
		private int maxSize; //��ʾ������������
		private int front; //����ͷ
		private int rear; //����β
		private  int[] arr; //���������ڴ�����ݣ�ģ�����

		public CirCleArray(int arrMaxSize){
			maxSize = arrMaxSize;
			arr = new int[maxSize];
		}

		//�ж��Ƿ���
		public boolean isFull(){
			return (rear + 1)%maxSize == front;
		}

		//�ж϶����Ƿ��
		public boolean isEmpty(){
			return rear == front;
		}

		public void addQueue(int n){
			if (isFull()){
				System.out.println("���������޷����������");
				return;
			}
			arr[rear] = n;
			rear = (rear + 1) % maxSize;
		}

		public int getQueue(){
			if (isEmpty()){
				throw new RuntimeException("���п�,�����ݿ�ȡ");
			}
			/**
			 *
			 *  1.�Ȱ�front��Ӧ��ֵ������һ����ʱ����
			 *  2.��front���ƣ�����ȡģ
			 *  3.����ʱ����ı�������
			 */
			int value = arr[front];
			front = (front + 1) % maxSize;
			return value;
		}
		
		public void showQueue(){
			if (isEmpty()){
				System.out.println("���п�");
				return;
			}
			for (int i = 0; i < front + size(); i++) {
				System.out.printf("arr[%d]=%d\n",i%maxSize,arr[i%maxSize]);
			}
		}

		// ��Ч���ݵĸ���
		public int size(){
//			return Math.abs(rear - front);
			return (rear + maxSize - front) % maxSize;
		}

		public int headQueue(){
			if (isEmpty()){
				throw new RuntimeException("���п�");
			}
			return arr[front];
		}

	}

}
