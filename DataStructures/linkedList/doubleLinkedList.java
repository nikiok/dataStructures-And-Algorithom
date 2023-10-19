package Algorithm.DataStructures.linkedList;


/**
 * -----------------------------------------------
 *
 * @author ：niki
 * @date ：Created in 2023/10/12 9:54
 * @description：双向链表
 * @version: $
 * -----------------------------------------------
 */
public class doubleLinkedList {

	public static void main(String[] args) {
		HeroNode2 node1 = new HeroNode2(1,"宋江","及时雨");
		HeroNode2 node2 = new HeroNode2(2,"卢俊义","玉麒麟");
		HeroNode2 node3 = new HeroNode2(3,"吴用","智多星");
		HeroNode2 node4 = new HeroNode2(4,"林冲","豹子头");

		doublelinklist doublelinklist = new doublelinklist();
		// 增
//		doublelinklist.add(node2);
//		doublelinklist.add(node1);
//		doublelinklist.add(node4);
//		doublelinklist.add(node3);
		doublelinklist.addByno(node2);
		doublelinklist.addByno(node1);
		doublelinklist.addByno(node4);
		doublelinklist.addByno(node3);
		//遍历
		doublelinklist.list();

		//改
		HeroNode2 hero = new HeroNode2(1,"公孙胜","入云龙");
		doublelinklist.update(hero);
		System.out.println("修改后的链表");
		doublelinklist.list();

		//删
		doublelinklist.remove(1);
		System.out.println("删除后的链表");
		doublelinklist.list();

	}

	static class doublelinklist{
		// 初始化头节点
		private HeroNode2 head =new HeroNode2(0,"","");

		//返回头节点
		public HeroNode2 getHead(){
			return head;
		}
		//增
		public void add(HeroNode2 hero){
			HeroNode2 temp = head;
			//遍历链表，找到最后节点
			while (true){
				//找到链表的最后
				if (temp.next == null){
					break;
				}
				temp = temp.next;
			}
			//添加节点
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
				System.out.printf("准备插入数据的编号%d已经存在了，不能加入\n",hero.no);
			}else {
				hero.next = temp.next;
				temp.next = hero;
			}
		}

		//删
		public void remove(int no){

			if (head.next == null){
				System.out.println("链表为空，无法删除");
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
				System.out.printf("要删除的%d节点不存在\n",no);
			}
		}

		//改
		public void update(HeroNode2 newhero){
			if (head.next == null){
				System.out.println("链表为空~");
				return;
			}
			// 找到需要修改的节点，根据no编号
			HeroNode2 temp = head.next; //定义一个辅助变量
			boolean flag = false;
			while (true){
				if (temp == null){
					break;  //已经遍历完链表
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

		//遍历双向链表
		public void list(){
			if (head.next == null){
				System.out.println("链表为空");
				return;
			}
			HeroNode2 temp = head.next;
			while (true){
				//判断是否到链表最后
				if (temp == null){
					break;
				}
				System.out.println(temp);
				// 将temp后移
				temp = temp.next;

			}
		}

		//获取有效长度
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
		public HeroNode2 next; //指向下一个节点
		public HeroNode2 pre; //指向上一个节点


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
