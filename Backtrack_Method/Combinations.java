package Algorithm.Backtrack_Method;

import java.util.*;

public class Combinations {
    public static void main(String[] args) {
        List<List<Integer>> combinations = combine(4, 2);
        System.out.println(combinations);
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        combineHelper(n, k, 1, combination, result);
        return result;
    }

    public static void combineHelper(int n, int k, int start, List<Integer> combination, List<List<Integer>> result) {
        if (combination.size() == k) {
            result.add(new ArrayList<>(combination));
            return;
        }

        for (int i = start; i <= n; i++) {
            combination.add(i);
            combineHelper(n, k, i + 1, combination, result);
            combination.remove(combination.size() - 1);
        }
    }
}
