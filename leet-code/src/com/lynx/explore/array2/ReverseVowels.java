package com.lynx.explore.array2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author wbc
 * @date 2020/7/16 16:55
 * 反转字符串中的元音字母
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "hello"
 * 输出: "holle"
 * 示例 2:
 * <p>
 * 输入: "leetcode"
 * 输出: "leotcede"
 * 说明:
 * 元音字母不包含字母"y"。
 * https://leetcode-cn.com/explore/orignial/card/all-about-array/232/two-pointers/967/
 */
public class ReverseVowels {

    public String reverseVowels(String s) {
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        int i = 0;
        int j = s.length() - 1;
        StringBuilder sb = new StringBuilder(s);
        while (i < j) {
            while (i < j && !vowels.contains(sb.charAt(i))) {
                i++;
            }
            while (j > i && !vowels.contains(sb.charAt(j))) {
                j--;
            }
            if (i < j) {
                char t = sb.charAt(i);
                sb.setCharAt(i, sb.charAt(j));
                sb.setCharAt(j, t);
                i++;
                j--;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ReverseVowels reverseVowels = new ReverseVowels();
        String leetcode = reverseVowels.reverseVowels("leetcode");
        System.out.println(leetcode);
    }
}
