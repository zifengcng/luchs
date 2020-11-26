package com.luchs.java.algorithm;

/**
 * @Author cheng
 * @Date 2020/10/29
 * <p>
 * 最长公共子序列
 */
public class LcsSubString {

    public int lcsLength(String a, String b) {
        int m = a.length();
        int n = b.length();
        // s[i][j]: 存储c[i][j]是由哪一个子问题得到的
        int[][] s = new int[m][n];
        int res = helper(a.toCharArray(), b.toCharArray(), m, n, s);
        lcs(m - 1, n - 1, a.toCharArray(), s);
        return res;
    }

    private int helper(char[] a, char[] b, int m, int n, int[][] s) {
        // c[i][j]: 存储 Ai 和 Bj 的最长公共子序列的长度
        /**             {
         *                  0;                      i==0||j==0
         * c[i][j] =        c[i - 1][j - 1] + 1;    a[i] == b[j]
         *                  max(c[i-1][j],c[i][j-1])    a[i]!=b[j]
         *              }
         */
        int[][] c = new int[m][n];

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (a[i] == b[j]) {
                    c[i][j] = c[i - 1][j - 1] + 1;
                    s[i][j] = 1;
                } else if (c[i - 1][j] > c[i][j - 1]) {
                    c[i][j] = c[i - 1][j];
                    s[i][j] = 2;
                } else {
                    c[i][j] = c[i][j - 1];
                    s[i][j] = 3;
                }
            }
        }

        return c[m - 1][n - 1];
    }

    public void lcs(int i, int j, char[] a, int[][] s) {
        if (i == 0 || j == 0) {
            return;
        }
        if (s[i][j] == 1) {
            lcs(i - 1, j - 1, a, s);
            System.out.println(a[i]);
        } else if (s[i][j] == 2) {
            lcs(i - 1, j, a, s);
        } else {
            lcs(i, j - 1, a, s);
        }
    }

    public static void main(String[] args) {
        LcsSubString l = new LcsSubString();
        int length = l.lcsLength("abcqweabc", "123qw123");
        System.out.println(length);
    }
}
