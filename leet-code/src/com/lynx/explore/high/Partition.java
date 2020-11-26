package com.lynx.explore.high;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

/**
 * @Author cheng
 * @Date 2020/9/3
 * 分割回文串
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 * <p>
 * 返回 s 所有可能的分割方案。
 * <p>
 * 示例:
 * <p>
 * 输入: "aab"
 * 输出:
 * [
 * ["aa","b"],
 * ["a","a","b"]
 * ]
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-hard/xdr7yg/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Partition {

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        int len = s.length();
        if (len == 0) {
            return res;
        }

        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j <= i; j++) {
                if (s.charAt(j) == s.charAt(i) && (i - j <= 2 || dp[j + 1][i - 1])) {
                    dp[j][i] = true;
                }
            }
        }

        Deque<String> stack = new ArrayDeque<>();
        backtracking(s, 0, len, dp, stack, res);
        return res;
    }

    private void backtracking(String s, int start, int len, boolean[][] dp, Deque<String> stack, List<List<String>> res) {
        if (start == len) {
            List<String> list = new ArrayList<>(stack);
            Collections.reverse(list);
            res.add(list);
            return;
        }
        for (int i = start; i < len; i++) {
//            if (!checkPalindrome(s, start, i)) {
//                continue;
//            }
            if (!dp[start][i]) {
                continue;
            }

            stack.push(s.substring(start, i + 1));
            backtracking(s, i + 1, len, dp, stack, res);
            stack.pop();
        }
    }

    private boolean checkPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        Partition partition = new Partition();
        List<List<String>> list = partition.partition("aabacdaadc");
        System.out.println(list);
    }
}
