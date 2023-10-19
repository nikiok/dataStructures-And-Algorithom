package Algorithm.Divided_Method;


//二分查找法
public class erfenchazhao {
    //分治法求目标值下标
    public static int binarySearch(int[] arr,int target){
        /*
           [] arr:要查找的数组
           target:要查找的目标值
        */
        int left=0, right=arr.length-1;   //left 数组起始下标 ； right 数组末尾下标
        while (left<=right){
            int mid=left+(right-left)/2; //取中间下标
            if (arr[mid]==target){ //判断 ，二分实现
                return mid; //返回下标
            } else if (arr[mid]<target) {
                left=mid+1;
            }else {
                right = mid -1;
            }
        }
        return -1;//返回-1表示未找到
    }


   // 分治法求最大值和次大值
    public static void findMaxAndSecondMax(int[] arr) {
        int[] max = findMaxAndSecondMaxRecursive(arr, 0, arr.length - 1);
        System.out.println("最大值: " + max[0] + ", 次大值: " + max[1]);
    }

        private static int[] findMaxAndSecondMaxRecursive(int[] arr, int left, int right) {
            if (left == right) { // 数组只有一个元素
                return new int[] { arr[left], Integer.MIN_VALUE };
            }
            if (left + 1 == right) { // 数组有两个元素
                if (arr[left] > arr[right]) {
                    return new int[] { arr[left], arr[right] };
                } else {
                    return new int[] { arr[right], arr[left] };
                }
            }
            // 数组有三个及以上的元素
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
            System.out.println("查无此数");
        }else {
            System.out.println("该目标值的下标为："+ index);

       //2.
        int [] arr1={2,434,5,8,101,32};
        findMaxAndSecondMax(arr1);
        }
    }
}
