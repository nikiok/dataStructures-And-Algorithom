package Algorithm.Get_started;

public class gys {
    //ŷ������㷨--շת������������Լ����
    public static int gys(int a,int b) {
        if (b==0){
            return a;
        }else {
            return gys(b,a%b);
        }
    }

    //�����������
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
