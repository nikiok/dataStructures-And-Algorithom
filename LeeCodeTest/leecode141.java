package Algorithm.LeeCodeTest;

import java.util.*;

/**
 * @author ：niki
 * @version :     $
 * @date ：Created in 2023/10/24 11:37
 * @description ： 环形链表
 */

public class leecode141 {

	public static void main(String[] args) {

	}
	/**
	 * 遍历链表，访问节点法
	 * @param head
	 * @return
	 */
	public static boolean hasCycle2(ListNode head){
			if (head == null || head.next == null){
				return false;
			}
			Set<ListNode> set = new HashSet<>();
			while (head != null){
				if (!set.add(head)) return true;
				head = head.next;
			}
			return false;
		}

	/**
	 * 快慢指针法
	 * @param head
	 * @return
	 */
	public static boolean hasCycle(ListNode head) {

		if (head == null || head.next == null) {
			return false;
		}
		ListNode slow = head;  //慢指针
		ListNode fast = head.next; //快指针
		while (slow != fast){
			if (fast == null || fast.next == null){
				return false;
			}
			slow = slow.next; //一步
			fast = fast.next.next; //两步
		}
		return true;
	}


	class ListNode{
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

}
