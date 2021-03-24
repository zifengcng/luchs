package com.lynx.everyday;

import com.lynx.common.annotition.MidCode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author cheng
 * @Date 2021/3/24
 * 456. 132模式
 * 给定一个整数序列：a1, a2, ..., an，一个132模式的子序列 ai, aj, ak 被定义为：当 i < j < k 时，ai < ak < aj。设计一个算法，当给定有 n 个数字的序列时，验证这个序列中是否含有132模式的子序列。
 * <p>
 * 注意：n 的值小于15000。
 * <p>
 * 示例1:
 * <p>
 * 输入: [1, 2, 3, 4]
 * <p>
 * 输出: False
 * <p>
 * 解释: 序列中不存在132模式的子序列。
 * 示例 2:
 * <p>
 * 输入: [3, 1, 4, 2]
 * <p>
 * 输出: True
 * <p>
 * 解释: 序列中有 1 个132模式的子序列： [1, 4, 2].
 * 示例 3:
 * <p>
 * 输入: [-1, 3, 2, 0]
 * <p>
 * 输出: True
 * <p>
 * 解释: 序列中有 3 个132模式的的子序列: [-1, 3, 2], [-1, 3, 0] 和 [-1, 2, 0].
 * https://leetcode-cn.com/problems/132-pattern/
 */
@MidCode
public class Find132pattern {

    /**
     * 单调栈
     */
    public boolean find132pattern(int[] nums) {
        int len = nums.length;
        // 存放可以为3的元素
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(nums[len - 1]);

        // 维护2的最大值
        int maxK = Integer.MIN_VALUE;

        for (int i = len - 2; i >= 0; i--) {
            if (nums[i] < maxK) {
                return true;
            }

            // 若当前值大于或等于2则更新2（2为栈中小于当前值的最大元素）
            // 注意这个栈一定是个单调递增的栈，栈顶元素一定是最小的
            // 因为如果某个元素比栈顶元素大，那么栈顶元素就会被弹出。
            // 所以到最后，栈内元素一定是从栈顶到栈底递增的。
            while (!stack.isEmpty() && nums[i] > stack.peek()) {
                maxK = stack.pop();
            }
            if (nums[i] > maxK) {
                stack.push(nums[i]);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Find132pattern f = new Find132pattern();
        //示例 2:
        //
        //输入: [3, 1, 4, 2]
        //
        //输出: True
        //
        //解释: 序列中有 1 个132模式的子序列： [1, 4, 2].
        boolean pattern = f.find132pattern(new int[]{3, 1, 4, 2});
        System.out.println(pattern);

        // [1,3,2,4,5,6,7,8,9,10]
        pattern = f.find132pattern(new int[]{1, 3, 2, 4, 5, 6, 7, 8, 9, 10});
        System.out.println(pattern);
    }
}
