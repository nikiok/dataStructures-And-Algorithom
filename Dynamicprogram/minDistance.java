package Algorithm.Dynamicprogram;
// ��̬�滮 ���ͼ�����·��
public class minDistance {
    static int n = 10;

    static int [][] node =  new int [][]{
            //0,1,2,3,4,5,6,7,8,9
            {0,4,1,0,0,0,0,0,0,0},
            {0,0,0,0,9,8,0,0,0,0},
            {0,0,0,1,6,0,8,0,0,0},
            {0,0,0,0,0,4,7,0,0,0},
            {0,0,0,0,0,0,0,5,6,0},
            {0,0,0,0,0,0,0,8,6,0},
            {0,0,0,0,0,0,0,0,5,0},
            {0,0,0,0,0,0,0,0,0,7},
            {0,0,0,0,0,0,0,0,0,3},
            {0,0,0,0,0,0,0,0,0,0}
            //0�Ŷ��㵽���������������� ��0 ���ɴ� >0 �ɴ�ľ���
    };
    static int [] d;
    static int [] s;
    // ��ȡ����peak�Ŀɴﶥ��
    public static int getPath(int peak, int[] p){
       int pNum = 0;
       for (int i = 0;i < n;i++){
           if (node[i][peak] > 0){
               p[pNum++] = i;
           }
       }
       return pNum;
    }
    // ��ȡ�߳�
    public static int getLine(int x, int y) {
        return node[x][y];
    }
    static void getselectPeak(int peak){
        if (peak == 0){
            return;
        }
        int pNum = 0;
        int []p = new int[n];
        pNum = getPath(peak,p);
        int x =0;
        for (int i= 0;i < pNum;i++){
            x = p[i];
            if (d[x] +getLine(x,peak) == d[peak]){
                s[x] = 1;
                break;
            }
        }
        getselectPeak(x);
    }
    static void dp(int n){
        d[0] = 0;
        for (int i =1;i < n;i++){
            int min = 10000;
            int [] p = new int[n];
            int pNum = 0;
            pNum = getPath(i,p);
            for (int j = 0;j < pNum;j++){
                int t = d[p[j]] + getLine(p[j],i);
                min = Math.min(t, min);
            }
            d [i] = min;
        }
        getselectPeak(n-1);
    }

    public static void main(String[] args) {
        dp(10);
        s [0] = 1;
        s [9] = 1;
        for (int i =0;i <n;i++){
            if (s[i]==1){
                System.out.printf("%d",i);
            }
        }
    }
}
