package Algorithm.DataStructures.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * -----------------------------------------------
 *
 * @author ：niki
 * @date ：Created in 2023/10/16 9:24
 * @description ：逆波兰计算器（后缀表达式）
 * @version: $
 * -----------------------------------------------
 */
public class ReversePolishCalculator {
	public static void main(String[] args) {
		// (3+2)*2-4 => 3 2 + 2 *  4 -
		String suffixExpression = "30 2 + 4 * 4 -";
		/*  思路
		 *
		 *  	1.先将后缀表达式放入ArrayList中
		 *  	2.将ArrayList传递一个方法，遍历ArrayList配合栈 ，完成计算
		 */
//		List<String> list = getListString(suffixExpression);
//		int res = calculate(list);
//		System.out.printf("%s = %d",suffixExpression,res);
		String  infixExpression = "1+((2+3)*4)-5";
		List<String> infixList = toInfixExpressionList(infixExpression);
		System.out.println("中缀表达式对应的List" + infixList);
		List<String> suffixList = toSuffix(infixList);    //[1, +, (, (, 2, +, 3, ), *, 4, ), -, 5]
		System.out.println("后缀表达式对应的List" + suffixList); //[1, 2, 3, +, 4, *, 5, -]
		int result = calculate(suffixList);
		System.out.println(infixExpression + "=" + result);
	}

	/**
	 * 分割String类型的后缀表达式 转化为ArrayList类型
	 * @param suffixExpression
	 * @return
	 */
	public static List<String> getListString(String suffixExpression){
		String[] split = suffixExpression.split(" ");
		List<String> list = new ArrayList<>();
		for (String ele: split) {
			list.add(ele);
		}
		return list;
	}

	/**
	 * 完成对逆波兰表达式的运算
	 *  从左向右扫描，将数字入栈，遇到运算符进行数字出栈运算在入栈，依此类推
	 * @param list
	 * @return
	 */
	public static  int calculate(List<String> list){
		Stack<String> stack = new Stack<>();
		for (String item: list) {
			//这里取出正则表达式来取出数字
			if (item.matches("\\d+")){
				//入栈
				stack.push(item);
			}else {
				int	num2 = Integer.parseInt(stack.pop());
				int num1 = Integer.parseInt(stack.pop());
				int res = 0;
				if (item.equals("+")){
					res = num2 + num1;
				} else if (item.equals("-")) {
					res = num1- num2;
				} else if (item.equals("*")) {
					res = num1 * num2;
				}else if (item.equals("/")){
					res = num1 / num2;
				}else {
					throw new RuntimeException("运算符有误");
				}
				stack.push("" + res);
			}
		}
		return Integer.parseInt(stack.pop());
	}

	/**
	 * 中缀字符串 转为 中缀ArrayList
	 * @param s
	 * @return
	 */
	public static List<String > toInfixExpressionList(String s){
		List<String> list = new ArrayList<>(); //存放中缀表达式对应的内容
		int i = 0; //指针，用于遍历中缀表达式字符串
		String str; //多位数拼接
		char c;
		do {
			//
			if ((c = s.charAt(i)) < 48 || (c = s.charAt(i)) > 57){
				list.add("" + c);
				i++;
			}else { //如果是一个数
				str = "";
				while (i < s.length() && (c = s.charAt(i)) >= 48 && (c = s.charAt(i)) <= 57 ){
					str += c;
					i++;
				}
				list.add(str);
			}
		} while (i < s.length());
		return list;
	}


	/**
	 * 中缀转后缀
	 * todo :  1)初始化两个栈：运算符栈s1和储存中间结果的栈s2:
		 * 2)从左至右扫描中缀表达式：
		 * 3)遇到操作数时，将其压s2:
		 * 4)遇到运算符时，比较其与s1栈顶运算符的优先级：
		 * 1如果s1为空，或栈顶运算符为左括号“(”，则直接将此运算符入栈：
		 * 2.否则，若优先级比栈顶运算符的高，也将运算符压入s1:
		 * 3.否则，将s1栈顶的运算符弹出并压入到s2中，再次转到(4-1)与s1中新的栈顶运算符相比较：
		 * 5)遇到括号时：
		 * (1)如果是左括号“(”，则直接压入s1
		 * (2)如果是右括号“)”，则依次弹出s1栈顶的运算符，并压入s2,直到遇到左括号为止，此时将这一对括号丢弃
		 * 6)重复步骤2至5，直到表达式的最右边
		 * 7)将s1中剩余的运算符依次弹出并压入s2
		 * 8)依次弹出s2中的元素并输出，结果的逆序即为中缀表达式对应的后缀表达式
	 * @param infixList
	 * @return
	 */
	public static List<String> toSuffix(List<String> infixList){
		Stack<String> s1 = new Stack<>(); //符号栈
//		Stack<String> s2 = new Stack<>();
		 /*
		 由于s2栈 pop()操作较少，且最后还需反转较为麻烦，因此改使用Arrayist<>()
		  */
		List<String> s2 = new ArrayList<>();
		for (String item: infixList){
			if (item.matches("\\d+")){ //如果扫描到的是数字
				s2.add(item);
			}else if (item.equals("(")){ //如果扫描到的是左括号
				s1.push(item);
			} else if (item.equals(")")) {//如果扫描的是右括号
				while ( !s1.peek().equals("(") ){
					s2.add(s1.pop());
				}
				s1.pop();
			}else { //扫描的是运算符

				/* 遇到括号时：
				 * 1如果s1为空，或栈顶运算符为左括号“(”，则直接将此运算符入栈：
				 * 2.否则，若优先级比栈顶运算符的高，也将运算符压入s1:
				 * 3.否则，将s1栈顶的运算符弹出并压入到s2中，再次转到(4-1)与s1中新的栈顶运算符相比较：
				 */
//				//运算优先级比较当item的优先级小于栈顶的优先级时
				while (s1.size() != 0 && operation.getValue(s1.peek()) >= operation.getValue(item) ){
					s2.add(s1.pop());
				}
//				if (s1.size() == 0 || s1.peek().equals("(")){
//					s1.push(item);
//				} else if (operation.getValue(item) > operation.getValue(s1.peek())) {
//					s1.push(item);
//				}else {
//					s2.add(s1.pop());
////					s1.pop();
//				}
				s1.push(item);
			}
		}
		//将s1中剩余的运算符加入s2
		while (s1.size() != 0){
			s2.add(s1.pop());
		}
		return s2;
	}

}

//
class operation{
	private static int ADD = 1; //+
	private static int SUB = 1; //-
	private static int MUL = 2; //*
	private static int DIV = 2; //?

	public static int getValue(String oper){
		int res = 0;
		switch (oper){
			case "+":
				res = ADD;
				break;
			case "-":
				res = SUB;
				break;
			case "*":
				res = MUL;
				break;
			case "/":
				res = DIV;
				break;
		}
		return res;
	}
}