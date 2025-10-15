//package com.lynx.everyday;
//
//import com.lynx.common.annotition.EasyCode;
//import javafx.util.Pair;
//
//import java.util.Deque;
//import java.util.HashSet;
//import java.util.LinkedList;
//import java.util.Set;
//
///**
// * @Author cheng
// * @Date 2020/11/17
// * 1030. 距离顺序排列矩阵单元格
// * 给出 R 行 C 列的矩阵，其中的单元格的整数坐标为 (r, c)，满足 0 <= r < R 且 0 <= c < C。
// * <p>
// * 另外，我们在该矩阵中给出了一个坐标为 (r0, c0) 的单元格。
// * <p>
// * 返回矩阵中的所有单元格的坐标，并按到 (r0, c0) 的距离从最小到最大的顺序排，其中，两单元格(r1, c1) 和 (r2, c2) 之间的距离是曼哈顿距离，|r1 - r2| + |c1 - c2|。（你可以按任何满足此条件的顺序返回答案。）
// * <p>
// * <p>
// * <p>
// * 示例 1：
// * <p>
// * 输入：R = 1, C = 2, r0 = 0, c0 = 0
// * 输出：[[0,0],[0,1]]
// * 解释：从 (r0, c0) 到其他单元格的距离为：[0,1]
// * 示例 2：
// * <p>
// * 输入：R = 2, C = 2, r0 = 0, c0 = 1
// * 输出：[[0,1],[0,0],[1,1],[1,0]]
// * 解释：从 (r0, c0) 到其他单元格的距离为：[0,1,1,2]
// * [[0,1],[1,1],[0,0],[1,0]] 也会被视作正确答案。
// * 示例 3：
// * <p>
// * 输入：R = 2, C = 3, r0 = 1, c0 = 2
// * 输出：[[1,2],[0,2],[1,1],[0,1],[1,0],[0,0]]
// * 解释：从 (r0, c0) 到其他单元格的距离为：[0,1,1,2,2,3]
// * 其他满足题目要求的答案也会被视为正确，例如 [[1,2],[1,1],[0,2],[1,0],[0,1],[0,0]]。
// * <p>
// * <p>
// * 提示：
// * <p>
// * 1 <= R <= 100
// * 1 <= C <= 100
// * 0 <= r0 < R
// * 0 <= c0 < C
// * https://leetcode-cn.com/problems/matrix-cells-in-distance-order/
// */
//@EasyCode
//public class AllCellsDistOrder {
//
//    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
//        return helper(R, C, r0, c0);
//    }
//
//    private int[][] helper(int r, int c, int r0, int c0) {
//        int size = r * c;
//        int[][] res = new int[size][2];
//
//        Deque<Pair<Integer, Integer>> queue = new LinkedList<>();
//        Pair<Integer, Integer> root = new Pair<>(r0, c0);
//        queue.add(root);
//        Set<Pair<Integer, Integer>> visited = new HashSet<>();
//        visited.add(root);
//        int index = 0;
//        while (!queue.isEmpty()) {
//            int s = queue.size();
//            for (int i = 0; i < s; i++) {
//                Pair<Integer, Integer> pair = queue.poll();
//                int rIndex = pair.getKey();
//                int cIndex = pair.getValue();
//                res[index++] = new int[]{rIndex, cIndex};
//
//                if (rIndex >= 1) {
//                    Pair<Integer, Integer> t = new Pair<>(rIndex - 1, cIndex);
//                    if (!visited.contains(t)) {
//                        queue.add(t);
//                        visited.add(t);
//                    }
//                }
//                if (rIndex < r - 1) {
//                    Pair<Integer, Integer> t = new Pair<>(rIndex + 1, cIndex);
//                    if (!visited.contains(t)) {
//                        queue.add(t);
//                        visited.add(t);
//                    }
//                }
//                if (cIndex >= 1) {
//                    Pair<Integer, Integer> t = new Pair<>(rIndex, cIndex - 1);
//                    if (!visited.contains(t)) {
//                        queue.add(t);
//                        visited.add(t);
//                    }
//                }
//                if (cIndex < c - 1) {
//                    Pair<Integer, Integer> t = new Pair<>(rIndex, cIndex + 1);
//                    if (!visited.contains(t)) {
//                        queue.add(t);
//                        visited.add(t);
//                    }
//                }
//            }
//
//        }
//
//        return res;
//    }
//
//    public static void main(String[] args) {
//        AllCellsDistOrder a = new AllCellsDistOrder();
//        //输入：R = 2, C = 2, r0 = 0, c0 = 1
//        //输出：[[0,1],[0,0],[1,1],[1,0]]
//        int[][] nums = a.allCellsDistOrder(2, 2, 0, 1);
//        for (int[] num : nums) {
//            System.out.print("[ " + num[0] + " , " + num[1] + " ]");
//        }
//        System.out.println();
//
//        //输入：R = 2, C = 2, r0 = 0, c0 = 1
//        //输出：[[0,1],[0,0],[1,1],[1,0]]
//        nums = a.allCellsDistOrder(2, 2, 0, 1);
//        for (int[] num : nums) {
//            System.out.print("[ " + num[0] + " , " + num[1] + " ]");
//        }
//        System.out.println();
//
//        //输入：R = 2, C = 3, r0 = 1, c0 = 2
//        //输出：[[1,2],[0,2],[1,1],[0,1],[1,0],[0,0]]
//        nums = a.allCellsDistOrder(2, 3, 1, 2);
//        for (int[] num : nums) {
//            System.out.print("[ " + num[0] + " , " + num[1] + " ]");
//        }
//        System.out.println();
//
//
//    }
//
//}
