package Algorithm.DataStructures.stack;

import java.util.Scanner;

/**
 * -----------------------------------------------
 *
 * @author ：niki
 * @date ：Created in 2023/10/15 11:06
 * @description：     栈实现综合计算器
 * @version: $
 * -----------------------------------------------
 */

public class Caculator {
	public static void main(String[] args) {
			Array2Stack numStack = new Array2Stack(10);  //数栈
			Array2Stack opeStack = new Array2Stack(10);  //符号栈
			Scanner san = new Scanner(System.in);
			System.out.println("请输入一个中缀表达式：");
			String s = san.nextLine();
			char index =' ';  //扫描表达式,记录当前符号的值
			int count=0;    //记录已经扫描的表达式的位置
			int num1=0;
			int num2=0;     //参与计算的两个值
			int oper =0;    //参与计算的操作符
			String keepNum="";  //便于将字符类型转换为整数类型
			while (count<s.length()){
				index=s.substring(count).charAt(0);//依次扫描表达式,记录当前扫描到的符号
				if(!isOp(index)){  //扫描到的是数字,直接加入数栈
					keepNum +=index;
					numStack.push(Integer.parseInt(keepNum));
					keepNum="";
				}else {
					if(opeStack.isEmpty()){  //扫描到的是符号且符号栈为空则直接入符号栈
						opeStack.push(index);
					}else {
						if(pri(index)>pri(opeStack.getTop()))  //扫描到的符号优先级较大，直接入栈
						{
							opeStack.push(index);
						}else {  //较小，则弹出两个数栈的数和一个符号栈的数进行运算
							num1=numStack.pop();
							num2=numStack.pop();
							oper=opeStack.pop();
							int result = calculate(num1,num2,oper);
							//运算结果入数栈，当前index入符号栈
							numStack.push(result);
							opeStack.push(index);
						}
					}
				}
				count++;
			}
			//表达式扫描完毕之后，运算剩下的数栈的值
			while (!opeStack.isEmpty()){
				num1=numStack.pop();
				num2=numStack.pop();
				oper=opeStack.pop();
				int result = calculate(num1,num2,oper);
				//运算结果入数栈
				numStack.push(result);
			}
			System.out.println("该表达式的运算结果为："+numStack.pop());
		}
		//计算
		public static int calculate(int num1,int num2,int ope){
			int result=0;
			switch (ope){
				case '+':
					result=num1+num2;
					break;
				case '-':
					result=num2-num1; //注意顺序，减数后入栈，因此先出栈的num1是减数
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
		public static int pri(int n){   //比较优先级
			if(n=='+'||n=='-'){
				return 1;
			}else if(n=='*'||n=='/'){
				return 2;
			}else {
				return -1;
			}
		}
		public static boolean isOp(char n){  ///判断index是不是运算符
			return n=='+'||n=='-'||n=='*'||n=='/';
		}
}


//创建栈

class Array2Stack{
	private int maxSize; //栈的大小
	private int[] stack;  //数组，数组模拟栈，数据就放在该数组
	private int top =-1;  //top 表示栈顶 初始化为-1

	public Array2Stack(int maxSize) {
		this.maxSize = maxSize;
		stack = new int [this.maxSize];
	}

	//栈满
	public boolean isFull(){
		return top==maxSize-1;
	}
	//栈空
	public boolean isEmpty(){
		return top==-1;
	}
	//入栈 push
	public void push(int value){
		//先判断栈是否满
		if(isFull()){
			System.out.println("栈满！");
			return;
		}
		top++;
		stack[top] = value;
	}
	//出栈 pop
	public int pop(){
		if(isEmpty()){
			throw new RuntimeException("栈空！没有数据！");
		}else {
			int value = stack[top];
			top--;
			return value;
		}
	}
	//栈的遍历   遍历时需要从栈顶开始显示数据
	public void showStack(){
		if(isEmpty()){
			System.out.println("栈为空，没有数据!");
		}
		for(int i=top;i>-1;i--)
			System.out.printf("stack[%d]=%d\n",i,stack[i]);
	}
	public int getTop()  //返回栈顶元素的值
	{
		return stack[top];
	}
}
