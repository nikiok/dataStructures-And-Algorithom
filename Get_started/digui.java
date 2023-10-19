package Algorithm.Get_started;

public class digui {
    //递归求和
    public static int sum(int n){
        if (n>=1){
            return sum(n-1)+n;
         }
        return  n;
    }

    //选择排序法
    public static int[] Selsort(int[] array, int low, int high) {
        if (low<high){
            int indexMin=low;
            int min=array[indexMin];
            for(int i=indexMin+1;i<high;i++){
                if (min>array[i]){
                    array[indexMin]=array[i];
                    array[i]=min;
                    min=array[indexMin];
                }
            }
            return Selsort(array,low+1,high);
        }
        return array;
    }

    public static void main(String[] args) {
        System.out.println(sum(10)); //递归求和
        //选择排序法
        int []arr={4,32,81,5}; //声明数组
        for(int x:Selsort(arr,0,arr.length)){ //调用选择排序法
            System.out.print(x+" "); //打印结果
        }
    }
}


