package Algorithm.Brute_force;
import java.util.ArrayList;
public class test {
        public static ArrayList<Integer> intersection(int[] nums1, int[] nums2) {
            ArrayList<Integer> result = new ArrayList<>();

            // ���� nums1 ����
            for (int i = 0; i < nums1.length; i++) {

                // ���� nums2 ����
                for (int j = 0; j < nums2.length; j++) {

                    // ����ҵ�����ͬ��Ԫ��
                    if (nums1[i] == nums2[j]) {

                        // �����Ԫ�ز��ڽ�����У�����ӵ��������
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
            System.out.println(result);  // ��� [2]
        }

}
