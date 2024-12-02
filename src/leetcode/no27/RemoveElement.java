package leetcode.no27;

public class RemoveElement {

    //给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素。元素的顺序可能发生改变。然后返回 nums 中与 val 不同的元素的数量。
    //假设 nums 中不等于 val 的元素数量为 k，要通过此题，您需要执行以下操作：
    //更改 nums 数组，使 nums 的前 k 个元素包含不等于 val 的元素。nums 的其余元素和 nums 的大小并不重要。
    //返回 k。
    public static void main(String[] args) {
        int[] nums = new int[]{0,1,2,2,3,0,4,2};
        System.out.println(removeElement(nums, 2));
    }

    public static int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        //使用双指针 a指针用于获取数组的值 b指针指向数组的下标
        int b = 0;
        for (int a = 0; a < nums.length; a++) {
            //由于题目需要数组前k个元素均为不等于val的元素 因此当值不等于val时，将该值覆盖到当前下标位置
            if (nums[a] != val){
                nums[b] = nums[a];
                b++;
            }
        }
        return b;
    }
}
