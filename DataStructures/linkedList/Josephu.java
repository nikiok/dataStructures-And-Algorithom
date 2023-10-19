package Algorithm.DataStructures.linkedList;

/**
 * -----------------------------------------------
 *
 * @author ��niki
 * @date ��Created in 2023/10/12 19:44
 * @description��Լɪ������ :
 *  Լɪ�򻷣���֪n����(�Ա��1��2��3...n�ֱ��ʾ)Χ����һ��Բ����Χ��
 *  �ӱ��Ϊk���˿�ʼ����������m���Ǹ��˳���;������һ�����ִ�1��ʼ����������m���Ǹ����ֳ���;���˹����ظ���ȥ��ֱ��Բ����Χ����ȫ�����С�
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
	//����һ��first�ڵ㣬��ǰû�б��
	private Boy first = new Boy(-1);
	//���С���ڵ㣬������һ�����ε�����
	public void addBoy(int nums){
		if (nums<1){
			System.out.printf("nums��ֵ����");
			return;
		}
		//����������ָ�룩
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
			System.out.printf("û������");
			return;
		}
		Boy curBoy = first;

		while (true){
			System.out.printf("���ݱ��Ϊ%d\n",curBoy.getNo());
			if (curBoy.getNext() == first){
				break;
			}
			curBoy = curBoy.getNext();
		}
	}

	/**
	 *
	 * @param startNo ��ʾ�ӵڼ���С����ʼ��
	 * @param countNum ��ʾ������
	 * @param nums  ��ʾ����ж���С����Ȧ��
	 */
	public void countBoy(int startNo,int countNum,int nums){
		if (first == null || startNo < 1 || startNo > nums){
			System.out.println("������������,����������");
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
			System.out.printf("С��%d��Ȧ\n",first.getNo());
			first = first.getNext();
			helper.setNext(first);
		}
		System.out.printf("�������Ȧ�е�С���ı��%d \n",first.getNo());
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