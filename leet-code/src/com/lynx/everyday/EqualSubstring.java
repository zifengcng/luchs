package com.lynx.everyday;

import com.lynx.common.annotition.MidCode;

/**
 * @Author cheng
 * @Date 2021/2/5
 * 1208. 尽可能使字符串相等
 * 给你两个长度相同的字符串，s 和 t。
 * <p>
 * 将 s 中的第 i 个字符变到 t 中的第 i 个字符需要 |s[i] - t[i]| 的开销（开销可能为 0），也就是两个字符的 ASCII 码值的差的绝对值。
 * <p>
 * 用于变更字符串的最大预算是 maxCost。在转化字符串时，总开销应当小于等于该预算，这也意味着字符串的转化可能是不完全的。
 * <p>
 * 如果你可以将 s 的子字符串转化为它在 t 中对应的子字符串，则返回可以转化的最大长度。
 * <p>
 * 如果 s 中没有子字符串可以转化成 t 中对应的子字符串，则返回 0。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "abcd", t = "bcdf", cost = 3
 * 输出：3
 * 解释：s 中的 "abc" 可以变为 "bcd"。开销为 3，所以最大长度为 3。
 * 示例 2：
 * <p>
 * 输入：s = "abcd", t = "cdef", cost = 3
 * 输出：1
 * 解释：s 中的任一字符要想变成 t 中对应的字符，其开销都是 2。因此，最大长度为 1。
 * 示例 3：
 * <p>
 * 输入：s = "abcd", t = "acde", cost = 0
 * 输出：1
 * 解释：你无法作出任何改动，所以最大长度为 1。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length, t.length <= 10^5
 * 0 <= maxCost <= 10^6
 * s 和 t 都只含小写英文字母。
 * https://leetcode-cn.com/problems/get-equal-substrings-within-budget/
 */
@MidCode
public class EqualSubstring {

    public int equalSubstring(String s, String t, int maxCost) {
        char[] arrS = s.toCharArray();
        char[] arrT = t.toCharArray();
        int len = arrS.length;

        int[] cost = new int[len];
        for (int i = 0; i < len; i++) {
            cost[i] = Math.abs(arrS[i] - arrT[i]);
        }

        int left = 0;
        int right = 0;
        int maxLen = 0;
        int sumCost = 0;
        while (right < len) {
            sumCost += cost[right];
            if (sumCost <= maxCost) {
                maxLen = Math.max(maxLen, right - left + 1);
            } else {
                sumCost -= cost[left];
                left++;
            }
            right++;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        EqualSubstring e = new EqualSubstring();
        // 示例 1：
        //
        //输入：s = "abcd", t = "bcdf", cost = 3
        //输出：3
        //解释：s 中的 "abc" 可以变为 "bcd"。开销为 3，所以最大长度为 3。
        String s = "abcd";
        String t = "bcdf";
        int maxCost = 3;
        System.out.println(e.equalSubstring(s, t, maxCost) == 3);

        // 示例 2：
        //
        //输入：s = "abcd", t = "cdef", cost = 3
        //输出：1
        //解释：s 中的任一字符要想变成 t 中对应的字符，其开销都是 2。因此，最大长度为 1。
        s = "abcd";
        t = "cdef";
        maxCost = 3;
        System.out.println(e.equalSubstring(s, t, maxCost) == 1);


        // 示例 3：
        //
        //输入：s = "abcd", t = "acde", cost = 0
        //输出：1
        //解释：你无法作出任何改动，所以最大长度为 1。
        s = "abcd";
        t = "acde";
        maxCost = 0;
        System.out.println(e.equalSubstring(s, t, maxCost) == 1);


        // 示例 4：
        //输入：s = "abcd", t = "cdef", cost = 1
        //输出：0
        s = "abcd";
        t = "cdef";
        maxCost = 1;
        System.out.println(e.equalSubstring(s, t, maxCost) == 0);


        // 示例 5：
        //输入：s = "krrgw", t = "zjxss", cost = 19
        //输出：2
        s = "krrgw";
        t = "zjxss";
        maxCost = 19;
        System.out.println(e.equalSubstring(s, t, maxCost) == 2);

    }
}
