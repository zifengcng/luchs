package com.lynx.explore.digui;

/**
 * @author wbc
 * @date 2020/6/24 10:39
 * <p>
 * 反转字符串
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
 * <p>
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 * <p>
 * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
 * 示例 1：
 * <p>
 * 输入：["h","e","l","l","o"]
 * 输出：["o","l","l","e","h"]
 * 示例 2：
 * <p>
 * 输入：["H","a","n","n","a","h"]
 * 输出：["h","a","n","n","a","H"]
 * <p>
 * https://leetcode-cn.com/explore/orignial/card/recursion-i/256/principle-of-recursion/1198/
 */
public class ReverseString {

    public void reverseString(char[] s) {
        if (s == null || s.length < 1) {
            return;
        }
        swap(0, s);
    }

    private void swap(int index, char[] s) {
        if (s == null || index > (s.length - 1) / 2) {
            return;
        }
        swap(index + 1, s);
        char temp = s[index];
        s[index] = s[s.length - 1 - index];
        s[s.length - 1 - index] = temp;
    }
}
