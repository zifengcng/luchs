package com.lynx.explore.list;

/**
 * @author wbc
 * @date 2020/7/17 17:08
 * 扁平化多级双向链表
 * 多级双向链表中，除了指向下一个节点和前一个节点指针之外，它还有一个子链表指针，可能指向单独的双向链表。这些子列表也可能会有一个或多个自己的子项，依此类推，生成多级数据结构，如下面的示例所示。
 * <p>
 * 给你位于列表第一级的头节点，请你扁平化列表，使所有结点出现在单级双链表中。
 * https://leetcode-cn.com/explore/learn/card/linked-list/197/conclusion/764/
 */
public class Flatten {

	public Node flatten(Node head) {
		if (head == null) {
			return null;
		}
		Node pseudoHead = new Node(0, null, head, null);
		flatten_dfs(pseudoHead,head);
		pseudoHead.next.prev = null;
		return pseudoHead.next;
	}

	private Node flatten_dfs(Node pseudoHead,Node curr) {
		if (curr == null) {
			return pseudoHead;
		}
		curr.prev = pseudoHead;
		pseudoHead.next = curr;

		Node tempNext = curr.next;

		Node tail = flatten_dfs(curr, curr.child);
		curr.child = null;

		return flatten_dfs(tail, tempNext);
	}

	class Node {
		public int val;
		public Node prev;
		public Node next;
		public Node child;

		public Node() {}

		public Node(int _val,Node _prev,Node _next,Node _child) {
			val = _val;
			prev = _prev;
			next = _next;
			child = _child;
		}
	}
}
