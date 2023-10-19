package Algorithm.Greedy_Method;
//柠檬水找零问题
public class p2 {
    //定义判断是否能找零的方法lemonadeChange
    public static boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for (int bill : bills) {
            if (bill == 5) {
                five++;
            } else if (bill == 10) {
                if (five == 0) {
                    return false;
                }
                five--;
                ten++;
            } else { // bill == 20
                if (ten > 0 && five > 0) {
                    ten--;
                    five--;
                } else if (five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
    //调用方法
    public static void main(String[] args) {
        int bills[]={5,5,5,10,20}; //输入例子数据
        System.out.println(lemonadeChange(bills));
    }
}
