package com.lynx.explore.digui;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wbc
 * @date 2020/6/28 13:56
 * <p>
 * 不同的二叉搜索树 II
 * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的 二叉搜索树 。
 * <p>
 * 示例：
 * 输入：3
 * 输出：
 * [
 * [1,null,3,2],
 * [3,2,null,1],
 * [3,1,null,null,2],
 * [2,1,3],
 * [1,null,2,null,3]
 * ]
 * 解释：
 * 以上的输出对应以下 5 种不同结构的二叉搜索树：
 * <p>
 * 1         3     3      2      1
 * \       /     /      / \      \
 * 3     2     1      1   3      2
 * /     /       \                 \
 * 2     1         2                 3
 * <p>
 * 提示：
 * 0 <= n <= 8
 * <p>
 * https://leetcode-cn.com/explore/featured/card/recursion-i/260/conclusion/1233/
 */
public class GenerateTrees {

	public static void main(String[] args) {
		List<TreeNode> treeNodes = new GenerateTrees().generateTrees(3);
		System.out.println(treeNodes);
	}

	public List<TreeNode> generateTrees(int n) {
		if (n < 1) {
			return null;
		}
		return generateTrees2(1, n);
	}

	private List<TreeNode> generateTrees2(int start, int end) {
		List<TreeNode> treeNodes = new ArrayList<>();
		if (start > end) {
			treeNodes.add(null);
			return treeNodes;
		}

		if (start == end) {
			TreeNode treeNode = new TreeNode(start);
			treeNodes.add(treeNode);
			return treeNodes;
		}

		for (int i = start; i <= end; i++) {
			List<TreeNode> lefts = generateTrees2(start, i - 1);
			List<TreeNode> rights = generateTrees2(i + 1, end);
			for (TreeNode left : lefts) {
				for (TreeNode right : rights) {
					TreeNode treeNode = new TreeNode(i);
					treeNode.left = left;
					treeNode.right = right;
					treeNodes.add(treeNode);
				}
			}
		}

		return treeNodes;
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
}
