package Algorithm.Get_started;

public class digui {
    //�ݹ����
    public static int sum(int n){
        if (n>=1){
            return sum(n-1)+n;
         }
        return  n;
    }

    //ѡ������
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
        System.out.println(sum(10)); //�ݹ����
        //ѡ������
        int []arr={4,32,81,5}; //��������
        for(int x:Selsort(arr,0,arr.length)){ //����ѡ������
            System.out.print(x+" "); //��ӡ���
        }
    }
}


