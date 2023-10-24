package Algorithm.test;

import java.util.Scanner;
import java.util.LinkedList;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int x = in.nextInt();
		int y = in.nextInt();
		//初始化一个链表,随机模拟几个元素
		LinkedList<Integer> linklist = new LinkedList<>();
		linklist.add(0);
		linklist.add(3);
		linklist.add(2);
		insertXY(x,y,linklist);
		delete(x,linklist);

	}

	public  static  void insertXY(int x, int y, LinkedList<Integer> linklist) {
		int count = 0;
		for (int i : linklist) {
			if (linklist.contains(x)) {
				if (i == x) {
					count++;
					if (count == 1) {
						int index = linklist.indexOf(i);
						linklist.add(index, y);
					}
				}
			}
			linklist.addLast(y);
		}
	}
	public static void delete (int x, LinkedList<Integer> linklist) {
		int count = 0;
		for (int i : linklist) {
			if (i == x) {
				count++;
				if (count == 1) {
					int index = linklist.indexOf(i);
					linklist.remove(index);
				}
			}
		}
		System.out.println(linklist);
	}
}