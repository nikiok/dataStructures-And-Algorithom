package Algorithm.Brute_force;

import java.util.ArrayList;
import java.util.List;

public class t1 {
    /*���1-5֮��ѡ����3������ȫ����
     * */
    public static List<Integer> pailie(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
        for(int i=0;i<nums.length;i++) {
            int a = nums[i];
            for (int j = 0; j < nums.length; j++) {
                int b = nums[j];
                for (int k = 0; k < nums.length; k++) {
                    int c = nums[k];
                    if (!(a == b | a == c | b == c)) {
//                        list.add(new int[]={a,b,c});
                    }
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int nums[]={1,2,3,4,5};
        System.out.println(pailie(nums));
    }
}
