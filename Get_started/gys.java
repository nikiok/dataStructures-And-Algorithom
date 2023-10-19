package Algorithm.Get_started;

public class gys {
    //欧几里得算法--辗转相除法（求最大公约数）
    public static int gys(int a,int b) {
        if (b==0){
            return a;
        }else {
            return gys(b,a%b);
        }
    }

    //连续整数检测
    public static int gcd(int m,int n){
        int t=Math.min(m,n);
        while (t>0){
            if(m%t==0&&n%t==0){
                return t;
            }
            t--;
        }
        return Math.max(m,n);
    }

    public static void main(String[] args) {
//        System.out.println(gys(18,6));
//        System.out.println(gys(6,9));
        System.out.println(gys(31415,14142));
        System.out.println(gcd(31415,14142));
    }
}
