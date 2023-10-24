package Algorithm.LeeCodeTest;

import java.util.*;

/**
 * @author ��niki
 * @version :     $
 * @date ��Created in 2023/10/24 11:37
 * @description �� ��������
 */

public class leecode141 {

	public static void main(String[] args) {

	}
	/**
	 * �����������ʽڵ㷨
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
	 * ����ָ�뷨
	 * @param head
	 * @return
	 */
	public static boolean hasCycle(ListNode head) {

		if (head == null || head.next == null) {
			return false;
		}
		ListNode slow = head;  //��ָ��
		ListNode fast = head.next; //��ָ��
		while (slow != fast){
			if (fast == null || fast.next == null){
				return false;
			}
			slow = slow.next; //һ��
			fast = fast.next.next; //����
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
