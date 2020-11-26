package com.lynx.explore.primary;

/**
 * @Author cheng
 * @Date 2020/8/10
 * 缺失数字
 * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,0,1]
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: [9,6,4,2,3,5,7,0,1]
 * 输出: 8
 *  
 * <p>
 * 说明:
 * 你的算法应具有线性时间复杂度。你能否仅使用额外常数空间来实现?
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnj4mt/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class MissingNumber {

    public int missingNumber(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] != -1) {
                int next = nums[i];
                while (true) {
                    if (next == len || next == -1) {
                        break;
                    }
                    int t = nums[next];
                    nums[next] = -1;
                    next = t;
                }
            }
        }
        for (int i = 0; i < len; i++) {
            if (nums[i] != -1) {
                return i;
            }
        }
        return len;
    }

    public static void main(String[] args) {
        MissingNumber missingNumber = new MissingNumber();
        int[] nums = {2, 0};
        int i = missingNumber.missingNumber(nums);
        System.out.println(i);
    }
}
