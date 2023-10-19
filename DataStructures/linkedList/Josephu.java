package Algorithm.DataStructures.linkedList;

/**
 * -----------------------------------------------
 *
 * @author ：niki
 * @date ：Created in 2023/10/12 19:44
 * @description：约瑟夫问题 :
 *  约瑟夫环：已知n个人(以编号1，2，3...n分别表示)围坐在一张圆桌周围。
 *  从编号为k的人开始报数，数到m的那个人出列;他的下一个人又从1开始报数，数到m的那个人又出列;依此规律重复下去，直到圆桌周围的人全部出列。
 * @version: $
 * -----------------------------------------------
 */
public class Josephu {
	public static void main(String[] args) {

		CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
		circleSingleLinkedList.addBoy(5);
		circleSingleLinkedList.showBoy();
		circleSingleLinkedList.countBoy(1,2,5);
	}

}
class CircleSingleLinkedList{
	//创建一个first节点，当前没有编号
	private Boy first = new Boy(-1);
	//添加小孩节点，构建成一个环形的链表
	public void addBoy(int nums){
		if (nums<1){
			System.out.printf("nums的值错误");
			return;
		}
		//辅助变量（指针）
		Boy curBoy = null;
		for (int i = 1; i <= nums ; i++) {
			Boy boy = new Boy(i);
			if (i == 1){
				first = boy;
				first.setNext(first);
				curBoy = first;
			}else {
				curBoy.setNext(boy);
				boy.setNext(first);
				curBoy = boy;
			}
		}
	}
	public void showBoy(){
		if (first == null){
			System.out.printf("没有数据");
			return;
		}
		Boy curBoy = first;

		while (true){
			System.out.printf("数据编号为%d\n",curBoy.getNo());
			if (curBoy.getNext() == first){
				break;
			}
			curBoy = curBoy.getNext();
		}
	}

	/**
	 *
	 * @param startNo 表示从第几个小孩开始数
	 * @param countNum 表示数几下
	 * @param nums  表示最初有多少小孩在圈中
	 */
	public void countBoy(int startNo,int countNum,int nums){
		if (first == null || startNo < 1 || startNo > nums){
			System.out.println("参数输入有误,请重新输入");
			return;
		}
		Boy helper = first;
		while(true){
			if (helper.getNext() == first){
				break;
			}
			helper = helper.getNext();
		}
		for (int i = 0; i < startNo -1 ; i++) {
			first = first.getNext();
			helper = helper.getNext();
		}
		while (true){
			if (helper == first){
				break;
			}
			for (int i = 0; i < countNum - 1; i++) {
				first = first.getNext();
				helper = helper.getNext();
			}
			System.out.printf("小孩%d出圈\n",first.getNo());
			first = first.getNext();
			helper.setNext(first);
		}
		System.out.printf("最后留在圈中的小孩的编号%d \n",first.getNo());
	}
}
class Boy{
	private int no;
	private Boy next;

	public Boy(int no) {
		this.no = no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getNo() {
		return no;
	}
	public void setNext(Boy boy){
		this.next = boy;
	}
	public Boy getNext(){
		return next;
	}
}