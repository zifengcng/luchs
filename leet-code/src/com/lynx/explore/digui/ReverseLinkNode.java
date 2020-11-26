package com.lynx.explore.digui;

/**
 * @author wbc
 * @date 2020/6/24 17:02
 * <p>
 * 反转一个单链表。
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 * https://leetcode-cn.com/explore/orignial/card/recursion-i/257/recurrence-relation/1210/
 */
public class ReverseLinkNode {

	public static void main(String[] args) {
		ReverseLinkNode reverseLinkNode = new ReverseLinkNode();
		reverseLinkNode.test();

	}

	private void test() {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		System.out.println(reverseList(head));
	}

	public ListNode reverseList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		return reverse(head, head, head.next);
	}

	private ListNode reverse(ListNode head, ListNode pre, ListNode next) {

		pre.next = next.next;
		next.next = head;

		if (pre.next == null) {
			return next;
		}
		return reverse(next, pre, pre.next);
	}


	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
}
