package com.lynx.explore.high;

/**
 * @Author cheng
 * @Date 2020/8/26
 * 滑动窗口最大值
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * <p>
 * 返回滑动窗口中的最大值。
 * <p>
 *  
 * <p>
 * 进阶：
 * <p>
 * 你能在线性时间复杂度内解决此题吗？
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 * <p>
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 10^5
 * -10^4 <= nums[i] <= 10^4
 * 1 <= k <= nums.length
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-hard/xw4q0r/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class MaxSlidingWindow {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        if (len * k == 0) {
            return new int[0];
        }
        if (k == 1) {
            return nums;
        }

        int[] left = new int[len];
        int[] right = new int[len];

        left[0] = nums[0];
        right[len - 1] = nums[len - 1];

        for (int i = 1; i < len; i++) {
            // left
            if (i % k == 0) {
                left[i] = nums[i];
            } else {
                left[i] = Math.max(left[i - 1], nums[i]);
            }

            // right
            int j = len - i - 1;
            if ((j + 1) % k == 0) {
                right[j] = nums[j];
            } else {
                right[j] = Math.max(right[j + 1], nums[j]);
            }
        }

        int[] res = new int[len - k + 1];
        for (int i = 0; i < len - k + 1; i++) {
            res[i] = Math.max(left[i + k - 1], right[i]);
        }
        return res;
    }
}
