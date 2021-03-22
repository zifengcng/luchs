package com.lynx.explore.array;

/**
 * @author wbc
 * @date 2020/6/29 18:20
 * 实现 strStr()
 * 实现 strStr() 函数。
 * <p>
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * 说明:
 * <p>
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * <p>
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 * https://leetcode-cn.com/explore/learn/card/array-and-string/200/introduction-to-string/1420/
 */
public class KMP {

    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) {
            return 0;
        }
        if (haystack == null || haystack.length() == 0) {
            return -1;
        }
        if (needle.length() == 1) {
            return haystack.indexOf(needle.charAt(0));
        }

        char[] hArr = haystack.toCharArray();
        char[] nArr = needle.toCharArray();

        int[] nextArr = getNextArr(nArr);

        int i = 0;
        int j = 0;
        while (i < hArr.length && j < nArr.length) {
            if (j == -1 || hArr[i] == nArr[j]) {
                i++;
                j++;
            } else {
                j = nextArr[j];
            }
        }
        if (j == nArr.length) {
            return i - j;
        }
        return -1;

    }

    private int[] getNextArr(char[] nArr) {
        int[] next = new int[nArr.length];
        next[0] = -1;
        next[1] = 0;
        int k;
        for (int j = 2; j < nArr.length; j++) {
            k = next[j - 1];
            while (k != -1) {
                if (nArr[j - 1] == nArr[k]) {
                    next[j] = k + 1;
                    break;
                } else {
                    k = next[k];
                }
            }
        }
        return next;
    }

    public static void main(String[] args) {
        KMP kmp = new KMP();
        int index = kmp.strStr("cabcaba", "aba");
        System.out.println(index);
    }
}
