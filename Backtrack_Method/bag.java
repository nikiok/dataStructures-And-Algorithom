package Algorithm.Backtrack_Method;

public class bag {
    private static int maxWeight; // �������������
    private static int[] weight;  // ��Ʒ����������
    private static int[] value;   // ��Ʒ�ļ�ֵ����
    private static int n;     //��Ʒ����
    private static int maxValue; //�ܹ�װ�뱳��������ֵ

    public static void main(String[] args) {
        maxWeight=50;
        weight=new int[]{16,15,15,19};
        value=new int[]{45,25,25,19};
//        weight=new int[]{16,15,15};
//        value=new int[]{45,25,25};
        n=weight.length;
        backtrack(0,0,0);
        System.out.println("�ܹ�װ�뱳��������ֵΪ��"+maxValue);
    }
    private static void backtrack(int i,int w,int v){
        if(i==n){ //������Ʒ���Ѿ����������
            if (v>maxValue){
                maxValue=v;
            }
            return;
        }
        if (w+weight[i]<=maxWeight){ // ѡ���i����Ʒ���뱳����
            backtrack(i+1,w+weight[i],v+value[i]);
        }
        backtrack(i+1,w,v);
    }

}
