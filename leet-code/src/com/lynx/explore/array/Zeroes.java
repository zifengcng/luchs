package com.lynx.explore.array;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wbc
 * @date 2020/6/29 10:37
 * <p>
 * 零矩阵
 * 编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。
 * 示例 1：
 * <p>
 * 输入：
 * [
 * [1,1,1],
 * [1,0,1],
 * [1,1,1]
 * ]
 * 输出：
 * [
 * [1,0,1],
 * [0,0,0],
 * [1,0,1]
 * ]
 * https://leetcode-cn.com/explore/learn/card/array-and-string/199/introduction-to-2d-array/1415/
 */
public class Zeroes {

    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }
        Set<Integer> listI = new HashSet<>();
        Set<Integer> listJ = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    listI.add(i);
                    listJ.add(j);
                }
            }
        }
        listI.forEach(i -> {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = 0;
            }
        });
        listJ.forEach(j -> {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][j] = 0;
            }
        });
    }
}
