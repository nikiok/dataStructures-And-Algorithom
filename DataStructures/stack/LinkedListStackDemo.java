package Algorithm.DataStructures.stack;

import java.util.Scanner;

/**
 * -----------------------------------------------
 *
 * @author ��niki
 * @date ��Created in 2023/10/15 9:06
 * @description������ģ������
 * @version: $
 * -----------------------------------------------
 */
public class LinkedListStackDemo {
	public static void main(String[] args) {
		//����
		//������������ʵ�ֵ�ջ
		NodeStack linkedListStack = new NodeStack();
		String key = "";//���������û�������
		boolean loop = true;//�����Ƿ��˳��˵�
		Scanner input = new Scanner(System.in);
		while(loop) {
			System.out.println();
			System.out.println("show:��ʾ��ʾջ��");
			System.out.println("exit:�˳�����");
			System.out.println("push:��ʾ������ݵ�ջ(��ջ)��");
			System.out.println("pop:��ʾ��ջ��ȡ������(��ջ)��");

			System.out.println("���������ѡ��~~~");
			key = input.next();
			switch(key) {
				case "show":
					linkedListStack.list();
					break;
				case "push":
					System.out.println("����������");
					String value = input.next();
					Node node = new Node(value);
					linkedListStack.push(node);
					break;
				case "pop":
					try {
						Node res = linkedListStack.pop();
						System.out.println("��ջ�Ľڵ��ǣ�"+res);
					}catch(Exception e){
						//�����һ����ջ
						System.out.println(e.getMessage());
					}
					break;
				case "exit":
					input.close();
					loop = false;
					break;
				default:
					break;
			}
		}
		System.out.println("�����˳�������");
	}
}

/**
 * ������ģ��ջ˼·
 * 		1.ʹ�õ���������ģ��ջ
 *      2.�����ڵ��࣬����һ��topָ���ʾջ������ʼ��Ϊnull
 *      3.��ջ�������������ݼ��뵽ջ��ʱ�����ڵ���ӵ��������󣬲���topָ��ָ������ڵ�
 *      4.��ջ�������������ݳ�ջʱ�������Ľڵ��ջ(�����Ľڵ��������ɾ��)������topָ�����ڵ��ǰһ���ڵ�
 *      5.������ջ�ı������Ƚ���������������Ƚ��ȳ�������Ҫ�Ƚ�������з�ת��Ȼ���ٴ�ӡ����ʵ��ջ�ı���
 */
class NodeStack{
	// �ȳ�ʼ��һ��ͷ��㣬ͷ��㲻��
	private Node head = new Node("");
	//����һ���ڵ㣬����ջ����ָ�ڵ�
	private Node top = null;

	public Node getHead(){
		return head;
	}

//	//ջ��
//	public boolean isFull(){
//		return top == maxSize;
//	}

	//ջ��
	public boolean isEmpty(){
		return top == null;
	}

	//��ջ
	public void push(Node node){
		Node temp = head;
		while (true){
			if (temp.next == null){
				break;
			}
			temp = temp.next;
		}
		temp.next = node;
		top = node;
	}

	//��ջ
	public Node pop(){
		//��topָ��ָ��Ľڵ��ջ
		//��Ϊ��ջ��topָ����Ҫ��ǰ�ƶ���������Ҫһ������ָ����ɳ�ջ
		Node tmp = top;
		//��topָ����ǰ�ƶ�һ��
		//��Ҫ���±��������ҵ�top�ڵ��ǰһ���ڵ㣬����topָ��ָ������ڵ�
		Node h = head;
		while(true) {
			//�ҵ�top�ڵ��ǰһ���ڵ�
			if(h.next == top) {
				//˵���ҵ�������ڵ�
				break;
			}
			//������ǣ���ָ������ƶ�
			h = h.next;
		}
		//�˳�ѭ�����ҵ�top�ڵ��ǰһ���ڵ㣬��top�ڵ����ɾ��
		h.next = top.next;
		//��topָ��ָ������ڵ�,���topָ���ǰ�ƶ���
		top = h;
		return tmp;
	}
	//��ʾջ
	public void list(){
		// �ж������Ƿ�Ϊ��
		if (head.next == null) {
			System.out.println("����Ϊ�գ�����");
			return;
		}
		// ��Ϊͷ��㲻�ܶ�����Ҫ��������������
		reverse(head);
		Node temp = head.next;
		while (true) {
			// �ж��Ƿ��������
			if (temp == null) {
				break;
			}
			// ����ڵ���Ϣ
			System.out.println(temp);
			// ��temp����
			temp = temp.next;
		}
		
	}
	//��ת����
	public void reverse(Node head){
		//�����ǰ����Ϊ�գ�����ֻ��һ���ڵ�,���跴ת��ֱ�ӷ���
		if (head.next == null || head.next.next == null){
			return;
		}
		// ����һ��������ָ��(����),��������ԭ��������
		Node cur = head.next;
		// ����һ�������洢��ǰ�ڵ���¸��ڵ㣬��ָ��ǰ�ڵ�[cur]���¸��ڵ�
		Node next = null;
		//����һ���������ͷ���
		Node reverseHead = new Node("");
		// ����ԭ��������ÿ����һ���ڵ�ͽ���ȡ�����������µ�����reverseHead����ǰ��
		while (cur != null) {
			// ��ʱ���浱ǰ�ڵ����һ���ڵ�(������Ҫʹ��)
			next = cur.next;
			// ��cur���¸��ڵ�ָ���µ��������ǰ��
			cur.next = reverseHead.next;
			// ��cur���ӵ��µ�������
			reverseHead.next = cur;
			// ��cur����
			cur = next;
		}
		// ��head.nextָ��reverseHead.next��ʵ�ֵ�����ķ�ת
		head.next = reverseHead.next;
	}
}
class Node{
	public String value;
	public Node next;
	public Node(String value){
		this.value = value;
		next = null;
	}
}