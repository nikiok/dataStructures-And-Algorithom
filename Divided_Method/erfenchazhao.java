package Algorithm.Divided_Method;


//���ֲ��ҷ�
public class erfenchazhao {
    //���η���Ŀ��ֵ�±�
    public static int binarySearch(int[] arr,int target){
        /*
           [] arr:Ҫ���ҵ�����
           target:Ҫ���ҵ�Ŀ��ֵ
        */
        int left=0, right=arr.length-1;   //left ������ʼ�±� �� right ����ĩβ�±�
        while (left<=right){
            int mid=left+(right-left)/2; //ȡ�м��±�
            if (arr[mid]==target){ //�ж� ������ʵ��
                return mid; //�����±�
            } else if (arr[mid]<target) {
                left=mid+1;
            }else {
                right = mid -1;
            }
        }
        return -1;//����-1��ʾδ�ҵ�
    }


   // ���η������ֵ�ʹδ�ֵ
    public static void findMaxAndSecondMax(int[] arr) {
        int[] max = findMaxAndSecondMaxRecursive(arr, 0, arr.length - 1);
        System.out.println("���ֵ: " + max[0] + ", �δ�ֵ: " + max[1]);
    }

        private static int[] findMaxAndSecondMaxRecursive(int[] arr, int left, int right) {
            if (left == right) { // ����ֻ��һ��Ԫ��
                return new int[] { arr[left], Integer.MIN_VALUE };
            }
            if (left + 1 == right) { // ����������Ԫ��
                if (arr[left] > arr[right]) {
                    return new int[] { arr[left], arr[right] };
                } else {
                    return new int[] { arr[right], arr[left] };
                }
            }
            // ���������������ϵ�Ԫ��
            int mid = left + (right - left) / 2;
            int[] maxLeft = findMaxAndSecondMaxRecursive(arr, left, mid);
            int[] maxRight = findMaxAndSecondMaxRecursive(arr, mid + 1, right);
            int max, secondMax;
            if (maxLeft[0] > maxRight[0]) {
                max = maxLeft[0];
                secondMax = Math.max(maxLeft[1], maxRight[0]);
            } else {
                max = maxRight[0];
                secondMax = Math.max(maxRight[1], maxLeft[0]);
            }
            return new int[] { max, secondMax };
        }


    public static void main(String[] args) {
        //1.
        int [] arr2={441,4,22,34,66,334};
        int index=binarySearch(arr2,334);
        if(index==-1){
            System.out.println("���޴���");
        }else {
            System.out.println("��Ŀ��ֵ���±�Ϊ��"+ index);

       //2.
        int [] arr1={2,434,5,8,101,32};
        findMaxAndSecondMax(arr1);
        }
    }
}
