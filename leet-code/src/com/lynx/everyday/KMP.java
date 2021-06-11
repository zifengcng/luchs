package com.lynx.everyday;

import com.lynx.common.annotition.EasyCode;

/**
 * @Author cheng
 * @Date 2021/4/20
 */
@EasyCode
public class KMP {

    /**
     * KMP算法指的是字符串模式匹配算法，问题是：在主串T中找到第一次出现完整子串P时的起始位置。
     *
     * @param t
     * @param p
     * @return
     */
    public int kmp(String t, String p) {
        int lenT = t.length();
        int lenP = p.length();

        if (lenP == 0) {
            return 0;
        }

        char[] charsT = t.toCharArray();
        char[] charsP = p.toCharArray();

        int[] next = getNext(charsP);

        int i = 0;
        int j = 0;
        while (i < lenT && j < lenP) {
            if (j == -1 || charsT[i] == charsP[j]) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }

        if (j == lenP) {
            return i - j;
        }
        return -1;
    }

    private int[] getNext(char[] charsP) {
        int len = charsP.length;
        int[] next = new int[len + 1];
        next[0] = -1;

        int i = 0;
        int j = -1;

        // abac
        // ab
        while (i < len) {
            if (j == -1 || charsP[i] == charsP[j]) {
                i++;
                j++;
                next[i] = j;
            } else {
                j = next[j];
            }
        }

        return next;
    }
}
