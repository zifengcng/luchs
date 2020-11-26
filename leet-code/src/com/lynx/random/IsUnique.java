package com.lynx.random;

/**
 * @Author cheng
 * @Date 2020/10/16
 * <p>
 * 面试题 01.01. 判定字符是否唯一
 * 实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
 * <p>
 * 示例 1：
 * <p>
 * 输入: s = "leetcode"
 * 输出: false
 * 示例 2：
 * <p>
 * 输入: s = "abc"
 * 输出: true
 * 限制：
 * <p>
 * 0 <= len(s) <= 100
 * 如果你不使用额外的数据结构，会很加分。
 * <p>
 * https://leetcode-cn.com/problems/is-unique-lcci/
 */
public class IsUnique {

    public boolean isUnique(String astr) {
        int len = astr.length();
        if (len == 0) {
            return true;
        }
        int[] arr = new int[128];

        for (int i = 0; i < len; i++) {
            int index = astr.charAt(i) - 'a';
            if (arr[index] > 0) {
                return false;
            }
            arr[index]++;
        }

        return true;
    }

    public boolean isUnique2(String astr) {
        char c;
        int sym = 0, symTmp;
        for (int i = 0; i < astr.length(); i++) {
            c = astr.charAt(i);
            symTmp = 1 << (c - 'a') ^ sym;
            if (symTmp < sym) {
                return false;
            }

            sym = symTmp;
        }

        return true;
    }

    public static void main(String[] args) {
        IsUnique i = new IsUnique();
        char a = (char) ('a' - 97);
        boolean b = i.isUnique2(a + "0klm" + a);
        System.out.println(b);
        System.out.println();
    }
}
