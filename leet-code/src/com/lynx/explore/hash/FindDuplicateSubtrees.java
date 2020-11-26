package com.lynx.explore.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wbc
 * @date 2020/7/20 11:37
 *  寻找重复的子树
 * 给定一棵二叉树，返回所有重复的子树。对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。
 *
 * 两棵树重复是指它们具有相同的结构以及相同的结点值。
 *
 * 示例 1：
 *
 *         1
 *        / \
 *       2   3
 *      /   / \
 *     4   2   4
 *        /
 *       4
 * 下面是两个重复的子树：
 *
 *       2
 *      /
 *     4
 * 和
 *
 *     4
 * 因此，你需要以列表的形式返回上述重复子树的根结点。
 * https://leetcode-cn.com/explore/learn/card/hash-table/206/practical-application-design-the-key/823/
 */
public class FindDuplicateSubtrees {

	private Map<String, Integer> trees = new HashMap<>();
	private Map<Integer, Integer> count = new HashMap<>();
	private List<TreeNode> res = new ArrayList<>();
	private int i;

	public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
		if (root == null || (root.left == null && root.right == null)) {
			return res;
		}
		i = 1;
		dfs(root);
		return res;
	}

	private int dfs(TreeNode root) {
		if (root == null) {
			return 0;
		}
		String ser = root.val + "" + dfs(root.left) + "" + dfs(root.right);
		Integer uid = trees.computeIfAbsent(ser, x -> i++);
		count.put(uid, count.getOrDefault(uid, 0) + 1);
		if (count.get(uid) == 2) {
			res.add(root);
		}
		return uid;
	}


}


class TreeNode {
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

