package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LengthOfLongestSubstring {

    //给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串的长度。
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcaopsmjbc"));
        System.out.println(lengthOfLongestSubstring2("abba"));
    }

    //滑动窗口
    public static int lengthOfLongestSubstring(String s) {
        char[] array = s.toCharArray();
        //去重
        Set<Character> set = new HashSet<>();
        //结果
        int res = 0;
        //外层循环扩展右边界，内层循环扩展左边界
        //每一轮右边界都扩一个。
        for (int left = 0, right = 0; right < s.length(); right++) {
            //right指向的元素，即当前元素
            char ch = array[right];
            //set中有ch，则有重复字符了（第一个进入set的字符） 缩短左边界，同时从set集合出元素
            while (set.contains(ch)) {
                set.remove(array[left]);
                left++;
            }
            //将当前元素加入
            set.add(array[right]);
            //计算当前不重复子串的长度
            res = Math.max(res, right - left + 1);
        }
        return res;
    }

    public static int lengthOfLongestSubstring2(String s) {
        char[] array = s.toCharArray();
        //k为字符  v为当前字符位置 + 1  代表从左边界位置到当前位置开始后1个不重复
        // 如abcabc a,1 代表从左边界位置到a不重复  b,2  代表从左边界位置到ab不重复  c,3  代表从左边界位置到abc不重复
        Map<Character, Integer> map = new HashMap<>();
        int result = 0;
        //循环扩展右边界
        for (int left = 0, right = 0; right < array.length; right++) {
            char c = array[right];
             if (map.containsKey(c)) {
                //如果map中存在该字符 则意味着已经出现重复字符 需要更新左边界的位置 以保证在[left,right]区间内不会有重复的字符
                left = Math.max(map.get(c), left);
            }
            result = Math.max(result, right - left + 1);
            map.put(s.charAt(right), right + 1);
        }
        return result;
    }
}
