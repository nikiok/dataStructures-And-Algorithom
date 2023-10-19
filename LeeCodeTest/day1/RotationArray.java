package Algorithm.LeeCodeTest.day1;

/**
 * -----------------------------------------------
 *
 * @author £ºniki
 * @date £ºCreated in 2023/9/23 20:38
 * @description£ºÂÖ×ªÊý×é
 * @version: $
 * -----------------------------------------------
 */
public class RotationArray {
	public void rotate(int[] nums, int k) {
		int n = nums.length;
		k = k % n;
		int ans[] = new int[n];
		for (int i = 0; i < n; i++) {
			ans[(i + k) % n] = nums[i];
		}
		for (int i = 0; i < n; i++) {
			System.out.print(ans[i] + "\t");
		}
	}

	public static void main(String[] args) {
//		System.out.println(3 % 7);
		RotationArray rotationArray = new RotationArray();
		int []nums = new int[]{1,2,3,4,5,6,7};
		int k = 3;
		rotationArray.rotate(nums,k);
	}

}

