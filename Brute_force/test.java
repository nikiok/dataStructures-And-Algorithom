package Algorithm.Brute_force;
import java.util.ArrayList;
public class test {
        public static ArrayList<Integer> intersection(int[] nums1, int[] nums2) {
            ArrayList<Integer> result = new ArrayList<>();

            // 遍历 nums1 数组
            for (int i = 0; i < nums1.length; i++) {

                // 遍历 nums2 数组
                for (int j = 0; j < nums2.length; j++) {

                    // 如果找到了相同的元素
                    if (nums1[i] == nums2[j]) {

                        // 如果该元素不在结果集中，则添加到结果集中
                        if (!result.contains(nums1[i])) {
                            result.add(nums1[i]);
                        }
                        break;
                    }
                }
            }

            return result;
        }

        public static void main(String[] args) {
            int[] nums1 = {1, 2, 2, 1};
            int[] nums2 = {2, 2};
            ArrayList<Integer> result = intersection(nums1, nums2);
            System.out.println(result);  // 输出 [2]
        }

}
