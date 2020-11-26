package com.lynx.explore.list;

/**
 * @author wbc
 * @date 2020/7/17 10:30
 * 删除链表的倒数第N个节点
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * <p>
 * 示例：
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * <p>
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 * <p>
 * 给定的 n 保证是有效的。
 * <p>
 * 进阶：
 * <p>
 * 你能尝试使用一趟扫描实现吗？
 * https://leetcode-cn.com/explore/learn/card/linked-list/194/two-pointer-technique/747/
 */
public class RemoveNthFromEnd {

	public ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null || n < 1) {
			return head;
		}
		ListNode t = head;
		int length = 0;
		ListNode nNode = null;
		while (t.next != null) {
			t = t.next;
			length++;
			if (length == n) {
				nNode = head;
			} else if (length < n) {
				continue;
			} else {
				nNode = nNode.next;
			}
		}

		if (nNode == null) {
			if (head.next!=null) {
				head = head.next;
				return head;
			}
			return null;
		}

		ListNode next = nNode.next;
		if (next == null) {
			return head;
		}

		nNode.next = next.next;
		return head;
	}

	public static void main(String[] args) {
		RemoveNthFromEnd removeNthFromEnd = new RemoveNthFromEnd();
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		ListNode listNode = removeNthFromEnd.removeNthFromEnd(head, 1);
		System.out.println(listNode);
	}
}
