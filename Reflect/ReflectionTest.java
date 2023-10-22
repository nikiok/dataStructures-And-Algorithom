package Algorithm.Reflect;

import java.lang.reflect.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

/**
 * @author ��niki
 * @version :     $
 * @date ��Created in 2023/10/20 14:35
 * @description �� �������Java����
 */
public class ReflectionTest {
	public static void main(String[] args) {
		String name;
		if (args.length >0) name = args[0];
		else {
			Scanner in = new Scanner(System.in);
			System.out.println("��������(e.g. java.util.Date): ");
			name = in.next();
		}
		try {
			Class cl = Class.forName(name);
			Class supercl = cl.getSuperclass();
			String modifiers = Modifier.toString(cl.getModifiers());
			if (modifiers.length() > 0) System.out.print(modifiers + " ");
			System.out.print("class" + name );
			if (supercl != null && supercl != Object.class) System.out.print(" extends" + supercl.getName());

			System.out.println();
			printConstructors(cl);
			System.out.println();
			printMethods(cl);
			System.out.println();
			printFields(cl);
		}
		 catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}

	}

	/**
	 * ��ӡһ������������й�������Ϣ
	 * @param cl  : ��ʾ��/����
	 */
	public static void printConstructors(Class cl){
		Constructor[] constructors = cl.getDeclaredConstructors();
		for (Constructor c : constructors){
			String name = c.getName();
			System.out.print(" ");
			// getModifiers()�����ش����ӿ������������ Java �������η�
			String modifiers = Modifier.toString(c.getModifiers());
			if (modifiers.length() > 0) System.out.print(modifiers + " ");
			System.out.print(name + "(" );

			//��ӡ����������
			Class[] paramTypes = c.getParameterTypes();
			for (int j = 0; j < paramTypes.length; j++) {
				if (j > 0) System.out.print(",");
				System.out.print(paramTypes[j].getName());
			}
			System.out.println(");");
		}
	}

	/**
	 * ��ӡһ���������з�����Ϣ
	 * @param cl
	 */
	public static void printMethods(Class cl){
		Method[] methods = cl.getDeclaredMethods();
		for (Method m : methods) {
			Class retType = m.getReturnType();
			String name = m.getName();
			System.out.print(" ");

			//��ӡȨ�����η����������ͺͷ�����
			String modifiers = Modifier.toString(m.getModifiers());
			if (modifiers.length() > 0) System.out.print(modifiers + " ");
			System.out.print(retType.getName() + " " + name + "(");

			//��ӡ�����в���������
			Class[] paramTypes = m.getParameterTypes();
			for (int i = 0; i < paramTypes.length; i++) {
				if (i > 0) System.out.print(", ");
				System.out.print(paramTypes[i].getName());
			}
			System.out.println(");");
		}
	}

	/**
	 * ��ӡһ��������г�Ա������Ϣ
	 * @param cl
	 */
	public static void printFields(Class cl){
		Field[] fields = cl.getDeclaredFields();
		for (Field f : fields){
			Class type = f.getType();
			String name = f.getName();
			System.out.print(" ");
			String modifiers = Modifier.toString(f.getModifiers());
			if (modifiers.length() > 0) System.out.print(modifiers + " ");
			System.out.println(type.getName() +"" + name + ";");
		}
	}
}


