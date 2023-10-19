package Algorithm.test;
/*
解决升序数组，重复值删除问题，返回不重复元素个数k。
* */
public  class  removeDuplicates{
    public int removeDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int k = 1; // 记录唯一元素的个数，初始为1，因为第一个元素肯定是唯一的
        int left = 0; // 指向当前待填入元素的位置

        for (int right = 1; right < nums.length; right++) {
            if (nums[right] != nums[left]) {
                nums[++left] = nums[right];
                k++;
            }
        }

        return k;
    }

    public static void main(String[] args) {
        int [] nums ={1,2,2,3};
        removeDuplicates solution = new removeDuplicates();
        int  k =  solution.removeDuplicate(nums);
        System.out.println(k);
    }
}

