package Algorithm.DataStructures.linkedList;

import java.util.Stack;

/**
 * -----------------------------------------------
 *
 * @author ��niki
 * @date ��Created in 2023/10/5 19:24
 * @description��������
 * @version: $
 * -----------------------------------------------
 */
public class singleLinkedList {
	public static void main(String[] args) {
		//��������
		//�ȴ����ڵ�
		HeroNode heroNode1 = new HeroNode(1,"�ν�","��ʱ��");
		HeroNode heroNode2 = new HeroNode(2,"¬����","������");
		HeroNode heroNode3 = new HeroNode(3,"����","�Ƕ���");
		HeroNode heroNode4 = new HeroNode(4,"�ֳ�","����ͷ");

		Singlelinkedlist singlelinkedlist = new Singlelinkedlist();
		//����(δ�������)
//		singlelinkedlist.add(heroNode1);
//		singlelinkedlist.add(heroNode3);
//		singlelinkedlist.add(heroNode2);
//		singlelinkedlist.add(heroNode4);


		//�б������
		singlelinkedlist.add2(heroNode1);
		singlelinkedlist.add2(heroNode3);
		singlelinkedlist.add2(heroNode2);
		singlelinkedlist.add2(heroNode4);
		singlelinkedlist.list();

		//������ת
		System.out.println("��ת�������");
		singlelinkedlist.reverseLinklist(singlelinkedlist.getHead());
		singlelinkedlist.list();

		//�����ӡ������
		System.out.println("�����ӡ������");
		singlelinkedlist.reversePrint(singlelinkedlist.getHead());
		//�޸Ľڵ�
		HeroNode heroNode5 = new HeroNode(2,"С¬","������");
		singlelinkedlist.update(heroNode5);
		System.out.println("�޸ĺ��data");
		singlelinkedlist.list();

		//ɾ���ڵ�
		System.out.println("ɾ���ڵ�");
		singlelinkedlist.del(1);
		singlelinkedlist.list();

		//ͳ����������Ч�ڵ�ĸ���
		System.out.println("ͳ���������Ч�ڵ����");
		System.out.println(singlelinkedlist.getlength(singlelinkedlist.getHead()));

		//��ȡ�����е�����k���ڵ�
		HeroNode res = singlelinkedlist.getLastKNode(singlelinkedlist.getHead(),1);
		System.out.printf("res = " + res);

	}

	//����SingleLinkedList ����ˮ�Ӣ��

	static class Singlelinkedlist{
		//��ʼ��һ��head
		private HeroNode head = new HeroNode(0,"","");

		public HeroNode getHead() {
			return head;
		}

		//��ӽڵ㵽������
		/**
		 * ˼·,�����Ǳ��˳��
		 *  1.�ҵ���ǰ��������ڵ�
		 *  2.�ҵ����ڵ��next�� ָ�� �µĽڵ�
		 */
		public void add(HeroNode heroNode){
			HeroNode temp = head;

			//���������ҵ����ڵ�
			while (true){
				//�ҵ���������
				if (temp.next == null){
					break;
				}
				temp = temp.next;
			}
			temp.next = heroNode;
		}

		/**
		 * ���Ǳ��˳�����
		 * @param heroNode
		 */
		public void add2(HeroNode heroNode){
			HeroNode temp = head;
			boolean flag = false;
			//���������ҵ����ڵ�
			while (true){
				//�ҵ���������
				if (temp.next == null){
					break;
				}
				if (temp.next.no > heroNode.no){
					break;
				} else if (temp.next.no == heroNode.no){
					flag = true;
					break;
				}
				temp = temp.next;
			}
			if(flag){
				System.out.printf("׼�������Ӣ�۵ı��%d�Ѿ������ˣ����ܼ���\n",heroNode.no);
			}else {
				heroNode.next = temp.next;
				temp.next = heroNode;
			}
		}

		//�޸Ľڵ����Ϣ������no������޸ģ���no��Ų����޸�
		public void update(HeroNode newHeroNode){
			if (head.next == null){
				System.out.println("����Ϊ��~");
				return;
			}
			// �ҵ���Ҫ�޸ĵĽڵ㣬����no���
			HeroNode temp = head.next; //����һ����������
			boolean flag = false;
			while (true){
				if (temp == null){
					break;  //�Ѿ�����������
				}
				if (temp.no == newHeroNode.no){
					flag = true;
					break;
				}
				temp = temp.next;
			}
			if (flag){
				temp.name = newHeroNode.name;
				temp.nickname = newHeroNode.nickname;
			}

		}

		//ɾ���ڵ�
		/**
		 * ˼·��
		 * 1��
		 * 2.
		 */
		public void  del(int no){
			HeroNode temp = head;
			boolean flag = false;
			while (true){
				if (temp.next == null){
					break;
				}
				if (temp.next.no == no){
					flag = true;
					break;
				}
				temp = temp.next;
			}
			if (flag){
				temp.next = temp.next.next;
			}else {
				System.out.printf("Ҫɾ����%d�ڵ㲻����\n",no);
			}
		}

		/**
		 * ��ȡ��������Ľڵ�ĸ���(����Ǵ�ͷ�ڵ����������ͳ��ͷ�ڵ�)
		 * @param head
		 * @return
		 */
		public static  int getlength(HeroNode head){
			if (head.next == null){
				return 0;
			}
			int length = 0;
			HeroNode cur = head.next;
			while (cur != null){
				length++;
				cur = cur.next;
			}
			return length;
		}
		//��ʾ����
		public void list(){
			if (head.next == null){
				System.out.println("����Ϊ��");
				return;
			}
			HeroNode temp = head.next;
			while (true){
				//�ж��Ƿ��������
				if (temp == null){
					break;
				}
				System.out.println(temp);
				// ��temp����
				temp = temp.next;

			}
		}
		/** -----------------------------------------------
		 * description:
		 * TODO��   �������������
		 * create time: 16:19 2023/10/9
		 ----------------------------------------------- */

		/**
		 * ���ҵ������еĵ�����k����� �����������⡿
		 * @param head
		 * @param k
		 * @return
		 */
		public static HeroNode getLastKNode(HeroNode head,int k){
			// ������Ϊ�գ�����null
			if (head.next == null){
				return null;
			}
			//��ȡ������
			int size =  getlength(head);

			//��������
			//k����
			if (k <= 0 || k > size){
				return null;
			}
			HeroNode cur = head.next;
			for (int i = 0; i < size - k; i++) {
				cur = cur.next;
			}
			return cur;
		}

		/**
		 * ��ת����--����Ѷ�����⡿
		 * @param head
		 */
		public static void  reverseLinklist(HeroNode head){
			//�����ǰ�б�Ϊ�գ�����ֻ��һ���ڵ�,���跴ת��ֱ�ӷ���
			if (head.next == null || head.next.next == null){
				return;
			}

			HeroNode cur = head.next;
			HeroNode next = null;
			HeroNode reverseHead = new HeroNode(0,"","");

			while (cur != null){
				next = cur.next;
				cur.next = reverseHead.next;
				reverseHead.next = cur;
				cur = next;
			}
			head.next = reverseHead.next;
		}

		/**
		 * ���������β��ͷ��ӡ���ٶȡ�
		 * ˼·������ջ�Ƚ�������ص㣬�Ƚ�������Ľڵ����ջ���ڳ�ջ�������������
		 * @param head
		 */
		public static void reversePrint(HeroNode head){
			if (head.next == null){
				return; //�������ܴ�ӡ
			}
			//����һ��ջ�������ڵ�ѹ��ջ
			Stack<HeroNode> stack = new Stack<>();
			HeroNode cur = head.next;

			//����������нڵ�ѹ��ջ
			while (cur != null){
				stack.push(cur);
				cur = cur.next;
			}
			//��ջ�еĽڵ���д�ӡ��pop ��ջ
			while(stack.size() > 0){
				System.out.println(stack.pop());
			}
		}
	}

	// ����HeroNode,ÿ��HeroNode�������һ���ڵ�
	static class HeroNode{
		/** -----------------------------------------------
		* description: �õ�����洢ˮ䰴�Ӣ������
		 * TODO��
		* create time: 19:25 2023/10/5
		*    * @Param: null
		* @return
		----------------------------------------------- */
		public int no;
		public String name;
		public String nickname;
		public HeroNode next; //ָ����һ���ڵ�

		@Override
		public String toString() {
			return "HeroNode{" +
					"no=" + no +
					", name='" + name + '\'' +
					", nickname='" + nickname + '\'' +
					'}';
		}

		//������
		public HeroNode(int hNo,String hName,String hNickname){
			this.no = hNo;
			this.name = hName;
			this.nickname = hNickname;
		}
	}

}
