package Algorithm.DataStructures.stack;

import java.util.Scanner;

/**
 * -----------------------------------------------
 *
 * @author ��niki
 * @date ��Created in 2023/10/15 8:36
 * @description������ģ��ջ�Ĳ���
 * @version: $
 * -----------------------------------------------
 */
public class ArrayStackDemo {
	public static void main(String[] args) {
		ArrayStack arrayStack = new ArrayStack(5);
		Scanner sc = new Scanner(System.in);
		String key = "";
		boolean loop = true; //�Ƿ��˳��˵�

		while(loop){
			System.out.println("s: ��ʾջ������Ԫ��");
			System.out.println("e: �˳���ǰ����");
			System.out.println("a: ������ݵ�ջ(��ջ)");
			System.out.println("d:  ��ջȡ������(��ջ)");
			System.out.println("���������ѡ��");
			key = sc.next();
			switch (key){
				case "s":
					arrayStack.list();
					break;
				case "a":
					System.out.println("������Ҫ��ջ�����ݣ�");
					arrayStack.push(sc.nextInt());
					break;
				case "d":
					try{
						int res = arrayStack.pop();
						System.out.printf("��ջ�������� %d\n",res);
					}catch (Exception e){
						System.out.println(e.getMessage());
					}
					break;

				case "e":
					sc.close();
					loop = false;
					break;
				default:
					break;
			}
		}
		System.out.println("�˳���ǰ����~~~~~~~~");
	}
}
class ArrayStack{
	private int maxSize; //ջ�Ĵ�С
	private int[] stack; //���飬����ģ��ջ�����ݾͷ��ڸ�����
	private int top = -1; //topΪջ������ʼ��Ϊ-1

	//������
	public ArrayStack(int maxSize){
		this.maxSize = maxSize;
		stack = new int[this.maxSize];
	}

	//ջ��
	public boolean isFull(){
		return top == maxSize - 1;
	}

	//ջ��
	public boolean isEmpty(){
		return  top == -1;
	}

	//��ջ - push
	public void push(int value){
		if (isFull()){
			System.out.println("ջ��");
			return;
		}
		stack[++top] = value;
	}
	//��ջ - pop
	public int pop(){
		if (isEmpty()){
			//�׳��쳣
			throw  new RuntimeException("ջ��,������");
		}
		int value = stack[top];
		top--;
		return value;
	}
	//��ʾջ
	/**
	 * todo: �������飬��ջ����ʼ��ʾ����
	 */
	public void list(){
		if (isEmpty()){
			throw new RuntimeException("ջ��");
		}
		for (int i = top; i >= 0; i--) {
			System.out.printf("%d\n",stack[i]);
		}
	}
}
