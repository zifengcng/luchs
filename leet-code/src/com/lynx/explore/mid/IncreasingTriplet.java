package com.lynx.explore.mid;

/**
 * @Author cheng
 * @Date 2020/8/10
 * 递增的三元子序列
 * 给定一个未排序的数组，判断这个数组中是否存在长度为 3 的递增子序列。
 * <p>
 * 数学表达式如下:
 * <p>
 * 如果存在这样的 i, j, k,  且满足 0 ≤ i < j < k ≤ n-1，
 * 使得 arr[i] < arr[j] < arr[k] ，返回 true ; 否则返回 false 。
 * 说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1) 。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3,4,5]
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: [5,4,3,2,1]
 * 输出: false
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xvvuqg/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class IncreasingTriplet {

    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        int[] stack = new int[3];
        int[] temp = new int[2];

        boolean flag = false;
        int ptr = 0;
        for (int num : nums) {
            if (flag && temp[1] < num) {
                return true;
            }

            int c = 0;
            while (ptr > 0 && stack[ptr - 1] >= num) {
                ptr--;
                c++;
            }
            if (c == 2) {
                temp[0] = stack[0];
                temp[1] = stack[1];
                flag = true;
            }
            stack[ptr++] = num;
            if (ptr == 3) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        IncreasingTriplet increasingTriplet = new IncreasingTriplet();
        int[] nums = {1, 5, 2, 5, 2};
        boolean b = increasingTriplet.increasingTriplet(nums);
        System.out.println(b);
    }
}
