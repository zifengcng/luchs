package com.lynx.explore.high;

import java.util.Arrays;

/**
 * @Author cheng
 * @Date 2020/8/25
 * 除自身以外数组的乘积
 * 给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3,4]
 * 输出: [24,12,8,6]
 *  
 * <p>
 * 提示：题目数据保证数组之中任意元素的全部前缀元素和后缀（甚至是整个数组）的乘积都在 32 位整数范围内。
 * <p>
 * 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 * <p>
 * 进阶：
 * 你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-hard/xw8dz6/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class ProductExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return nums;
        }
        int[] before = new int[len];
        int[] end = new int[len];

        before[0] = 1;
        for (int i = 1; i < len; i++) {
            before[i] = before[i - 1] * nums[i - 1];
        }

        end[len - 1] = 1;
        for (int i = len - 1 - 1; i >= 0; i--) {
            end[i] = end[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < len; i++) {
            nums[i] = before[i] * end[i];
        }
        return nums;
    }

    public static void main(String[] args) {
        ProductExceptSelf self = new ProductExceptSelf();
        int[] nums = {1, 2, 3, 4};
        int[] res = self.productExceptSelf(nums);
        System.out.println(Arrays.toString(res));
    }
}
