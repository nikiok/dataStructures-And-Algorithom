package Algorithm.LeeCodeTest;

/**
 * @author ：niki
 * @version :     $
 * @date ：Created in 2023/10/24 22:02
 * @description ： 两数相加
 */
public class leecode2 {
	public static void main(String[] args) {
		ListNode l1 = new ListNode(2); // 2 -> 4 -> 3
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(3);

		ListNode l2 = new ListNode(5); // 5 -> 6 -> 4
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);
		// 期望结果: 7 -> 0 -> 8

//		printList(addTwoNumbers(l1, l2));
		printList(addTwoNumbers(l1,l2));

	}
//
//	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//		return add(false, l1, l2);
//	}
//	/**
//	 * @param carry 是否进位
//	 * @param l1 节点
//	 * @param l2 节点
//	 * @return
//	 */
//	public static ListNode add(boolean carry, ListNode l1, ListNode l2) {
//		if (l1 == null && l2 == null && !carry) return null;
//		int a = l1 == null ? 0 : l1.val;
//		int b = l2 == null ? 0 : l2.val;
//		int sum = carry ? a + b + 1 : a + b;
//		return new ListNode(sum % 10 ,add(sum >= 10, l1 == null ? null: l1.next, l2 == null ? null : l2.next));
//	}
//	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//		/**
//		 * 思路：遍历两个链表，进行相加，将数值存入新的链表
//		 * 其中若链表相加后 sum值 >= 10，则采取进位制
//		 */
//		ListNode head = null; //头节点指针
//		ListNode tail = null; //新建节点指针
//		int carry = 0; // 存放进位数
//
//		while (l1 != null || l2 != null){ //遍历链表
//			//获取当前要进行相加的2个数
//			int n1 = l1 != null ? l1.val : 0;
//			int n2 = l2 != null ? l2.val : 0;
//			int sum = n1 + n2 + carry; //这里不能忘记加进位数，因为在第二次以上的遍历中需要考虑sum > 10的情况,即需要进一位
//			if (head == null){//第一次遍历时，即头节点为空；（可以理解为个位数计算）
//				head = new ListNode(sum % 10);//取余数 考虑sum>10
//				tail = new ListNode(sum % 10);
//			}else {//当二次以上遍历链表，此时头节点相当于个位数已进行计算并保存好，也不需要修改。
//				tail.next = new ListNode(sum % 10);
//				tail = tail.next; //添加新节点
//			}
//			carry = sum / 10; //进位数=和/10
//
//			if (l1 != null){
//				l1 = l1.next;  //后移
//			}
//			if (l2 != null){
//				l2 = l2.next; //后移
//			}
//		}
//
//		if (carry > 0){ //如果当前和 > 10,则需要进位
//			tail.next = new ListNode(carry); //添加进位数
//		}
//		return head;
//	}
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode head = null, tail = null;
		int carry = 0;
		while (l1 != null || l2 != null) {
			int n1 = l1 != null ? l1.val : 0;
			int n2 = l2 != null ? l2.val : 0;
			int sum = n1 + n2 + carry;
			if (head == null) {
				head = tail = new ListNode(sum % 10);
			} else {
				tail.next = new ListNode(sum % 10);
				tail = tail.next;
			}
			carry = sum / 10;
			if (l1 != null) {
				l1 = l1.next;
			}
			if (l2 != null) {
				l2 = l2.next;
			}
		}
		if (carry > 0) {
			tail.next = new ListNode(carry);
		}
		return head;
	}

	/**
	 * 输出结果
	 * @param head
	 */
	public static void printList(ListNode head) {
		while (head != null) {
			System.out.print(head.val + " -> ");
			head = head.next;
		}
		System.out.println("null");
	}

}
class ListNode {
	int val;
	ListNode next;
	ListNode() {}
	ListNode(int val) { this.val = val; }
	ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}