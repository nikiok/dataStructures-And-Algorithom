package Algorithm.LeeCodeTest;

/**
 * @author ��niki
 * @version :     $
 * @date ��Created in 2023/10/24 22:02
 * @description �� �������
 */
public class leecode2 {
	public static void main(String[] args) {
		ListNode l1 = new ListNode(2); // 2 -> 4 -> 3
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(3);

		ListNode l2 = new ListNode(5); // 5 -> 6 -> 4
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);
		// �������: 7 -> 0 -> 8

//		printList(addTwoNumbers(l1, l2));
		printList(addTwoNumbers(l1,l2));

	}
//
//	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//		return add(false, l1, l2);
//	}
//	/**
//	 * @param carry �Ƿ��λ
//	 * @param l1 �ڵ�
//	 * @param l2 �ڵ�
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
//		 * ˼·��������������������ӣ�����ֵ�����µ�����
//		 * ������������Ӻ� sumֵ >= 10�����ȡ��λ��
//		 */
//		ListNode head = null; //ͷ�ڵ�ָ��
//		ListNode tail = null; //�½��ڵ�ָ��
//		int carry = 0; // ��Ž�λ��
//
//		while (l1 != null || l2 != null){ //��������
//			//��ȡ��ǰҪ������ӵ�2����
//			int n1 = l1 != null ? l1.val : 0;
//			int n2 = l2 != null ? l2.val : 0;
//			int sum = n1 + n2 + carry; //���ﲻ�����Ǽӽ�λ������Ϊ�ڵڶ������ϵı�������Ҫ����sum > 10�����,����Ҫ��һλ
//			if (head == null){//��һ�α���ʱ����ͷ�ڵ�Ϊ�գ����������Ϊ��λ�����㣩
//				head = new ListNode(sum % 10);//ȡ���� ����sum>10
//				tail = new ListNode(sum % 10);
//			}else {//���������ϱ���������ʱͷ�ڵ��൱�ڸ�λ���ѽ��м��㲢����ã�Ҳ����Ҫ�޸ġ�
//				tail.next = new ListNode(sum % 10);
//				tail = tail.next; //����½ڵ�
//			}
//			carry = sum / 10; //��λ��=��/10
//
//			if (l1 != null){
//				l1 = l1.next;  //����
//			}
//			if (l2 != null){
//				l2 = l2.next; //����
//			}
//		}
//
//		if (carry > 0){ //�����ǰ�� > 10,����Ҫ��λ
//			tail.next = new ListNode(carry); //��ӽ�λ��
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
	 * ������
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