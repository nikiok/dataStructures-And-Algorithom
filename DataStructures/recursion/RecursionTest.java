package Algorithm.DataStructures.recursion;

/**
 * -----------------------------------------------
 *
 * @author £ºniki
 * @date £ºCreated in 2023/10/18 9:54
 * @description£ºµÝ¹é²âÊÔ
 * @version: $
 * -----------------------------------------------
 */
public class RecursionTest {
	public static void main(String[] args) {
		test(4);
		System.out.println(recursion(4));
	}

	public static void test(int n){ //µÝ¹éÀý×Ó
		if (n > 2){
			test(n - 1);
		}
		System.out.println("n = " + n);
	}
	public static int recursion(int n){ //nµÄ½×³Ë
		if (n == 1){
			return 1;
		}
		return n*recursion(n-1);
	}
}
