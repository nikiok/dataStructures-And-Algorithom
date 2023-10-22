package Algorithm.Reflect;

import java.lang.reflect.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

/**
 * @author ：niki
 * @version :     $
 * @date ：Created in 2023/10/20 14:35
 * @description ： 深入理解Java反射
 */
public class ReflectionTest {
	public static void main(String[] args) {
		String name;
		if (args.length >0) name = args[0];
		else {
			Scanner in = new Scanner(System.in);
			System.out.println("输入类名(e.g. java.util.Date): ");
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
	 * 打印一个类或对象的所有构造器信息
	 * @param cl  : 表示类/对象
	 */
	public static void printConstructors(Class cl){
		Constructor[] constructors = cl.getDeclaredConstructors();
		for (Constructor c : constructors){
			String name = c.getName();
			System.out.print(" ");
			// getModifiers()：返回此类或接口以整数编码的 Java 语言修饰符
			String modifiers = Modifier.toString(c.getModifiers());
			if (modifiers.length() > 0) System.out.print(modifiers + " ");
			System.out.print(name + "(" );

			//打印参数的类型
			Class[] paramTypes = c.getParameterTypes();
			for (int j = 0; j < paramTypes.length; j++) {
				if (j > 0) System.out.print(",");
				System.out.print(paramTypes[j].getName());
			}
			System.out.println(");");
		}
	}

	/**
	 * 打印一个类中所有方法信息
	 * @param cl
	 */
	public static void printMethods(Class cl){
		Method[] methods = cl.getDeclaredMethods();
		for (Method m : methods) {
			Class retType = m.getReturnType();
			String name = m.getName();
			System.out.print(" ");

			//打印权限修饰符，返回类型和方法名
			String modifiers = Modifier.toString(m.getModifiers());
			if (modifiers.length() > 0) System.out.print(modifiers + " ");
			System.out.print(retType.getName() + " " + name + "(");

			//打印方法中参数的类型
			Class[] paramTypes = m.getParameterTypes();
			for (int i = 0; i < paramTypes.length; i++) {
				if (i > 0) System.out.print(", ");
				System.out.print(paramTypes[i].getName());
			}
			System.out.println(");");
		}
	}

	/**
	 * 打印一个类的所有成员变量信息
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


