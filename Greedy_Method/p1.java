package Algorithm.Greedy_Method;

import java.util.Scanner;

// ������������
public class p1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("������˿����ѽ�");
        int cost=sc.nextInt();
        int change=100-cost; //�һص�Ǯ��
        int[] notes = {100, 50, 20, 5, 1};  // ���õ�ֽ�����
        int[] nums = new int[notes.length];  // ��Ӧֽ����������
        for (int i = 0; i < notes.length; i++) {
            nums[i] = change / notes[i];  // ������Ҫ�һض�Ӧ����ֽ������
            change %= notes[i];  // ������Ҫ�һص�Ǯ��
        }
        System.out.println("��Ҫ�һص�Ǯ��Ϊ��");
        for (int i = 0; i < notes.length; i++) {
            if (nums[i] > 0) {
                System.out.println(notes[i] + "Ԫֽ�� " + nums[i] + "��");
            }
        }
    }
}
