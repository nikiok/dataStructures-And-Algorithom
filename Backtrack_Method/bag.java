package Algorithm.Backtrack_Method;

public class bag {
    private static int maxWeight; // 背包的最大容量
    private static int[] weight;  // 物品的重量数组
    private static int[] value;   // 物品的价值数组
    private static int n;     //物品个数
    private static int maxValue; //能够装入背包的最大价值

    public static void main(String[] args) {
        maxWeight=50;
        weight=new int[]{16,15,15,19};
        value=new int[]{45,25,25,19};
//        weight=new int[]{16,15,15};
//        value=new int[]{45,25,25};
        n=weight.length;
        backtrack(0,0,0);
        System.out.println("能够装入背包的最大价值为："+maxValue);
    }
    private static void backtrack(int i,int w,int v){
        if(i==n){ //所有物品都已经被处理完毕
            if (v>maxValue){
                maxValue=v;
            }
            return;
        }
        if (w+weight[i]<=maxWeight){ // 选择第i个物品放入背包中
            backtrack(i+1,w+weight[i],v+value[i]);
        }
        backtrack(i+1,w,v);
    }

}
