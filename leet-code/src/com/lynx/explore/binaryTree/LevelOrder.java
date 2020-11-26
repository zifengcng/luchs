package com.lynx.explore.binaryTree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wbc
 * @date 2020/7/22 16:21
 * 二叉树的层序遍历
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 * <p>
 * <p>
 * <p>
 * 示例：
 * 二叉树：[3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其层次遍历结果：
 * <p>
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 * https://leetcode-cn.com/explore/learn/card/data-structure-binary-tree/2/traverse-a-tree/9/
 */
public class LevelOrder {

	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null) {
			return res;
		}

		Deque<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			Deque<TreeNode> temp = new LinkedList<>();
			List<Integer> list = new ArrayList<>();
			while (!queue.isEmpty()) {
				TreeNode node = queue.peek();
				list.add(queue.poll().val);
				if (node.left != null) {
					temp.add(node.left);
				}
				if (node.right != null) {
					temp.add(node.right);
				}
			}
			res.add(list);
			queue = temp;
		}

		return res;
	}
}
