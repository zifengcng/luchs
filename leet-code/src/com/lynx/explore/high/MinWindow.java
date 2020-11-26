package com.lynx.explore.high;

/**
 * @Author cheng
 * @Date 2020/8/26
 * 最小覆盖子串
 * 给你一个字符串 S、一个字符串 T 。请你设计一种算法，可以在 O(n) 的时间复杂度内，从字符串 S 里面找出：包含 T 所有字符的最小子串。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：S = "ADOBECODEBANC", T = "ABC"
 * 输出："BANC"
 *  
 * <p>
 * 提示：
 * <p>
 * 如果 S 中不存这样的子串，则返回空字符串 ""。
 * 如果 S 中存在这样的子串，我们保证它是唯一的答案。
 * <p>
 * Java
 * <p>
 * <p>
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-hard/xw1tws/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class MinWindow {

    public String minWindow(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        if (sLen == 0 || tLen == 0 || sLen < tLen) {
            return "";
        }

        char[] tArr = t.toCharArray();
        char[] sArr = s.toCharArray();


        int[] winFreq = new int[128];
        int[] tFreq = new int[128];

        for (char c : tArr) {
            tFreq[c]++;
        }

        int distance = 0;
        int minLen = sLen + 1;
        int begin = 0;

        int left = 0;
        int right = 0;

        while (right < sLen) {
            char rightChar = sArr[right];
            if (tFreq[rightChar] == 0) {
                right++;
                continue;
            }

            if (winFreq[rightChar] < tFreq[rightChar]) {
                distance++;
            }
            winFreq[rightChar]++;
            right++;

            while (distance == tLen) {
                char leftChar = sArr[left];
                if (right - left < minLen) {
                    minLen = right - left;
                    begin = left;
                }
                if (tFreq[leftChar] == 0) {
                    left++;
                    continue;
                }
                if (winFreq[leftChar] == tFreq[leftChar]) {
                    distance--;
                }
                winFreq[leftChar]--;
                left++;
            }
        }
        if (minLen == sLen + 1) {
            return "";
        }
        return s.substring(begin, begin + minLen);
    }

}
