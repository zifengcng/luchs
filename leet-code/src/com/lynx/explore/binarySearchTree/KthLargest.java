package com.lynx.explore.binarySearchTree;

/**
 * @author wbc
 * @date 2020/7/24 13:45
 * Kth Largest Element in a Stream
 * 设计一个找到数据流中第K大元素的类（class）。注意是排序后的第K大元素，不是第K个不同的元素。
 * <p>
 * 你的 KthLargest 类需要一个同时接收整数 k 和整数数组nums 的构造器，它包含数据流中的初始元素。每次调用 KthLargest.add，返回当前数据流中第K大的元素。
 * <p>
 * 示例:
 * <p>
 * int k = 3;
 * int[] arr = [4,5,8,2];
 * KthLargest kthLargest = new KthLargest(3, arr);
 * kthLargest.add(3);   // returns 4
 * kthLargest.add(5);   // returns 5
 * kthLargest.add(10);  // returns 5
 * kthLargest.add(9);   // returns 8
 * kthLargest.add(4);   // returns 8
 * 说明:
 * 你可以假设 nums 的长度≥ k-1 且k ≥ 1。
 * https://leetcode-cn.com/explore/learn/card/introduction-to-data-structure-binary-search-tree/66/conclusion/183/
 */
public class KthLargest {

	private MyTreeNode root;
	private int k;

	public KthLargest(int k, int[] nums) {
		this.k = k;
		if (nums == null || nums.length == 0) {
			this.root = null;
		} else {
			this.root = new MyTreeNode(nums[0]);
			for (int i = 1; i < nums.length; i++) {
				buildTree(nums[i], root);
			}
		}
	}

	public int add(int val) {
		if (root == null) {
			root = new MyTreeNode(val);
		} else {
			buildTree(val, root);
		}
		return getKthLargest(root, k);
	}

	private int getKthLargest(MyTreeNode node, int kth) {
		if (node == null) {
			return -1;
		}
		int leftCount = node.left == null ? 0 : node.left.count;
		int rightCount = node.right == null ? 0 : node.right.count;
		int currCount = node.count - leftCount - rightCount;

		if (kth > currCount + rightCount) {
			return getKthLargest(node.left, kth - currCount - rightCount);
		} else if (kth <= rightCount) {
			return getKthLargest(node.right, kth);
		} else {
			return node.val;
		}
	}


	private void buildTree(int val, MyTreeNode node) {
		if (val < node.val) {
			if (node.left == null) {
				node.left = new MyTreeNode(val);
			} else {
				buildTree(val, node.left);
			}
		} else if (val > node.val) {
			if (node.right == null) {
				node.right = new MyTreeNode(val);
			} else {
				buildTree(val, node.right);
			}
		}
		node.addCount();
	}

	public class MyTreeNode {
		int val;
		int count;
		MyTreeNode left;
		MyTreeNode right;

		public MyTreeNode(int val) {
			this.val = val;
			this.count = 1;
		}

		public MyTreeNode() {
		}

		public void addCount() {
			this.count++;
		}
	}

	public static void main(String[] args) {
		KthLargest kthLargest = new KthLargest(3, new int[]{5, -1});
		System.out.println(kthLargest.add(2));
		System.out.println(kthLargest.add(1));
		System.out.println(kthLargest.add(-1));
		System.out.println(kthLargest.add(3));
		System.out.println(kthLargest.add(4));
	}
}
