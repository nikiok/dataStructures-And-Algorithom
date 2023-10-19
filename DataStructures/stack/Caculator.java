package Algorithm.DataStructures.stack;

import java.util.Scanner;

/**
 * -----------------------------------------------
 *
 * @author ��niki
 * @date ��Created in 2023/10/15 11:06
 * @description��     ջʵ���ۺϼ�����
 * @version: $
 * -----------------------------------------------
 */

public class Caculator {
	public static void main(String[] args) {
			Array2Stack numStack = new Array2Stack(10);  //��ջ
			Array2Stack opeStack = new Array2Stack(10);  //����ջ
			Scanner san = new Scanner(System.in);
			System.out.println("������һ����׺���ʽ��");
			String s = san.nextLine();
			char index =' ';  //ɨ����ʽ,��¼��ǰ���ŵ�ֵ
			int count=0;    //��¼�Ѿ�ɨ��ı��ʽ��λ��
			int num1=0;
			int num2=0;     //������������ֵ
			int oper =0;    //�������Ĳ�����
			String keepNum="";  //���ڽ��ַ�����ת��Ϊ��������
			while (count<s.length()){
				index=s.substring(count).charAt(0);//����ɨ����ʽ,��¼��ǰɨ�赽�ķ���
				if(!isOp(index)){  //ɨ�赽��������,ֱ�Ӽ�����ջ
					keepNum +=index;
					numStack.push(Integer.parseInt(keepNum));
					keepNum="";
				}else {
					if(opeStack.isEmpty()){  //ɨ�赽���Ƿ����ҷ���ջΪ����ֱ�������ջ
						opeStack.push(index);
					}else {
						if(pri(index)>pri(opeStack.getTop()))  //ɨ�赽�ķ������ȼ��ϴ�ֱ����ջ
						{
							opeStack.push(index);
						}else {  //��С���򵯳�������ջ������һ������ջ������������
							num1=numStack.pop();
							num2=numStack.pop();
							oper=opeStack.pop();
							int result = calculate(num1,num2,oper);
							//����������ջ����ǰindex�����ջ
							numStack.push(result);
							opeStack.push(index);
						}
					}
				}
				count++;
			}
			//���ʽɨ�����֮������ʣ�µ���ջ��ֵ
			while (!opeStack.isEmpty()){
				num1=numStack.pop();
				num2=numStack.pop();
				oper=opeStack.pop();
				int result = calculate(num1,num2,oper);
				//����������ջ
				numStack.push(result);
			}
			System.out.println("�ñ��ʽ��������Ϊ��"+numStack.pop());
		}
		//����
		public static int calculate(int num1,int num2,int ope){
			int result=0;
			switch (ope){
				case '+':
					result=num1+num2;
					break;
				case '-':
					result=num2-num1; //ע��˳�򣬼�������ջ������ȳ�ջ��num1�Ǽ���
					break;
				case '*':
					result=num1*num2;
					break;
				case '/':
					result=num2/num1;
					break;
			}
			return result;
		}
		public static int pri(int n){   //�Ƚ����ȼ�
			if(n=='+'||n=='-'){
				return 1;
			}else if(n=='*'||n=='/'){
				return 2;
			}else {
				return -1;
			}
		}
		public static boolean isOp(char n){  ///�ж�index�ǲ��������
			return n=='+'||n=='-'||n=='*'||n=='/';
		}
}


//����ջ

class Array2Stack{
	private int maxSize; //ջ�Ĵ�С
	private int[] stack;  //���飬����ģ��ջ�����ݾͷ��ڸ�����
	private int top =-1;  //top ��ʾջ�� ��ʼ��Ϊ-1

	public Array2Stack(int maxSize) {
		this.maxSize = maxSize;
		stack = new int [this.maxSize];
	}

	//ջ��
	public boolean isFull(){
		return top==maxSize-1;
	}
	//ջ��
	public boolean isEmpty(){
		return top==-1;
	}
	//��ջ push
	public void push(int value){
		//���ж�ջ�Ƿ���
		if(isFull()){
			System.out.println("ջ����");
			return;
		}
		top++;
		stack[top] = value;
	}
	//��ջ pop
	public int pop(){
		if(isEmpty()){
			throw new RuntimeException("ջ�գ�û�����ݣ�");
		}else {
			int value = stack[top];
			top--;
			return value;
		}
	}
	//ջ�ı���   ����ʱ��Ҫ��ջ����ʼ��ʾ����
	public void showStack(){
		if(isEmpty()){
			System.out.println("ջΪ�գ�û������!");
		}
		for(int i=top;i>-1;i--)
			System.out.printf("stack[%d]=%d\n",i,stack[i]);
	}
	public int getTop()  //����ջ��Ԫ�ص�ֵ
	{
		return stack[top];
	}
}
