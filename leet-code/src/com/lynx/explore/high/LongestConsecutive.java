package com.lynx.explore.high;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author cheng
 * @Date 2020/8/25
 * 最长连续序列
 * 给定一个未排序的整数数组，找出最长连续序列的长度。
 * <p>
 * 要求算法的时间复杂度为 O(n)。
 * <p>
 * 示例:
 * <p>
 * 输入: [100, 4, 200, 1, 3, 2]
 * 输出: 4
 * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-hard/xwgcuv/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class LongestConsecutive {

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int count = 0;
        for (int num : nums) {
            int c = 1;
            if (!set.contains(num)) {
                continue;
            }
            int t = num;
            while (set.contains(--t)) {
                set.remove(t);
                c++;
            }
            t = num;
            while (set.contains(++t)) {
                set.remove(t);
                c++;
            }
            count = Integer.max(count, c);
        }
        return count;
    }
}
