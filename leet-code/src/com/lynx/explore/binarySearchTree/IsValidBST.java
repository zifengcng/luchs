package com.lynx.explore.binarySearchTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wbc
 * @date 2020/7/23 15:13
 * 验证二叉搜索树
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * <p>
 * 假设一个二叉搜索树具有如下特征：
 * <p>
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 * <p>
 * 输入:
 * 2
 * / \
 * 1   3
 * 输出: true
 * 示例 2:
 * <p>
 * 输入:
 * 5
 * / \
 * 1   4
 * / \
 * 3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 * 根节点的值为 5 ，但是其右子节点值为 4 。
 * https://leetcode-cn.com/explore/learn/card/introduction-to-data-structure-binary-search-tree/64/introduction-to-a-bst/171/
 */
public class IsValidBST {

	public boolean isValidBST(TreeNode root) {
		List<Integer> inOrderList = getInOrderList(root);
		for (int i = 1; i < inOrderList.size(); i++) {
			if (inOrderList.get(i) <= inOrderList.get(i - 1)) {
				return false;
			}
		}
		return true;
	}

	private List<Integer> getInOrderList(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		res.addAll(getInOrderList(root.left));
		res.add(root.val);
		res.addAll(getInOrderList(root.right));
		return res;
	}
}
