package Algorithm.Get_started;
import java.util.Scanner;

public class diguiSort {
    //递归选择排序,从小到大
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        System.out.println("请输入一个数字 n ，用于建立一个长度为n的随机数组");
        int n = input.nextInt();
        int[] arr = new int[n];
        for(int i = 0;i < arr.length;++i){
            arr[i] =(int)( Math.random()*100);
        }

        System.out.println("排序前的数组元素依次为：");
        for(int x: arr){
            System.out.print(x + "  ");
        }
        System.out.println();

//        sort(arr,0,arr.length-1);           //调用排序函数sort
        System.out.println("排序后的数组元素依次为：");
        for(int x: sort(arr,0,arr.length-1)){
            System.out.print(x + "  ");
        }
    }

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
}

