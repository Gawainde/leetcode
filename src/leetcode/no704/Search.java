package leetcode.no704;

//二分查找
public class Search {

    //给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 3, 5, 9};
        int[] num = new int[]{-1, 0, 3, 5, 7, 9, 12, 16, 20, 21};
        System.out.println(search(nums, 9));
        System.out.println(search(num, -1));
    }

    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (right + left) >>> 1;
            if (nums[mid] == target){
                return mid;
            } else if (nums[mid] > target){
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
