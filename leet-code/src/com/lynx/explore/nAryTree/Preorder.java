package com.lynx.explore.nAryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wbc
 * @date 2020/7/24 17:52
 * N-ary Tree Preorder Traversal
 * 给定一个 N 叉树，返回其节点值的前序遍历。
 * <p>
 * 例如，给定一个 3叉树 :
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 返回其前序遍历: [1,3,5,6,2,4]。
 * <p>
 * <p>
 * <p>
 * 说明: 递归法很简单，你可以使用迭代法完成此题吗?
 * https://leetcode-cn.com/explore/learn/card/n-ary-tree/159/traversal/620/
 */
public class Preorder {

	/**
	 * 先序遍历
	 */
	public List<Integer> preorder(Node root) {
		List<Integer> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		res.add(root.val);
		root.children.forEach(s -> res.addAll(preorder(s)));
		return res;
	}

	/**
	 * 后序遍历
	 */
	public List<Integer> postorder(Node root) {
		List<Integer> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		root.children.forEach(s -> res.addAll(postorder(s)));
		res.add(root.val);
		return res;
	}

	/**
	 * 层序遍历
	 */
	public List<List<Integer>> levelOrder(Node root) {
		if (root == null) {
			return null;
		}
		List<List<Integer>> res = new ArrayList<>();
		return levelOrderHelper(root, res, 0);
	}

	private List<List<Integer>> levelOrderHelper(Node root, List<List<Integer>> res, int height) {
		if (height >= res.size()) {
			res.add(new ArrayList<>());
		}
		List<Integer> list = res.get(height);
		list.add(root.val);
		for (Node child : root.children) {
			levelOrderHelper(child, res, height + 1);
		}
		return res;
	}
}
