package Algorithm.DataStructures.linkedList;


/**
 * -----------------------------------------------
 *
 * @author ��niki
 * @date ��Created in 2023/10/12 9:54
 * @description��˫������
 * @version: $
 * -----------------------------------------------
 */
public class doubleLinkedList {

	public static void main(String[] args) {
		HeroNode2 node1 = new HeroNode2(1,"�ν�","��ʱ��");
		HeroNode2 node2 = new HeroNode2(2,"¬����","������");
		HeroNode2 node3 = new HeroNode2(3,"����","�Ƕ���");
		HeroNode2 node4 = new HeroNode2(4,"�ֳ�","����ͷ");

		doublelinklist doublelinklist = new doublelinklist();
		// ��
//		doublelinklist.add(node2);
//		doublelinklist.add(node1);
//		doublelinklist.add(node4);
//		doublelinklist.add(node3);
		doublelinklist.addByno(node2);
		doublelinklist.addByno(node1);
		doublelinklist.addByno(node4);
		doublelinklist.addByno(node3);
		//����
		doublelinklist.list();

		//��
		HeroNode2 hero = new HeroNode2(1,"����ʤ","������");
		doublelinklist.update(hero);
		System.out.println("�޸ĺ������");
		doublelinklist.list();

		//ɾ
		doublelinklist.remove(1);
		System.out.println("ɾ���������");
		doublelinklist.list();

	}

	static class doublelinklist{
		// ��ʼ��ͷ�ڵ�
		private HeroNode2 head =new HeroNode2(0,"","");

		//����ͷ�ڵ�
		public HeroNode2 getHead(){
			return head;
		}
		//��
		public void add(HeroNode2 hero){
			HeroNode2 temp = head;
			//���������ҵ����ڵ�
			while (true){
				//�ҵ���������
				if (temp.next == null){
					break;
				}
				temp = temp.next;
			}
			//��ӽڵ�
			temp.next = hero;
			hero.pre = temp;
		}

		public void addByno(HeroNode2 hero){
			HeroNode2 temp = head;
			boolean flag = false;
			while (true){
				if (temp.next == null){
					break;
				}
				if (temp.next.no > hero.no){
					break;
				}else if(temp.next.no == hero.no){
					flag = true;
					break;
				}
				temp = temp.next;
			}
			if (flag){
				System.out.printf("׼���������ݵı��%d�Ѿ������ˣ����ܼ���\n",hero.no);
			}else {
				hero.next = temp.next;
				temp.next = hero;
			}
		}

		//ɾ
		public void remove(int no){

			if (head.next == null){
				System.out.println("����Ϊ�գ��޷�ɾ��");
				return;
			}

			HeroNode2 temp = head.next;
			boolean flag = false;

			while (true){
				if (temp == null){
					break;
				}
				if (temp.no == no){
					flag = true;
					break;
				}
				temp = temp.next;
			}
			if (flag){
				temp.pre.next = temp.next;
				if (temp.next != null){
					temp.next.pre = temp.pre;
				}
			}else {
				System.out.printf("Ҫɾ����%d�ڵ㲻����\n",no);
			}
		}

		//��
		public void update(HeroNode2 newhero){
			if (head.next == null){
				System.out.println("����Ϊ��~");
				return;
			}
			// �ҵ���Ҫ�޸ĵĽڵ㣬����no���
			HeroNode2 temp = head.next; //����һ����������
			boolean flag = false;
			while (true){
				if (temp == null){
					break;  //�Ѿ�����������
				}
				if (temp.no == newhero.no){
					flag = true;
					break;
				}
				temp = temp.next;
			}
			if (flag){
				temp.name = newhero.name;
				temp.nickname = newhero.nickname;
			}

		}

		//����˫������
		public void list(){
			if (head.next == null){
				System.out.println("����Ϊ��");
				return;
			}
			HeroNode2 temp = head.next;
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

		//��ȡ��Ч����
		public static  int getlength(HeroNode2 head){
			if (head.next == null){
				return 0;
			}
			int length = 0;
			HeroNode2 cur = head.next;
			while (cur != null){
				length++;
				cur = cur.next;
			}
			return length;
		}
	}
	static class HeroNode2{
		public int no;
		public String name;
		public String nickname;
		public HeroNode2 next; //ָ����һ���ڵ�
		public HeroNode2 pre; //ָ����һ���ڵ�


		public HeroNode2(int no, String name, String nickname) {
			this.no = no;
			this.name = name;

		}

		@Override
		public String toString() {
			return "HeroNode{" +
					"no=" + no +
					", name='" + name + '\'' +
					", nickname='" + nickname + "}";
		}
	}
}
