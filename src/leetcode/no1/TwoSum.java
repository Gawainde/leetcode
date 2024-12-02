package leetcode.no1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 10, 7, 11, 15};
        int[] ints = twoSum(nums, 25);
        System.out.println(Arrays.toString(ints));
    }

    //给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            //如果存在 则代表map中存在与当前nums[i]相加为target的key 输出二者的下标即可
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            //如果不存在 记录key为当前nums[i]  value为下标
            map.put(nums[i], i);
        }
        //不要忘记如果没有匹配的返回一个空数组
        return new int[0];
    }
}
