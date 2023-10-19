package Algorithm.Greedy_Method;

import java.util.Arrays;
import java.util.Comparator;

// ��������
//public class p3 {
//    public static void main(String[] args) {
//        int N = 5; // ��Ʒ����
//        int C = 10; // ��������
//        int[] w = {5, 2, 3, 6, 3}; // ��Ʒ����
//        int[] v = {5, 5, 6, 9, 8}; // ��Ʒ��ֵ
//        double[] ratio = new double[N]; // ��¼��Ʒ���Լ۱�
//        for (int i = 0; i < N; i++) {
//            ratio[i] = (double) v[i] / w[i]; // �����Լ۱�
//        }
//        // ����Ʒ�����Լ۱ȴӴ�С����
//        int[] index = new int[N];
//        for (int i = 0; i < N; i++) {
//            index[i] = i;
//        }
//
//        // ̰��ѡ����Ʒ
//        int weight = 0; // ��ǰ��������Ʒ��������
//        int value = 0; // ��ǰ��������Ʒ���ܼ�ֵ
//        for (int i = 0; i < N; i++) {
//            if (weight + w[index[i]] <= C) { // ��ǰ��Ʒ����ȫ�����뱳��
//                weight += w[index[i]];
//                value += v[index[i]];
//            } else { // ��ǰ��Ʒֻ�ܷ���һ����
//                value += ratio[index[i]] * (C - weight);
//                break;
//            }
//        }
//        System.out.println("��������Ʒ���ܼ�ֵΪ��" + value);
//    }
//}

public class p3 {
    public static void main(String[] args) {
        int n = 5; //��Ʒ����
        int c = 10; //��������
        int[] w = {5, 2, 3, 6, 3}; //��Ʒ����
        int[] v = {5, 5, 6, 9, 8}; //��Ʒ��ֵ
        double[] p = new double[n];
        for (int i = 0; i < n; i++) {
            p[i] = (double) v[i] / w[i];
        }
        Integer[] index = new Integer[n];
        for (int i = 0; i < n; i++) {
            index[i] = i;
        }
        // ���Լ۱�����
        Arrays.sort(index, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Double.compare(p[o2], p[o1]);
            }
        });
        int used = 0;
        double res = 0;
        //����۸�
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
        System.out.println("��������Ʒ���ܼ�ֵΪ:"+res);
    }
}