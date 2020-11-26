package com.lynx.explore.binaryTree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wbc
 * @date 2020/7/23 10:52
 * 二叉树的序列化与反序列化
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 * <p>
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 * <p>
 * 示例:
 * <p>
 * 你可以将以下二叉树：
 * <p>
 * 1
 * / \
 * 2   3
 * / \
 * 4   5
 * <p>
 * 序列化为 "[1,2,3,null,null,4,5]"
 * 提示: 这与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
 * <p>
 * 说明: 不要使用类的成员 / 全局 / 静态变量来存储状态，你的序列化和反序列化算法应该是无状态的。
 * https://leetcode-cn.com/explore/learn/card/data-structure-binary-tree/4/conclusion/20/
 */
public class Codec {

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		if (root == null) {
			return null;
		}
		List<String> list = new ArrayList<>();
		Deque<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			boolean leaf = true;
			List<String> temp = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				if (node == null) {
					temp.add("null");
				} else {
					leaf = false;
					queue.add(node.left);
					queue.add(node.right);
					temp.add(String.valueOf(node.val));
				}
			}
			if (leaf) {
				break;
			}
			list.addAll(temp);
		}
		if (list.isEmpty()) {
			return null;
		}
		int validIndex = getValidIndex(list);
		if (validIndex < 0) {
			return null;
		}
		return String.join(",", list.subList(0, validIndex + 1));
	}

	private int getValidIndex(List<String> list) {
		int index = list.size() - 1;
		for (int i = list.size() - 1; i >= 0; i--) {
			if ("null".equals(list.get(i))) {
				index--;
			} else {
				break;
			}
		}
		return index;
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		if (data == null) {
			return null;
		}

		String[] arr = data.split(",");
		if (arr[0] == null) {
			return null;
		}
		TreeNode root = new TreeNode(Integer.parseInt(arr[0]));

		Deque<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		int length = arr.length;
		int index = 1;
		while (!queue.isEmpty()) {
			int size = queue.size();
			boolean leaf = true;
			for (int i = 0; i < size; i++) {
				if (index >= length) {
					leaf = true;
					break;
				}
				TreeNode node = queue.poll();
				if (node == null) {
					continue;
				} else {
					String val = arr[index++];
					if ("null".equals(val)) {
						node.left = null;
					} else {
						node.left = new TreeNode(Integer.parseInt(val));
					}
					queue.add(node.left);
					if (index >= length) {
						leaf = true;
						break;
					}
					val = arr[index++];
					if ("null".equals(val)) {
						node.right = null;
					} else {
						node.right = new TreeNode(Integer.parseInt(val));
					}
					queue.add(node.right);
					leaf = false;
				}
			}
			if (leaf) {
				break;
			}
		}
		return root;
	}

	public static void main(String[] args) {
		Codec codec = new Codec();
		TreeNode root = new TreeNode(5);
		TreeNode node1 = new TreeNode(2);
		TreeNode node2 = new TreeNode(3);
		TreeNode node3 = new TreeNode(2);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(3);
		TreeNode node6 = new TreeNode(1);
		root.left = node1;
		root.right = node2;
		node2.left = node3;
		node2.right = node4;
		node3.left = node5;
		node3.right = node6;


		String serialize = codec.serialize(root);
		System.out.println(serialize);
		TreeNode node = codec.deserialize(serialize);
		System.out.println(node);
	}
}
