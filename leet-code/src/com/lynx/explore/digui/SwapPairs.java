package com.lynx.explore.digui;

/**
 * @author wbc
 * @date 2020/6/24 10:40
 * <p>
 * 两两交换链表中的节点
 * <p>
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 示例：
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 * <p>
 * https://leetcode-cn.com/explore/orignial/card/recursion-i/256/principle-of-recursion/1201/
 */
public class SwapPairs {

    public static void main(String[] args) {
        SwapPairs swapPairs = new SwapPairs();
        swapPairs.test();

    }

    private void test() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        System.out.println(swapPairs(head));
    }

    public ListNode swapPairs(ListNode head) {
        if (head != null && head.next != null) {
            return swapPairs2(head, head.next);
        }
        return head;
    }

    private ListNode swapPairs2(ListNode head, ListNode next) {
        if (head != null && next != null) {
            ListNode temp = next;

            head.next = next.next;
            next.next = head;

            next = head;
            head = temp;

            if (next.next != null && next.next.next != null) {
                next.next = swapPairs2(next.next, next.next.next);
            }
        }
        return head;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
