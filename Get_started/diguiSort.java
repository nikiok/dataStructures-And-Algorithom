package Algorithm.Get_started;
import java.util.Scanner;

public class diguiSort {
    //�ݹ�ѡ������,��С����
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        System.out.println("������һ������ n �����ڽ���һ������Ϊn���������");
        int n = input.nextInt();
        int[] arr = new int[n];
        for(int i = 0;i < arr.length;++i){
            arr[i] =(int)( Math.random()*100);
        }

        System.out.println("����ǰ������Ԫ������Ϊ��");
        for(int x: arr){
            System.out.print(x + "  ");
        }
        System.out.println();

//        sort(arr,0,arr.length-1);           //����������sort
        System.out.println("����������Ԫ������Ϊ��");
        for(int x: sort(arr,0,arr.length-1)){
            System.out.print(x + "  ");
        }
    }

    public static int[] sort(int[] arr,int low,int high){       //�ݹ�������

        if(low < high){                             //�жϵ�δ�����Ԫ�ص��±��Ƿ��Ѿ����˵����ڶ���
            int indexMin = low;                     //indexMin��¼δ�������С����С�꣬
            int min = arr[indexMin];                //min��¼��С���±��Ԫ��ֵ
            for(int i = indexMin+1;i < high; i++){  //indexMin�����Ԫ��������min���бȽϣ�������С��min����������λ��
                if(min > arr[i]){
                    arr[indexMin] = arr[i];
                    arr[i] = min;
                    min = arr[indexMin];
                }
            }
            return sort(arr,low + 1,high);      //�ҳ���С�����󣬰�δ�������С�±�+1���ݹ������������
        }
        return arr;
    }
}

