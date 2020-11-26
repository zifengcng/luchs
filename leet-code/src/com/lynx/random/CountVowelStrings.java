package com.lynx.random;

import com.lynx.common.annotition.MidCode;

import java.util.Arrays;

/**
 * @Author cheng
 * @Date 2020/11/3
 * <p>
 * 1641. 统计字典序元音字符串的数目 显示英文描述
 * 通过的用户数1841
 * 尝试过的用户数1966
 * 用户总通过次数1870
 * 用户总提交次数2366
 * 题目难度Medium
 * 给你一个整数 n，请返回长度为 n 、仅由元音 (a, e, i, o, u) 组成且按 字典序排列 的字符串数量。
 * <p>
 * 字符串 s 按 字典序排列 需要满足：对于所有有效的 i，s[i] 在字母表中的位置总是与 s[i+1] 相同或在 s[i+1] 之前。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 1
 * 输出：5
 * 解释：仅由元音组成的 5 个字典序字符串为 ["a","e","i","o","u"]
 * 示例 2：
 * <p>
 * 输入：n = 2
 * 输出：15
 * 解释：仅由元音组成的 15 个字典序字符串为
 * ["aa","ae","ai","ao","au","ee","ei","eo","eu","ii","io","iu","oo","ou","uu"]
 * 注意，"ea" 不是符合题意的字符串，因为 'e' 在字母表中的位置比 'a' 靠后
 * 示例 3：
 * <p>
 * 输入：n = 33
 * 输出：66045
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 50
 * <p>
 * https://leetcode-cn.com/contest/weekly-contest-213/problems/count-sorted-vowel-strings/
 */
@MidCode
public class CountVowelStrings {

    public int countVowelStrings(int n) {
        /**
         * 1->5
         * u +1
         * o +1
         * i +1
         * e +1
         * a +1
         *
         *
         *
         * 2-> 15
         * u +1
         * o +2
         * i +3
         * e +4
         * a +5
         *
         * 3-> 35
         * u +1
         * o +3
         * i +6
         * e +10
         * a +15
         *
         * U[n] = U[n-1]
         * O[n] = O[n-1] + U[n]
         */

        int[][] arr = new int[n][5];
        Arrays.fill(arr[0], 1);
        for (int i = 1; i < n; i++) {
            arr[i][4] = arr[i - 1][4];
            arr[i][3] = arr[i - 1][3] + arr[i][4];
            arr[i][2] = arr[i - 1][2] + arr[i][3];
            arr[i][1] = arr[i - 1][1] + arr[i][2];
            arr[i][0] = arr[i - 1][0] + arr[i][1];
        }

        return Arrays.stream(arr[n - 1]).sum();
    }

    public static void main(String[] args) {
        CountVowelStrings c = new CountVowelStrings();
        System.out.println(c.countVowelStrings(33));
    }
}
