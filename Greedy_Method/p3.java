package Algorithm.Greedy_Method;

import java.util.Arrays;
import java.util.Comparator;

// 背包问题
//public class p3 {
//    public static void main(String[] args) {
//        int N = 5; // 物品数量
//        int C = 10; // 背包容量
//        int[] w = {5, 2, 3, 6, 3}; // 物品重量
//        int[] v = {5, 5, 6, 9, 8}; // 物品价值
//        double[] ratio = new double[N]; // 记录物品的性价比
//        for (int i = 0; i < N; i++) {
//            ratio[i] = (double) v[i] / w[i]; // 计算性价比
//        }
//        // 对物品按照性价比从大到小排序
//        int[] index = new int[N];
//        for (int i = 0; i < N; i++) {
//            index[i] = i;
//        }
//
//        // 贪心选择物品
//        int weight = 0; // 当前背包中物品的总重量
//        int value = 0; // 当前背包中物品的总价值
//        for (int i = 0; i < N; i++) {
//            if (weight + w[index[i]] <= C) { // 当前物品可以全部放入背包
//                weight += w[index[i]];
//                value += v[index[i]];
//            } else { // 当前物品只能放入一部分
//                value += ratio[index[i]] * (C - weight);
//                break;
//            }
//        }
//        System.out.println("背包中物品的总价值为：" + value);
//    }
//}

public class p3 {
    public static void main(String[] args) {
        int n = 5; //物品数量
        int c = 10; //背包数量
        int[] w = {5, 2, 3, 6, 3}; //物品重量
        int[] v = {5, 5, 6, 9, 8}; //物品价值
        double[] p = new double[n];
        for (int i = 0; i < n; i++) {
            p[i] = (double) v[i] / w[i];
        }
        Integer[] index = new Integer[n];
        for (int i = 0; i < n; i++) {
            index[i] = i;
        }
        // 按性价比排序
        Arrays.sort(index, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Double.compare(p[o2], p[o1]);
            }
        });
        int used = 0;
        double res = 0;
        //计算价格
        for (int i = 0; i < n; i++) {
            int j = index[i];
            if (w[j] + used <= c) {
                used += w[j];
                res += v[j];
            } else {
                int r = c - used;
                res += r * p[j];
                break;
            }
        }
        System.out.println("背包中物品的总价值为:"+res);
    }
}