package Algorithm.test;
/*
����������飬�ظ�ֵɾ�����⣬���ز��ظ�Ԫ�ظ���k��
* */
public  class  removeDuplicates{
    public int removeDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int k = 1; // ��¼ΨһԪ�صĸ�������ʼΪ1����Ϊ��һ��Ԫ�ؿ϶���Ψһ��
        int left = 0; // ָ��ǰ������Ԫ�ص�λ��

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

