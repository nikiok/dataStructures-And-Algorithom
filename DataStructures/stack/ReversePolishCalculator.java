package Algorithm.DataStructures.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * -----------------------------------------------
 *
 * @author ��niki
 * @date ��Created in 2023/10/16 9:24
 * @description ���沨������������׺���ʽ��
 * @version: $
 * -----------------------------------------------
 */
public class ReversePolishCalculator {
	public static void main(String[] args) {
		// (3+2)*2-4 => 3 2 + 2 *  4 -
		String suffixExpression = "30 2 + 4 * 4 -";
		/*  ˼·
		 *
		 *  	1.�Ƚ���׺���ʽ����ArrayList��
		 *  	2.��ArrayList����һ������������ArrayList���ջ ����ɼ���
		 */
//		List<String> list = getListString(suffixExpression);
//		int res = calculate(list);
//		System.out.printf("%s = %d",suffixExpression,res);
		String  infixExpression = "1+((2+3)*4)-5";
		List<String> infixList = toInfixExpressionList(infixExpression);
		System.out.println("��׺���ʽ��Ӧ��List" + infixList);
		List<String> suffixList = toSuffix(infixList);    //[1, +, (, (, 2, +, 3, ), *, 4, ), -, 5]
		System.out.println("��׺���ʽ��Ӧ��List" + suffixList); //[1, 2, 3, +, 4, *, 5, -]
		int result = calculate(suffixList);
		System.out.println(infixExpression + "=" + result);
	}

	/**
	 * �ָ�String���͵ĺ�׺���ʽ ת��ΪArrayList����
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
	 * ��ɶ��沨�����ʽ������
	 *  ��������ɨ�裬��������ջ������������������ֳ�ջ��������ջ����������
	 * @param list
	 * @return
	 */
	public static  int calculate(List<String> list){
		Stack<String> stack = new Stack<>();
		for (String item: list) {
			//����ȡ��������ʽ��ȡ������
			if (item.matches("\\d+")){
				//��ջ
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
					throw new RuntimeException("���������");
				}
				stack.push("" + res);
			}
		}
		return Integer.parseInt(stack.pop());
	}

	/**
	 * ��׺�ַ��� תΪ ��׺ArrayList
	 * @param s
	 * @return
	 */
	public static List<String > toInfixExpressionList(String s){
		List<String> list = new ArrayList<>(); //�����׺���ʽ��Ӧ������
		int i = 0; //ָ�룬���ڱ�����׺���ʽ�ַ���
		String str; //��λ��ƴ��
		char c;
		do {
			//
			if ((c = s.charAt(i)) < 48 || (c = s.charAt(i)) > 57){
				list.add("" + c);
				i++;
			}else { //�����һ����
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
	 * ��׺ת��׺
	 * todo :  1)��ʼ������ջ�������ջs1�ʹ����м�����ջs2:
		 * 2)��������ɨ����׺���ʽ��
		 * 3)����������ʱ������ѹs2:
		 * 4)���������ʱ���Ƚ�����s1ջ������������ȼ���
		 * 1���s1Ϊ�գ���ջ�������Ϊ�����š�(������ֱ�ӽ����������ջ��
		 * 2.���������ȼ���ջ��������ĸߣ�Ҳ�������ѹ��s1:
		 * 3.���򣬽�s1ջ���������������ѹ�뵽s2�У��ٴ�ת��(4-1)��s1���µ�ջ���������Ƚϣ�
		 * 5)��������ʱ��
		 * (1)����������š�(������ֱ��ѹ��s1
		 * (2)����������š�)���������ε���s1ջ�������������ѹ��s2,ֱ������������Ϊֹ����ʱ����һ�����Ŷ���
		 * 6)�ظ�����2��5��ֱ�����ʽ�����ұ�
		 * 7)��s1��ʣ�����������ε�����ѹ��s2
		 * 8)���ε���s2�е�Ԫ�ز���������������Ϊ��׺���ʽ��Ӧ�ĺ�׺���ʽ
	 * @param infixList
	 * @return
	 */
	public static List<String> toSuffix(List<String> infixList){
		Stack<String> s1 = new Stack<>(); //����ջ
//		Stack<String> s2 = new Stack<>();
		 /*
		 ����s2ջ pop()�������٣�������跴ת��Ϊ�鷳����˸�ʹ��Arrayist<>()
		  */
		List<String> s2 = new ArrayList<>();
		for (String item: infixList){
			if (item.matches("\\d+")){ //���ɨ�赽��������
				s2.add(item);
			}else if (item.equals("(")){ //���ɨ�赽����������
				s1.push(item);
			} else if (item.equals(")")) {//���ɨ�����������
				while ( !s1.peek().equals("(") ){
					s2.add(s1.pop());
				}
				s1.pop();
			}else { //ɨ����������

				/* ��������ʱ��
				 * 1���s1Ϊ�գ���ջ�������Ϊ�����š�(������ֱ�ӽ����������ջ��
				 * 2.���������ȼ���ջ��������ĸߣ�Ҳ�������ѹ��s1:
				 * 3.���򣬽�s1ջ���������������ѹ�뵽s2�У��ٴ�ת��(4-1)��s1���µ�ջ���������Ƚϣ�
				 */
//				//�������ȼ��Ƚϵ�item�����ȼ�С��ջ�������ȼ�ʱ
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
		//��s1��ʣ������������s2
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