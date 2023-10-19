package Algorithm.DataStructures.stack;

import java.util.Scanner;

/**
 * -----------------------------------------------
 *
 * @author ：niki
 * @date ：Created in 2023/10/15 9:06
 * @description：链表模拟数组
 * @version: $
 * -----------------------------------------------
 */
public class LinkedListStackDemo {
	public static void main(String[] args) {
		//测试
		//创建单向链表实现的栈
		NodeStack linkedListStack = new NodeStack();
		String key = "";//用来接收用户的输入
		boolean loop = true;//控制是否退出菜单
		Scanner input = new Scanner(System.in);
		while(loop) {
			System.out.println();
			System.out.println("show:表示显示栈！");
			System.out.println("exit:退出程序！");
			System.out.println("push:表示添加数据到栈(入栈)！");
			System.out.println("pop:表示从栈中取出数据(出栈)！");

			System.out.println("请输入你的选择~~~");
			key = input.next();
			switch(key) {
				case "show":
					linkedListStack.list();
					break;
				case "push":
					System.out.println("请输入数据");
					String value = input.next();
					Node node = new Node(value);
					linkedListStack.push(node);
					break;
				case "pop":
					try {
						Node res = linkedListStack.pop();
						System.out.println("出栈的节点是："+res);
					}catch(Exception e){
						//如果是一个空栈
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
		System.out.println("程序退出！！！");
	}
}

/**
 * 单链表模拟栈思路
 * 		1.使用单向链表来模拟栈
 *      2.创建节点类，创建一个top指针表示栈顶，初始化为null
 *      3.入栈操作：当有数据加入到栈中时，将节点添加到链表的最后，并将top指针指向这个节点
 *      4.出栈操作：当有数据出栈时，将最后的节点出栈(将最后的节点从链表中删除)，并将top指向最后节点的前一个节点
 *      5.遍历：栈的遍历是先进后出，而链表是先进先出，所以要先将链表进行反转，然后再打印，来实现栈的遍历
 */
class NodeStack{
	// 先初始化一个头结点，头结点不动
	private Node head = new Node("");
	//定义一个节点，代表栈顶所指节点
	private Node top = null;

	public Node getHead(){
		return head;
	}

//	//栈满
//	public boolean isFull(){
//		return top == maxSize;
//	}

	//栈空
	public boolean isEmpty(){
		return top == null;
	}

	//入栈
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

	//出栈
	public Node pop(){
		//将top指针指向的节点出栈
		//因为出栈后，top指针需要向前移动，所以需要一个辅助指针完成出栈
		Node tmp = top;
		//将top指针向前移动一个
		//需要重新遍历链表找到top节点的前一个节点，再由top指针指向这个节点
		Node h = head;
		while(true) {
			//找到top节点的前一个节点
			if(h.next == top) {
				//说明找到了这个节点
				break;
			}
			//如果不是，则指针向后移动
			h = h.next;
		}
		//退出循环后，找到top节点的前一个节点，对top节点进行删除
		h.next = top.next;
		//将top指针指向这个节点,完成top指针的前移动作
		top = h;
		return tmp;
	}
	//显示栈
	public void list(){
		// 判断链表是否为空
		if (head.next == null) {
			System.out.println("链表为空！！！");
			return;
		}
		// 因为头结点不能动，需要辅助变量来遍历
		reverse(head);
		Node temp = head.next;
		while (true) {
			// 判断是否到链表最后
			if (temp == null) {
				break;
			}
			// 输出节点信息
			System.out.println(temp);
			// 将temp后移
			temp = temp.next;
		}
		
	}
	//反转链表
	public void reverse(Node head){
		//如果当前链表为空，或者只有一个节点,无需反转，直接返回
		if (head.next == null || head.next.next == null){
			return;
		}
		// 定义一个辅助的指针(变量),帮助遍历原来的链表
		Node cur = head.next;
		// 定义一个变量存储当前节点的下个节点，即指向当前节点[cur]的下个节点
		Node next = null;
		//定义一个新链表的头结点
		Node reverseHead = new Node("");
		// 遍历原来的链表，每遍历一个节点就将其取出，并放在新的链表reverseHead的最前端
		while (cur != null) {
			// 暂时保存当前节点的下一个节点(后续需要使用)
			next = cur.next;
			// 将cur的下个节点指向新的链表的最前端
			cur.next = reverseHead.next;
			// 将cur连接到新的链表上
			reverseHead.next = cur;
			// 让cur后移
			cur = next;
		}
		// 将head.next指向reverseHead.next，实现单链表的反转
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