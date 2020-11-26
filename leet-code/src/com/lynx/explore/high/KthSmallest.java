package com.lynx.explore.high;

/**
 * @Author cheng
 * @Date 2020/9/4
 * 有序矩阵中第K小的元素
 * 给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
 * 请注意，它是排序后的第 k 小元素，而不是第 k 个不同的元素。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * matrix = [
 * [ 1,  5,  9],
 * [10, 11, 13],
 * [12, 13, 15]
 * ],
 * k = 8,
 * <p>
 * 返回 13。
 *  
 * <p>
 * 提示：
 * 你可以假设 k 的值永远是有效的，1 ≤ k ≤ n2 。
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-hard/xdnjqd/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class KthSmallest {

    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        if (n == 0) {
            return -1;
        }

        int left = matrix[0][0];
        int right = matrix[n - 1][n - 1];

        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (check(matrix, n, mid, k)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean check(int[][] matrix, int n, int mid, int k) {
        int num = 0;
        int i = n - 1;
        int j = 0;
        while (j < n && i >= 0) {
            if (matrix[i][j] <= mid) {
                num += i + 1;
                j++;
            } else {
                i--;
            }
        }

        return num >= k;
    }

    public static void main(String[] args) {
        KthSmallest k = new KthSmallest();
        System.out.println(k.kthSmallest(new int[][]{{1, 5, 9}, {10, 11, 13}, {12, 13, 15}}, 8));
        System.out.println(7 >> 1 + 1);
        System.out.println(8 + 7 >> 1);
        int a = 5;
        int b = 4;
        int c = a++ - --b * ++a / b-- >> 2 % a--;
        // a->6 b->2
        // 5 - 3*7/3 >> 2 %7
        System.out.println(c);
        System.out.println(-2 >> 2);
    }
}
