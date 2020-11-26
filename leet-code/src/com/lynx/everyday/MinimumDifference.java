package com.lynx.everyday;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author cheng
 * @Date 2020/10/12
 * 530. 二叉搜索树的最小绝对差
 * 给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：
 * <p>
 * 1
 * \
 * 3
 * /
 * 2
 * <p>
 * 输出：
 * 1
 * <p>
 * 解释：
 * 最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中至少有 2 个节点。
 * 本题与 783 https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/ 相同
 * <p>
 * https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/
 */
public class MinimumDifference {

    public int getMinimumDifference(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);

        int min = Integer.MAX_VALUE;
        int size = list.size();
        for (int i = 1; i < size; i++) {
            min = Math.min(min, Math.abs(list.get(i) - list.get(i - 1)));
        }

        return min;
    }

    private void inorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}