package com.lynx.explore.digui;

/**
 * @author wbc
 * @date 2020/6/24 18:45
 * <p>
 * 二叉树的最大深度
 * 给定一个二叉树，找出其最大深度。
 * <p>
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回它的最大深度 3 。
 * <p>
 * https://leetcode-cn.com/explore/orignial/card/recursion-i/259/complexity-analysis/1225/
 */
public class TreeDepth {

    public int maxDepth(TreeNode root) {
        int max = 0;
        if (root == null) {
            return max;
        }
        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);

        max = leftMax > rightMax ? leftMax : rightMax;
        return max + 1;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
