package com.lynx.explore.list;

/**
 * @author wbc
 * @date 2020/7/17 18:56
 * 旋转链表
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 * 示例 2:
 *
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 * https://leetcode-cn.com/explore/learn/card/linked-list/197/conclusion/767/
 */
public class RotateRight {

	public ListNode rotateRight(ListNode head, int k) {
		// base cases
		if (head == null) {
			return null;
		}
		if (head.next == null) {
			return head;
		}

		// close the linked list into the ring
		ListNode oldTail = head;
		int n;
		for(n = 1; oldTail.next != null; n++) {
			oldTail = oldTail.next;
		}
		oldTail.next = head;

		// find new tail : (n - k % n - 1)th node
		// and new head : (n - k % n)th node
		ListNode newTail = head;
		for (int i = 0; i < n - k % n - 1; i++) {
			newTail = newTail.next;
		}
		ListNode newHead = newTail.next;

		// break the ring
		newTail.next = null;

		return newHead;
	}


}
