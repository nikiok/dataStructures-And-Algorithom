package Algorithm.DataStructures.queue;


import java.util.Scanner;

/**
 * -----------------------------------------------
 *
 * @author ：niki
 * @date ：Created in 2023/10/5 14:49
 * @description：环形队列
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
			System.out.println("s(show): 显示队列");
			System.out.println("e(exit): 退出程序");
			System.out.println("a(add): 添加数据到队列");
			System.out.println("g(get): 从队列取出数据");
			System.out.println("h(head): 查看队列头的数据");
			key = scanner.next().charAt(0);
			switch (key) {
				case 's':
					cirCleArray.showQueue();
					break;
				case 'a':
					System.out.println("输入一个数");
					int value = scanner.nextInt();
					cirCleArray.addQueue(value);
					break;
				case 'g':
					try {
						int res = cirCleArray.getQueue();
						System.out.printf("取出数据为：%d\n",res);
					}catch (Exception e){
						System.out.println(e.getMessage());
					}
					break;
				case 'h':
					try {
						int res = cirCleArray.headQueue();
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

	static class CirCleArray{
		/** -----------------------------------------------
		* description: 使用数组模拟环形队列
		* create time: 14:53 2023/10/5
		*    * @Param: null
		* @return
		----------------------------------------------- */
		private int maxSize; //表示数组的最大容量
		private int front; //队列头
		private int rear; //队列尾
		private  int[] arr; //该数据用于存放数据，模拟队列

		public CirCleArray(int arrMaxSize){
			maxSize = arrMaxSize;
			arr = new int[maxSize];
		}

		//判断是否满
		public boolean isFull(){
			return (rear + 1)%maxSize == front;
		}

		//判断队列是否空
		public boolean isEmpty(){
			return rear == front;
		}

		public void addQueue(int n){
			if (isFull()){
				System.out.println("队列满，无法在添加数据");
				return;
			}
			arr[rear] = n;
			rear = (rear + 1) % maxSize;
		}

		public int getQueue(){
			if (isEmpty()){
				throw new RuntimeException("队列空,无数据可取");
			}
			/**
			 *
			 *  1.先把front对应的值保留到一个临时变量
			 *  2.把front后移，考虑取模
			 *  3.将临时保存的变量返回
			 */
			int value = arr[front];
			front = (front + 1) % maxSize;
			return value;
		}
		
		public void showQueue(){
			if (isEmpty()){
				System.out.println("队列空");
				return;
			}
			for (int i = 0; i < front + size(); i++) {
				System.out.printf("arr[%d]=%d\n",i%maxSize,arr[i%maxSize]);
			}
		}

		// 有效数据的个数
		public int size(){
//			return Math.abs(rear - front);
			return (rear + maxSize - front) % maxSize;
		}

		public int headQueue(){
			if (isEmpty()){
				throw new RuntimeException("队列空");
			}
			return arr[front];
		}

	}

}
