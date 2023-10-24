package Algorithm.test;

import java.util.ArrayList;

public class test {
	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<>();
		A.add(1);
		A.add(2);
		ArrayList<Integer> B = A;
		System.out.println(A.hashCode());
		System.out.println(B.hashCode());

		ArrayList<Integer> C = new ArrayList<>();
		for (int i = 0; i < A.size(); i++) {
			C.add(A.get(i));
		}
		System.out.println(C);
		System.out.println(C.hashCode());
	}
}


