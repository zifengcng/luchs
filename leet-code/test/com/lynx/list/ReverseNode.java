package com.lynx.list;

/**
 * @Author cheng
 * @Date 2021/1/28
 * https://mp.weixin.qq.com/s/YVQvbhO0HJtnrocVg8-qmQ
 */
public class ReverseNode {

    //01
    //LeetCode #206 反转链表
    //
    //题目描述：
    //反转一个单链表。
    //示例:
    //输入: 1->2->3->4->5->NULL
    //输出: 5->4->3->2->1->NULL
    public ListNode reverseListNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = reverseListNode(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    //02
    //LeetCode #92 反转链表||
    //
    //题目描述：
    //反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
    //说明:
    //1 ≤ m ≤ n ≤ 链表长度。
    //示例:
    //输入: 1->2->3->4->5->NULL, m = 2, n = 4
    //输出: 1->4->3->2->5->NULL
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == 1) {
            return reverseTopN(head, n);
        }
        ListNode newHead = reverseBetween(head.next, m - 1, n - 1);
        head.next = newHead;
        return head;
    }

    ListNode topNSuccessor = null;

    private ListNode reverseTopN(ListNode head, int n) {
        if (n == 1) {
            topNSuccessor = head.next;
            return head;
        }

        ListNode newHead = reverseTopN(head.next, n - 1);
        head.next.next = head;
        head.next = topNSuccessor;
        return newHead;
    }


    class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode() {
        }
    }
}
