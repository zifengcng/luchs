package com.lynx.explore.binarySearchTree;

/**
 * @author wbc
 * @date 2020/7/23 18:36
 * Delete Node in a BST
 * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
 * <p>
 * 一般来说，删除节点可分为两个步骤：
 * <p>
 * 首先找到需要删除的节点；
 * 如果找到了，删除它。
 * 说明： 要求算法时间复杂度为 O(h)，h 为树的高度。
 * <p>
 * 示例:
 * <p>
 * root = [5,3,6,2,4,null,7]
 * key = 3
 * <p>
 * 5
 * / \
 * 3   6
 * / \   \
 * 2   4   7
 * <p>
 * 给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。
 * <p>
 * 一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。
 * <p>
 * 5
 * / \
 * 4   6
 * /     \
 * 2       7
 * <p>
 * 另一个正确答案是 [5,2,6,null,4,null,7]。
 * <p>
 * 5
 * / \
 * 2   6
 * \   \
 * 4   7
 * https://leetcode-cn.com/explore/learn/card/introduction-to-data-structure-binary-search-tree/65/basic-operations-in-a-bst/180/
 */
public class DeleteNode {

	// 不移动节点，只改变了值，删除了 “下个节点” 的后继节点
	public TreeNode deleteNode(TreeNode root, int key) {
		if (root == null) {
			return null;
		}

		if (key < root.val) {
			root.left = deleteNode(root.left, key);
		} else if (key > root.val) {
			root.right = deleteNode(root.right, key);
		} else {
			if (root.left == null && root.right == null) {
				return null;
			} else if (root.left != null) {
				root.val = rightVal(root.left);
				root.left = deleteNode(root.left, root.val);
			} else {
				root.val = leftVal(root.right);
				root.right = deleteNode(root.right, root.val);
			}
		}
		return root;
	}

	private int leftVal(TreeNode root) {
		while (root.left != null) {
			root = root.left;
		}
		return root.val;
	}

	private int rightVal(TreeNode root) {
		while (root.right != null) {
			root = root.right;
		}
		return root.val;
	}

}
