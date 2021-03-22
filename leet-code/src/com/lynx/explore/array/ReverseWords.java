package com.lynx.explore.array;

/**
 * @author wbc
 * @date 2020/6/29 17:06
 * 翻转字符串里的单词
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 * 示例 2：
 * <p>
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 示例 3：
 * <p>
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 * <p>
 * <p>
 * 说明：
 * <p>
 * 无空格字符构成一个单词。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 * <p>
 * https://leetcode-cn.com/explore/learn/card/array-and-string/200/introduction-to-string/1419/
 */
public class ReverseWords {

    public String reverseWords(String s) {
        if (s.isEmpty()) {
            return "";
        }
        String[] arrs = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = arrs.length - 1; i >= 0; i--) {
            String str = arrs[i];
            if (!str.isEmpty()) {
                sb.append(str).append(" ");
            }
        }
        if (sb.length() > 0) {
            return sb.substring(0, sb.length() - 1);
        }
        return "";
    }
}
