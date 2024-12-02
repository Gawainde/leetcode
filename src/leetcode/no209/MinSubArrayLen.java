package leetcode.no209;

public class MinSubArrayLen {

    //给定一个含有n个正整数的数组和一个正整数 target。找出该数组中满足其总和大于等于 target 的长度最小的子数组
    // [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5};
        System.out.println(minSubArrayLen(11, nums));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int sum = 0, result = nums.length;
        boolean flag = false;
        //不断移动右指针
        for (int right = 0, left = 0; right < nums.length; right++) {
            //计算总和
            sum += nums[right];
            //如果总和大于target 移动左指针
            while (sum >= target) {
                //判断最大长度
                result = Math.min(result, right - left + 1);
                //移动左指针，判断sum是否还大于target
                sum = sum - nums[left];
                left++;
                flag = true;
            }
        }
        return flag ? result : 0;
    }
}
