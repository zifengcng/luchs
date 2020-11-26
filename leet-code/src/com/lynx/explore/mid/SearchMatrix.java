package com.lynx.explore.mid;

/**
 * @Author cheng
 * @Date 2020/8/20
 * 搜索二维矩阵 II
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
 * <p>
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 * 示例:
 * <p>
 * 现有矩阵 matrix 如下：
 * <p>
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 * <p>
 * 给定 target = 20，返回 false。
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xvc64r/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class SearchMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int iBegin = 0;
        int jBegin = 0;
        int iEnd = matrix.length - 1;
        int jEnd = matrix[0].length - 1;

        while (iBegin <= iEnd && jBegin <= jEnd) {
            if (matrix[iBegin][jBegin] > target) {
                return false;
            }

            iEnd = getIEnd(matrix, iBegin, iEnd, jBegin, target);
            jEnd = getJEnd(matrix, jBegin, jEnd, iBegin, target);

            if (target == matrix[iBegin][jEnd] || target == matrix[iEnd][jBegin]) {
                return true;
            }

            if (matrix[iEnd][jEnd] < target) {
                return false;
            }

            iBegin++;
            jBegin++;
        }
        return target == matrix[iEnd][jEnd];
    }

    private int getJEnd(int[][] matrix, int jBegin, int jEnd, int i, int target) {
        if (jBegin >= jEnd) {
            return jEnd;
        }
        int mid = (jBegin + jEnd) / 2;
        if (matrix[i][mid] == target) {
            return mid;
        } else if (matrix[i][mid] < target) {
            if (mid + 1 <= jEnd && matrix[i][mid + 1] > target) {
                return mid;
            }
            return getJEnd(matrix, mid + 1, jEnd, i, target);
        } else {
            return getJEnd(matrix, jBegin, mid - 1, i, target);
        }
    }

    private int getIEnd(int[][] matrix, int iBegin, int iEnd, int j, int target) {
        if (iBegin >= iEnd) {
            return iEnd;
        }
        int mid = (iBegin + iEnd) / 2;
        if (matrix[mid][j] == target) {
            return mid;
        } else if (matrix[mid][j] < target) {
            if (mid + 1 <= iEnd && matrix[mid + 1][j] > target) {
                return mid;
            }
            return getIEnd(matrix, mid + 1, iEnd, j, target);
        } else {
            return getIEnd(matrix, iBegin, mid - 1, j, target);
        }
    }

    public static void main(String[] args) {
        SearchMatrix s = new SearchMatrix();
        boolean b = s.searchMatrix(new int[][]{{1, 1}}, 0);
        System.out.println(b);
    }
}
