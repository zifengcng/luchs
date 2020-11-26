package com.lynx.explore.binarySearchTree;

/**
 * @author wbc
 * @date 2020/7/23 15:12
 */
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

