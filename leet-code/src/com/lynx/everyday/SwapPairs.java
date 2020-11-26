package com.lynx.everyday;

/**
 * @Author cheng
 * @Date 2020/10/13
 * <p>
 * 24. 两两交换链表中的节点
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 * <p>
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 */
public class SwapPairs {

    public ListNode swapPairs(ListNode head) {
        // head, head.next
        if (head == null || head.next == null) {
            return head;
        }
        ListNode t = head.next;
        head.next = t.next;
        t.next = head;
        head.next = swapPairs(head.next);
        return t;
    }

    public static void main(String[] args) {
        SwapPairs sp = new SwapPairs();
        ListNode n4 = new ListNode(4);
        ListNode n3 = new ListNode(3, n4);
        ListNode n2 = new ListNode(2, n3);
        ListNode head = new ListNode(1, n2);

        ListNode listNode = sp.swapPairs(head);
        System.out.println(listNode);
    }
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
