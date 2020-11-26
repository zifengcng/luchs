package com.lynx.explore.binarySearchTree;

/**
 * @author wbc
 * @date 2020/7/24 16:55
 * 将有序数组转换为二叉搜索树
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 * <p>
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * <p>
 * 示例:
 * <p>
 * 给定有序数组: [-10,-3,0,5,9],
 * <p>
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 * <p>
 * 0
 * / \
 * -3   9
 * /   /
 * -10  5
 * https://leetcode-cn.com/explore/learn/card/introduction-to-data-structure-binary-search-tree/67/appendix-height-balanced-bst/189/
 */
public class SortedArrayToBST {

	public TreeNode sortedArrayToBST(int[] nums) {
		if (nums == null || nums.length == 0) {
			return null;
		}
		return bst(nums, 0, nums.length - 1);
	}

	private TreeNode bst(int[] nums, int l, int r) {
		if (l > r || l >= nums.length || r < 0) {
			return null;
		}
		if (l == r) {
			return new TreeNode(nums[l]);
		}
		int mid = l + (r - l + 1) / 2;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = bst(nums, l, mid - 1);
		root.right = bst(nums, mid + 1, r);
		return root;
	}

	public static void main(String[] args) {
		SortedArrayToBST sortedArrayToBST = new SortedArrayToBST();
		TreeNode treeNode = sortedArrayToBST.sortedArrayToBST(new int[]{-10, -5, 0, 5, 10});
		System.out.println(treeNode);
	}
}
