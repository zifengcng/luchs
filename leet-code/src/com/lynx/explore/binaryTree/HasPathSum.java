package com.lynx.explore.binaryTree;

/**
 * @author wbc
 * @date 2020/7/22 17:20
 * 路径总和
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 * <p>
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \      \
 * 7    2      1
 * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 * https://leetcode-cn.com/explore/learn/card/data-structure-binary-tree/3/solve-problems-recursively/14/
 */
public class HasPathSum {

	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null) {
			return false;
		}
		if ((root.left == null && root.right == null) && sum == root.val) {
			return true;
		}
		sum -= root.val;
		return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
	}

	public static void main(String[] args) {
		HasPathSum hasPathSum = new HasPathSum();
		System.out.println(hasPathSum.hasPathSum(new TreeNode(1), 1));
	}
}
