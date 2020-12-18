package com.lynx.everyday;

import com.lynx.common.annotition.MidCode;

/**
 * @Author cheng
 * @Date 2020/12/15
 * 738. 单调递增的数字
 * 给定一个非负整数 N，找出小于或等于 N 的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。
 * <p>
 * （当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。）
 * <p>
 * 示例 1:
 * <p>
 * 输入: N = 10
 * 输出: 9
 * 示例 2:
 * <p>
 * 输入: N = 1234
 * 输出: 1234
 * 示例 3:
 * <p>
 * 输入: N = 332
 * 输出: 299
 * 说明: N 是在 [0, 10^9] 范围内的一个整数。
 */
@MidCode
public class MonotoneIncreasingDigits {

    public int monotoneIncreasingDigits(int N) {
        char[] nums = String.valueOf(N).toCharArray();
        int len = nums.length;
        int i = 1;
        while (i < len && nums[i - 1] <= nums[i]) {
            i++;
        }
        if (i < len) {
            while (i > 0 && nums[i - 1] > nums[i]) {
                nums[i - 1]--;
                i--;
            }
            for (i += 1; i < len; i++) {
                nums[i] = '9';
            }
        }
        return Integer.parseInt(String.valueOf(nums));
    }

    public static void main(String[] args) {
        MonotoneIncreasingDigits m = new MonotoneIncreasingDigits();
        //示例 1:
        //
        //输入: N = 10
        //输出: 9
        int n = 10;
        System.out.println(m.monotoneIncreasingDigits(n));

        //示例 2:
        //
        //输入: N = 1234
        //输出: 1234
        n = 1234;
        System.out.println(m.monotoneIncreasingDigits(n));


        //示例 3:
        //
        //输入: N = 332
        //输出: 299
        n = 332;
        System.out.println(m.monotoneIncreasingDigits(n));

    }
}
