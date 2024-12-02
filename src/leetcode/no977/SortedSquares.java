package leetcode.no977;

import java.util.Arrays;

public class SortedSquares {

    //给你一个按非递减顺序排序的整数数组nums，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
    public static void main(String[] args) {
        int[] nums = new int[]{-4, -1, 0, 3, 10};
        System.out.println(Arrays.toString(sortedSquares(nums)));
    }

    //非递减：允许有重复值的递增排序  由于可能存在负数 那么平方后的最大值一定是在最左/最右边
    public static int[] sortedSquares(int[] nums) {
        if (nums == null || nums.length == 0){
            return new int[0];
        }
        //定义左边界，右边界和新数组的下标  由于题目要求新数组非递减排序 因此最大值需要放在最后
        //新数组从后往前赋值
        int left = 0, right, flag = right = nums.length - 1;
        int[] result = new int[nums.length];
        //老数组从两边开始往中间计算
        while (left <= right){
            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];
            if (leftSquare >= rightSquare){
                result[flag--] = leftSquare;
                left++;
            } else {
                result[flag--] = rightSquare;
                right--;
            }
        }
        return result;
    }
}
