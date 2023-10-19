package Algorithm.DataStructures.stack;

import java.util.Scanner;

/**
 * -----------------------------------------------
 *
 * @author ：niki
 * @date ：Created in 2023/10/15 8:36
 * @description：数组模拟栈的操作
 * @version: $
 * -----------------------------------------------
 */
public class ArrayStackDemo {
	public static void main(String[] args) {
		ArrayStack arrayStack = new ArrayStack(5);
		Scanner sc = new Scanner(System.in);
		String key = "";
		boolean loop = true; //是否退出菜单

		while(loop){
			System.out.println("s: 显示栈中所有元素");
			System.out.println("e: 退出当前程序");
			System.out.println("a: 添加数据到栈(入栈)");
			System.out.println("d:  从栈取出数据(出栈)");
			System.out.println("请输入你的选择");
			key = sc.next();
			switch (key){
				case "s":
					arrayStack.list();
					break;
				case "a":
					System.out.println("请输入要入栈的数据：");
					arrayStack.push(sc.nextInt());
					break;
				case "d":
					try{
						int res = arrayStack.pop();
						System.out.printf("出栈的数据是 %d\n",res);
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
		System.out.println("退出当前程序~~~~~~~~");
	}
}
class ArrayStack{
	private int maxSize; //栈的大小
	private int[] stack; //数组，数组模拟栈，数据就放在该数组
	private int top = -1; //top为栈顶，初始化为-1

	//构造器
	public ArrayStack(int maxSize){
		this.maxSize = maxSize;
		stack = new int[this.maxSize];
	}

	//栈满
	public boolean isFull(){
		return top == maxSize - 1;
	}

	//栈空
	public boolean isEmpty(){
		return  top == -1;
	}

	//入栈 - push
	public void push(int value){
		if (isFull()){
			System.out.println("栈满");
			return;
		}
		stack[++top] = value;
	}
	//出栈 - pop
	public int pop(){
		if (isEmpty()){
			//抛出异常
			throw  new RuntimeException("栈空,无数据");
		}
		int value = stack[top];
		top--;
		return value;
	}
	//显示栈
	/**
	 * todo: 遍历数组，从栈顶开始显示数据
	 */
	public void list(){
		if (isEmpty()){
			throw new RuntimeException("栈空");
		}
		for (int i = top; i >= 0; i--) {
			System.out.printf("%d\n",stack[i]);
		}
	}
}
