package Algorithm.Divided_Method;

//�������СԪ������
public class p1 {

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

    public static void main(String[] args) {
        int arr[]={433,5,32,11,701};
        int low=0;
        int high=arr.length-1;
        System.out.println("����ǰ������Ϊ��");
        for(int x:arr){
            System.out.print(x+" ");
        }
        System.out.println("\n");
        System.out.println("����������Ϊ��");
        for(int x: sort(arr,low,high)){
            System.out.print(x + "  ");
        }
        System.out.println("\n");
        System.out.println("���Ԫ��Ϊ:"+arr[high]);
        System.out.println("��СԪ��Ϊ:"+arr[low]);

    }

}
