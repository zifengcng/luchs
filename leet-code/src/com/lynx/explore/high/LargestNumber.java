package com.lynx.explore.high;

import java.util.Arrays;

/**
 * @Author cheng
 * @Date 2020/9/18
 * 最大数
 * 给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [10,2]
 * 输出: 210
 * 示例 2:
 * <p>
 * 输入: [3,30,34,5,9]
 * 输出: 9534330
 * 说明: 输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-hard/xd3jrg/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class LargestNumber {

    public String largestNumber(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return "";
        }
        String[] arr = new String[len];
        for (int i = 0; i < len; i++) {
            arr[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(arr, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        if (arr[0].equals("0")) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            sb.append(arr[i]);
        }
        return sb.toString();
    }
}
