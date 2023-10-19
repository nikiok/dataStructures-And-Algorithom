package Algorithm.Get_started;

//凑算式全排列问题
public class CostEffective {
    static int arr[]=new int[90];
    static int visit[]=new int[90];
    static int count=0;

    public static void main(String[] args) {
        dfs(1);
        System.out.println(count);
    }

    public static void dfs(int i) {
        if (i==10){
            int a=arr[1]*arr[3]*(arr[7]*100+arr[8]*10+arr[9]);
            int b=arr[2]*(arr[7]*100+arr[8]*10+arr[9]);
            int c=(arr[4]*100+arr[5]*10+arr[6])*arr[3];
            int d=(arr[7]*100+arr[8]*10+arr[9])*arr[3];
            if (a+b+c==10*d){
                count++;
            }else {
                return;
            }
        }
        for(int j=1;j<=9;j++){
            if (visit[j]==0){
                visit[j]=1;
                arr[i]=j;
                dfs(i+1);
                visit[j]=0;
            }
        }
    }

}
