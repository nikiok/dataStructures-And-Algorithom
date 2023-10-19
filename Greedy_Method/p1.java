package Algorithm.Greedy_Method;

import java.util.Scanner;

// 超市找零问题
public class p1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入顾客消费金额：");
        int cost=sc.nextInt();
        int change=100-cost; //找回的钱数
        int[] notes = {100, 50, 20, 5, 1};  // 可用的纸币面额
        int[] nums = new int[notes.length];  // 对应纸币面额的数量
        for (int i = 0; i < notes.length; i++) {
            nums[i] = change / notes[i];  // 计算需要找回对应面额的纸币数量
            change %= notes[i];  // 更新需要找回的钱数
        }
        System.out.println("需要找回的钱数为：");
        for (int i = 0; i < notes.length; i++) {
            if (nums[i] > 0) {
                System.out.println(notes[i] + "元纸币 " + nums[i] + "张");
            }
        }
    }
}
