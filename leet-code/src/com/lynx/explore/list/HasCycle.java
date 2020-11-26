package com.lynx.explore.list;

/**
 * @author wbc
 * @date 2020/7/16 19:20
 * 环形链表
 * 给定一个链表，判断链表中是否有环。
 * <p>
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：head = [1,2], pos = 0
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * 输入：head = [1], pos = -1
 * 输出：false
 * 解释：链表中没有环。
 * <p>
 * <p>
 * <p>
 * <p>
 * 进阶：
 * <p>
 * 你能用 O(1)（即，常量）内存解决此问题吗？
 * https://leetcode-cn.com/explore/learn/card/linked-list/194/two-pointer-technique/744/
 */
public class HasCycle {


	public boolean hasCycle(ListNode head) {
		if (head == null || head.next == null) {
			return false;
		}
		ListNode i = head;
		ListNode j = head;
		while (true) {
			if (i.next != null) {
				i = i.next;
			} else {
				return false;
			}
			if (j.next != null && j.next.next != null) {
				j = j.next.next;
			} else {
				return false;
			}
			if (j == i) {
				return true;
			}
		}
	}


	public static void main(String[] args) {
//		HasCycle hasCycle = new HasCycle();
//		ListNode head = new ListNode(3);
//		ListNode next = new ListNode(2);
//		head.next = next;
//		ListNode next1 = new ListNode(0);
//		next.next = next1;
//		next1.next = new ListNode(-4);
//		hasCycle.hasCycle(head);
		Long l = null;
		System.out.println(String.valueOf(l));
	}

}


class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}
