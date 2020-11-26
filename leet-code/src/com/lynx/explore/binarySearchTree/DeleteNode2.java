package com.lynx.explore.binarySearchTree;

/**
 * @author wbc
 * @date 2020/7/24 11:00
 */
public class DeleteNode2 {

	// 方法二：取删除节点的后继节点
	public TreeNode deleteNode(TreeNode root, int key) {
		if (root == null) {
			return null;
		}
		if (key < root.val) {
			root.left = deleteNode(root.left, key);
		} else if (key > root.val) {
			root.right = deleteNode(root.right, key);
		} else {
			if (root.left == null) {
				return root.right;
			}
			if (root.right == null) {
				return root.left;
			}
			TreeNode t = root;
			root = getSuccessor(t.right);
			root.right = delSuccessor(t.right);
			root.left = t.left;
		}

		return root;
	}

	private TreeNode delSuccessor(TreeNode root) {
		if (root.left == null) {
			return root.right;
		}
		root.left = delSuccessor(root.left);
		return root;
	}

	private TreeNode getSuccessor(TreeNode root) {
		while (root.left != null) {
			root = root.left;
		}
		return root;
	}

}
