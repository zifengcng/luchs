package com.lynx.random;

/**
 * @Author cheng
 * @Date 2020/10/14
 */
public class Transpose {

    public int[][] transpose(int[][] A) {
        int m = A.length;
        if (m == 0) {
            return A;
        }
        int n = A[0].length;

        int[][] t = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                t[i][j] = A[j][i];
            }
        }

        return t;
    }
}
