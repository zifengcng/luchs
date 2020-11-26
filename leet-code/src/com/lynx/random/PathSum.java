package com.lynx.random;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author cheng
 * @Date 2020/9/25
 * 437. 路径总和 III
 * 给定一个二叉树，它的每个结点都存放着一个整数值。
 * <p>
 * 找出路径和等于给定数值的路径总数。
 * <p>
 * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 * <p>
 * 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
 * <p>
 * 示例：
 * <p>
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 * <p>
 * 10
 * /  \
 * 5   -3
 * / \    \
 * 3   2   11
 * / \   \
 * 3  -2   1
 * <p>
 * 返回 3。和等于 8 的路径有:
 * <p>
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3.  -3 -> 11
 * <p>
 * https://leetcode-cn.com/problems/path-sum-iii/
 */
public class PathSum {

    public int pathSum(TreeNode root, int sum) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        return dfs(root, sum, 0, map);
    }

    private int dfs(TreeNode root, int sum, int pathSum, Map<Integer, Integer> map) {
        if (root == null) {
            return 0;
        }
        int res = 0;

        pathSum += root.val;
        res += map.getOrDefault(pathSum - sum, 0);
        map.put(pathSum, map.getOrDefault(pathSum, 0) + 1);
        res += dfs(root.left, sum, pathSum, map) + dfs(root.right, sum, pathSum, map);
        map.put(pathSum, map.get(pathSum) - 1);
        return res;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        PathSum p = new PathSum();
        TreeNode root = p.new TreeNode(10);
        TreeNode node1 = p.new TreeNode(5);
        TreeNode node2 = p.new TreeNode(-3);
        TreeNode node3 = p.new TreeNode(3);
        TreeNode node4 = p.new TreeNode(2);
        TreeNode node5 = p.new TreeNode(11);
        TreeNode node6 = p.new TreeNode(3);
        TreeNode node7 = p.new TreeNode(-2);
        TreeNode node8 = p.new TreeNode(1);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node4.right = node8;

        int count = p.pathSum(root, 8);
        System.out.println(count);
    }
}
