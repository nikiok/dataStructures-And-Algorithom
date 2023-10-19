package Algorithm.DataStructures.queue;

import java.util.Scanner;

/**
 * -----------------------------------------------
 *
 * @author ：niki
 * @date ：Created in 2023/10/4 21:41
 * @description： 队列
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
			System.out.println("s(show): 显示队列");
			System.out.println("e(exit): 退出程序");
			System.out.println("a(add): 添加数据到队列");
			System.out.println("g(get): 从队列取出数据");
			System.out.println("h(head): 查看队列头的数据");
			key = scanner.next().charAt(0);
			switch (key) {
				case 's':
					arrayQueue.showQueue();
					break;
				case 'a':
					System.out.println("输入一个数");
					int value = scanner.nextInt();
					arrayQueue.addQueue(value);
					break;
				case 'g':
					try {
						int res = arrayQueue.getQueue();
						System.out.printf("取出数据为：%d\n",res);
					}catch (Exception e){
						System.out.println(e.getMessage());
					}
					break;
				case 'h':
					try {
						int res = arrayQueue.headQueue();
						System.out.printf("队列头的数据是%d\n",res);
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
			System.out.println("程序退出");
		}
	}

	//使用数组模拟队列
	static class ArrayQueue{
		private int maxSize; //表示数组的最大容量
		private int front; //队列头
		private int rear; //队列尾
		private  int[] arr; //该数据用于存放数据，模拟队列

		//创建队列的构造器
		public ArrayQueue(int arrMaxSize){
			maxSize = arrMaxSize;
			arr = new int[maxSize];
			front = -1 ; //指向队列头部，分析出front师指向队列头的前一个位置
			rear = -1 ;  //指向队列尾，指向队列尾的数据
		}

		//判断队列是否满
		public boolean isFull(){
			return rear == maxSize - 1;
		}

		//判断队列是否为空
		public boolean isEmpty(){
			return rear == front;
		}

		//添加数据到队列
		public void addQueue(int n){
			if (isFull()){
				System.out.println("队列满，不能加入数据~");
				return;
			}
			rear++; //让rear后移
			arr[rear] = n;
		}

		//获取队列的数据，出队列
		public int getQueue() {
			if (isEmpty()){
				//通过抛出异常
				throw new RuntimeException("队列空，不能取数据");
//				System.out.println("队列为空，暂无数据");
			}
			front++;
			return arr[front];
		}

		//显示队列的所有数据
		public void showQueue(){
			if (isEmpty()){
				System.out.println("队列空，暂无数据");
				return;
			}
			for (int i = 0; i < maxSize; i++) {
				System.out.printf("arr[%d]=%d\n",i,arr[i]);
			}
		}

		//显示队列的头数据
		public int headQueue(){
			if (isEmpty()){
				throw new RuntimeException("队列空");
			}
			return arr[front+1];
		}
	}


}
