package com.lynx.everyday;

import com.lynx.common.annotition.MidCode;

/**
 * @Author cheng
 * @Date 2020/10/20
 * <p>
 * 143. 重排链表
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * 示例 1:
 * <p>
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 * 示例 2:
 * <p>
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 * <p>
 * https://leetcode-cn.com/problems/reorder-list/
 */
@MidCode
public class ReorderList {

    // 递归，由于多次遍历找最后一个节点，效率低
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }

        ListNode next = head;
        while (next.next.next != null) {
            next = next.next;
        }

        ListNode second = head.next;

        head.next = next.next;
        head.next.next = second;

        next.next = null;

        reorderList(head.next.next);
    }

    // 查找链表中点 + 右半部分反转 + 合并两个链表
    public void reorderList2(ListNode head) {
        if (head == null) {
            return;
        }

        ListNode mid = getMidNode(head);
        ListNode left = head;
        ListNode right = mid.next;
        mid.next = null;

        right = reverseNode(right);

        merge(left, right);
    }

    private void merge(ListNode left, ListNode right) {
        while (right != null) {
            ListNode leftNext = left.next;
            ListNode rightNext = right.next;

            right.next = leftNext;
            left.next = right;

            left = leftNext;
            right = rightNext;
        }
    }

    private ListNode reverseNode(ListNode head) {
//        return reverseNode1(head);
        return reverseNode2(head);
    }

    // 反转链表：递归方法
    private ListNode reverseNode2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode cur = reverseNode2(head.next);
        head.next.next = head;
        head.next = null;
        return cur;
    }

    // 反转链表：迭代方法
    private ListNode reverseNode1(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;

            cur.next = prev;
            prev = cur;

            cur = next;
        }

        return prev;
    }

    private ListNode getMidNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}


