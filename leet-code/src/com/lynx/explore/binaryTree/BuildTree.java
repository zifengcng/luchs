package com.lynx.explore.binaryTree;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wbc
 * @date 2020/7/22 17:45
 */
public class BuildTree {

	/**
	 * 从中序与后序遍历序列构造二叉树
	 * 根据一棵树的中序遍历与后序遍历构造二叉树。
	 * <p>
	 * 注意:
	 * 你可以假设树中没有重复的元素。
	 * <p>
	 * 例如，给出
	 * <p>
	 * 中序遍历 inorder = [9,3,15,20,7]
	 * 后序遍历 postorder = [9,15,7,20,3]
	 * 返回如下的二叉树：
	 * <p>
	 * 3
	 * / \
	 * 9  20
	 * /  \
	 * 15   7
	 * <p>
	 * https://leetcode-cn.com/explore/learn/card/data-structure-binary-tree/4/conclusion/15/
	 */
	private int post;

	public TreeNode buildTree(int[] inorder, int[] postorder) {
		int left = 0;
		int right = inorder.length - 1;
		post = postorder.length - 1;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < inorder.length; i++) {
			map.put(inorder[i], i);
		}
		return buildTreeHelper(postorder, left, right, map);
	}

	private TreeNode buildTreeHelper(int[] postorder, int left, int right, Map<Integer, Integer> map) {
		if (left > right) {
			return null;
		}
		TreeNode root = new TreeNode(postorder[post]);
		int index = map.get(postorder[post]);
		post--;
		root.right = buildTreeHelper(postorder, index + 1, right, map);
		root.left = buildTreeHelper(postorder, left, index - 1, map);

		return root;
	}


	public static void main(String[] args) {
		BuildTree buildTree = new BuildTree();
		TreeNode treeNode = buildTree.buildTree(new int[]{9,3,15,20,7}, new int[]{9,15,7,20,3});
		System.out.println(treeNode);
	}
}
