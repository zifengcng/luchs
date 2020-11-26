package com.lynx.explore.high;

/**
 * @Author cheng
 * @Date 2020/8/25
 * 缺失的第一个正数
 * 给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,0]
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: [3,4,-1,1]
 * 输出: 2
 * 示例 3:
 * <p>
 * 输入: [7,8,9,11,12]
 * 输出: 1
 *  
 * <p>
 * 提示：
 * <p>
 * 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的额外空间。
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-hard/xwkftg/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            while (nums[i] > 0 && nums[i] <= len && nums[i] != nums[nums[i] - 1]) {
                int t = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = t;
            }
        }
        for (int i = 0; i < len; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return len + 1;
    }
}
