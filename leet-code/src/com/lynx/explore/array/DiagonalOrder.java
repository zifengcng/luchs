package com.lynx.explore.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wbc
 * @date 2020/6/29 10:55
 * <p>
 * 对角线遍历
 * 给定一个含有 M x N 个元素的矩阵（M 行，N 列），请以对角线遍历的顺序返回这个矩阵中的所有元素，对角线遍历如下图所示。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * <p>
 * 输出:  [1,2,4,7,5,3,6,8,9]
 * <p>
 * 解释:
 * <p>
 * <p>
 * <p>
 * 说明:
 * <p>
 * 给定矩阵中的元素总数不会超过 100000 。
 * https://leetcode-cn.com/explore/learn/card/array-and-string/199/introduction-to-2d-array/1416/
 */
public class DiagonalOrder {

    /**
     * 效率不高
     * 待优化思路：m+n-1条对角线，遍历方向有条数%2决定
     */
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[]{};
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[] result = new int[m * n];

        int s = 0;
        int index = 0;
        List<Map<Integer, Integer>> list;
        while (s < (m + n - 1)) {
            list = getXY(s, m, n);
            for (Map<Integer, Integer> map : list) {
                for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                    result[index++] = matrix[entry.getKey()][entry.getValue()];
                }
            }
            s++;
        }
        return result;
    }

    private List<Map<Integer, Integer>> getXY(int s, int m, int n) {
        List<Map<Integer, Integer>> result = new ArrayList<>();

        if (s % 2 == 0) {
            int y = 0;
            int x = s - y;
            while (x >= 0 && y < n) {
                if (x < m) {
                    Map<Integer, Integer> map = new HashMap<>();
                    map.put(x, y);
                    result.add(map);
                }
                x--;
                y++;
            }
        } else {
            int x = 0;
            int y = s - x;
            while (y >= 0 && x < m) {
                if (y < n) {
                    Map<Integer, Integer> map = new HashMap<>();
                    map.put(x, y);
                    result.add(map);
                }
                x++;
                y--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        DiagonalOrder d = new DiagonalOrder();
        for (int i = 0; i < 10; i++) {
            System.out.println("i=" + i + "," + d.getXY(i, 3, 1));
        }
    }
}
