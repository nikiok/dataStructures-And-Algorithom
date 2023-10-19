package Algorithm.DataStructures.linkedList;

import java.util.Stack;

/**
 * -----------------------------------------------
 *
 * @author ：niki
 * @date ：Created in 2023/10/5 19:24
 * @description：单链表
 * @version: $
 * -----------------------------------------------
 */
public class singleLinkedList {
	public static void main(String[] args) {
		//测试链表
		//先创建节点
		HeroNode heroNode1 = new HeroNode(1,"宋江","及时雨");
		HeroNode heroNode2 = new HeroNode(2,"卢俊义","玉麒麟");
		HeroNode heroNode3 = new HeroNode(3,"吴用","智多星");
		HeroNode heroNode4 = new HeroNode(4,"林冲","豹子头");

		Singlelinkedlist singlelinkedlist = new Singlelinkedlist();
		//加入(未编号排序)
//		singlelinkedlist.add(heroNode1);
//		singlelinkedlist.add(heroNode3);
//		singlelinkedlist.add(heroNode2);
//		singlelinkedlist.add(heroNode4);


		//有编号排序
		singlelinkedlist.add2(heroNode1);
		singlelinkedlist.add2(heroNode3);
		singlelinkedlist.add2(heroNode2);
		singlelinkedlist.add2(heroNode4);
		singlelinkedlist.list();

		//单链表反转
		System.out.println("反转后的链表");
		singlelinkedlist.reverseLinklist(singlelinkedlist.getHead());
		singlelinkedlist.list();

		//逆序打印单链表
		System.out.println("逆序打印单链表");
		singlelinkedlist.reversePrint(singlelinkedlist.getHead());
		//修改节点
		HeroNode heroNode5 = new HeroNode(2,"小卢","玉麒麟");
		singlelinkedlist.update(heroNode5);
		System.out.println("修改后的data");
		singlelinkedlist.list();

		//删除节点
		System.out.println("删除节点");
		singlelinkedlist.del(1);
		singlelinkedlist.list();

		//统计链表中有效节点的个数
		System.out.println("统计链表的有效节点个数");
		System.out.println(singlelinkedlist.getlength(singlelinkedlist.getHead()));

		//获取链表中倒数第k个节点
		HeroNode res = singlelinkedlist.getLastKNode(singlelinkedlist.getHead(),1);
		System.out.printf("res = " + res);

	}

	//定义SingleLinkedList 管理水浒英雄

	static class Singlelinkedlist{
		//初始化一个head
		private HeroNode head = new HeroNode(0,"","");

		public HeroNode getHead() {
			return head;
		}

		//添加节点到单链表
		/**
		 * 思路,不考虑编号顺序：
		 *  1.找到当前链表的最后节点
		 *  2.找到最后节点的next域 指向 新的节点
		 */
		public void add(HeroNode heroNode){
			HeroNode temp = head;

			//遍历链表，找到最后节点
			while (true){
				//找到链表的最后
				if (temp.next == null){
					break;
				}
				temp = temp.next;
			}
			temp.next = heroNode;
		}

		/**
		 * 考虑编号顺序添加
		 * @param heroNode
		 */
		public void add2(HeroNode heroNode){
			HeroNode temp = head;
			boolean flag = false;
			//遍历链表，找到最后节点
			while (true){
				//找到链表的最后
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
				System.out.printf("准备插入的英雄的编号%d已经存在了，不能加入\n",heroNode.no);
			}else {
				heroNode.next = temp.next;
				temp.next = heroNode;
			}
		}

		//修改节点的信息，根据no编号来修改，即no编号不能修改
		public void update(HeroNode newHeroNode){
			if (head.next == null){
				System.out.println("链表为空~");
				return;
			}
			// 找到需要修改的节点，根据no编号
			HeroNode temp = head.next; //定义一个辅助变量
			boolean flag = false;
			while (true){
				if (temp == null){
					break;  //已经遍历完链表
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

		//删除节点
		/**
		 * 思路：
		 * 1。
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
				System.out.printf("要删除的%d节点不存在\n",no);
			}
		}

		/**
		 * 获取到单链表的节点的个数(如果是带头节点的链表，需求不统计头节点)
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
		//显示链表
		public void list(){
			if (head.next == null){
				System.out.println("链表为空");
				return;
			}
			HeroNode temp = head.next;
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
		/** -----------------------------------------------
		 * description:
		 * TODO：   单链表的面试题
		 * create time: 16:19 2023/10/9
		 ----------------------------------------------- */

		/**
		 * 查找单链表中的倒数第k个结点 【新浪面试题】
		 * @param head
		 * @param k
		 * @return
		 */
		public static HeroNode getLastKNode(HeroNode head,int k){
			// 若链表为空，返回null
			if (head.next == null){
				return null;
			}
			//获取链表长度
			int size =  getlength(head);

			//遍历链表
			//k检验
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
		 * 反转链表--【腾讯面试题】
		 * @param head
		 */
		public static void  reverseLinklist(HeroNode head){
			//如果当前列表为空，或者只有一个节点,无需反转，直接返回
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
		 * 将单链表从尾到头打印【百度】
		 * 思路：利用栈先进后出的特点，先将单链表的节点存入栈，在出栈即可完成条件。
		 * @param head
		 */
		public static void reversePrint(HeroNode head){
			if (head.next == null){
				return; //空链表不能打印
			}
			//创建一个栈，将各节点压入栈
			Stack<HeroNode> stack = new Stack<>();
			HeroNode cur = head.next;

			//将链表的所有节点压入栈
			while (cur != null){
				stack.push(cur);
				cur = cur.next;
			}
			//将栈中的节点进行打印，pop 出栈
			while(stack.size() > 0){
				System.out.println(stack.pop());
			}
		}
	}

	// 定义HeroNode,每个HeroNode对象就是一个节点
	static class HeroNode{
		/** -----------------------------------------------
		* description: 用单链表存储水浒传英雄排名
		 * TODO：
		* create time: 19:25 2023/10/5
		*    * @Param: null
		* @return
		----------------------------------------------- */
		public int no;
		public String name;
		public String nickname;
		public HeroNode next; //指向下一个节点

		@Override
		public String toString() {
			return "HeroNode{" +
					"no=" + no +
					", name='" + name + '\'' +
					", nickname='" + nickname + '\'' +
					'}';
		}

		//构造器
		public HeroNode(int hNo,String hName,String hNickname){
			this.no = hNo;
			this.name = hName;
			this.nickname = hNickname;
		}
	}

}
