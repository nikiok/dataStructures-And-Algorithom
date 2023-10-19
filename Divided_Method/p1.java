package Algorithm.Divided_Method;

//求最大最小元素问题
public class p1 {

    public static int[] sort(int[] arr,int low,int high){       //递归排序函数

        if(low < high){                             //判断第未排序的元素的下标是否已经到了倒数第二个
            int indexMin = low;                     //indexMin记录未排序的最小数组小标，
            int min = arr[indexMin];                //min记录最小该下标的元素值
            for(int i = indexMin+1;i < high; i++){  //indexMin后面的元素依次与min进行比较，若存在小于min的数，交换位置
                if(min > arr[i]){
                    arr[indexMin] = arr[i];
                    arr[i] = min;
                    min = arr[indexMin];
                }
            }
            return sort(arr,low + 1,high);      //找出最小的数后，把未排序的最小下标+1，递归继续进行排序
        }
        return arr;
    }

    public static void main(String[] args) {
        int arr[]={433,5,32,11,701};
        int low=0;
        int high=arr.length-1;
        System.out.println("排序前的数组为：");
        for(int x:arr){
            System.out.print(x+" ");
        }
        System.out.println("\n");
        System.out.println("排序后的数组为：");
        for(int x: sort(arr,low,high)){
            System.out.print(x + "  ");
        }
        System.out.println("\n");
        System.out.println("最大元素为:"+arr[high]);
        System.out.println("最小元素为:"+arr[low]);

    }

}
