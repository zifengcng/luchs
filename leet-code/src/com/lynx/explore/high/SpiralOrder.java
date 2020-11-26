package com.lynx.explore.high;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author cheng
 * @Date 2020/8/25
 * 螺旋矩阵
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 * 示例 2:
 * <p>
 * 输入:
 * [
 * [1, 2, 3, 4],
 * [5, 6, 7, 8],
 * [9,10,11,12]
 * ]
 * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-hard/xw3ng2/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class SpiralOrder {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        int r = 0;
        int m = matrix.length;

        int c = 0;
        int n = matrix[0].length;

        while (r < m && c < n) {
            // 向右
            int c1 = c;
            while (c1 < n) {
                res.add(matrix[r][c1++]);
            }

            // 向下
            int r1 = r + 1;
            while (r1 < m) {
                res.add(matrix[r1++][n - 1]);
            }

            // 向左
            int n1 = n - 1 - 1;
            while (n1 >= c && m - 1 > r) {
                res.add(matrix[m - 1][n1--]);
            }

            // 向上
            int m1 = m - 1 - 1;
            while (m1 > r && n - 1 > r) {
                res.add(matrix[m1--][c]);
            }

            r++;
            c++;
            m--;
            n--;
        }

        return res;
    }

    public static void main(String[] args) {
        SpiralOrder s = new SpiralOrder();
        List<Integer> res = s.spiralOrder(new int[][]{{1}, {2}, {3}});
        System.out.println(res);
    }
}
