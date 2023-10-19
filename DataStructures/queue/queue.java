package Algorithm.DataStructures.queue;

import java.util.Scanner;

/**
 * -----------------------------------------------
 *
 * @author ��niki
 * @date ��Created in 2023/10/4 21:41
 * @description�� ����
 * @version: $
 * -----------------------------------------------
 */
public class queue {
	public static void main(String[] args) {
		ArrayQueue arrayQueue = new ArrayQueue(4);
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
					arrayQueue.showQueue();
					break;
				case 'a':
					System.out.println("����һ����");
					int value = scanner.nextInt();
					arrayQueue.addQueue(value);
					break;
				case 'g':
					try {
						int res = arrayQueue.getQueue();
						System.out.printf("ȡ������Ϊ��%d\n",res);
					}catch (Exception e){
						System.out.println(e.getMessage());
					}
					break;
				case 'h':
					try {
						int res = arrayQueue.headQueue();
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

	//ʹ������ģ�����
	static class ArrayQueue{
		private int maxSize; //��ʾ������������
		private int front; //����ͷ
		private int rear; //����β
		private  int[] arr; //���������ڴ�����ݣ�ģ�����

		//�������еĹ�����
		public ArrayQueue(int arrMaxSize){
			maxSize = arrMaxSize;
			arr = new int[maxSize];
			front = -1 ; //ָ�����ͷ����������frontʦָ�����ͷ��ǰһ��λ��
			rear = -1 ;  //ָ�����β��ָ�����β������
		}

		//�ж϶����Ƿ���
		public boolean isFull(){
			return rear == maxSize - 1;
		}

		//�ж϶����Ƿ�Ϊ��
		public boolean isEmpty(){
			return rear == front;
		}

		//������ݵ�����
		public void addQueue(int n){
			if (isFull()){
				System.out.println("�����������ܼ�������~");
				return;
			}
			rear++; //��rear����
			arr[rear] = n;
		}

		//��ȡ���е����ݣ�������
		public int getQueue() {
			if (isEmpty()){
				//ͨ���׳��쳣
				throw new RuntimeException("���пգ�����ȡ����");
//				System.out.println("����Ϊ�գ���������");
			}
			front++;
			return arr[front];
		}

		//��ʾ���е���������
		public void showQueue(){
			if (isEmpty()){
				System.out.println("���пգ���������");
				return;
			}
			for (int i = 0; i < maxSize; i++) {
				System.out.printf("arr[%d]=%d\n",i,arr[i]);
			}
		}

		//��ʾ���е�ͷ����
		public int headQueue(){
			if (isEmpty()){
				throw new RuntimeException("���п�");
			}
			return arr[front+1];
		}
	}


}
