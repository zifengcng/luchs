package com.lynx.random;

/**
 * @Author cheng
 * @Date 2020/10/15
 * <p>
 * 面试题 02.06. 回文链表
 * 编写一个函数，检查输入的链表是否是回文的。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： 1->2
 * 输出： false
 * 示例 2：
 * <p>
 * 输入： 1->2->2->1
 * 输出： true
 * <p>
 * <p>
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 * <p>
 * https://leetcode-cn.com/problems/palindrome-linked-list-lcci/
 */
public class IsPalindrome {

    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }

        ListNode mid = getMidNode(head);
        ListNode secondHalfNode = reverseNode(mid.next);

        ListNode n1 = head;
        ListNode n2 = secondHalfNode;

        boolean res = true;
        while (res && n2 != null) {
            if (n1.val != n2.val) {
                res = false;
            }
            n1 = n1.next;
            n2 = n2.next;
        }
        return res;
    }

    private ListNode reverseNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = reverseNode(head.next);
        // 神奇如斯
        head.next.next = head;
        head.next = null;
        return cur;
    }

    private ListNode reverseNode2(ListNode head) {
        // 当前节点的next指向前一个节点 666
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            ListNode next = cur.next;

            // 指向前一个节点
            cur.next = pre;
            pre = cur;

            // 当前指针后移，开始下一次循环
            cur = next;
        }
        return pre;
    }

    private ListNode getMidNode(ListNode head) {
        ListNode fast = head;
        ListNode low = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            low = low.next;
        }

        return low;
    }

    public static void main(String[] args) {
        IsPalindrome is = new IsPalindrome();
        ListNode head = is.getListNode(new int[]{1, 2, 3, 4});
//        boolean b = is.isPalindrome(head);
//        System.out.println(b);
        ListNode listNode = is.reverseNode2(head);
        System.out.println(listNode);
    }

    public ListNode getListNode(int[] arr) {
        ListNode node = new ListNode(arr[0]);
        int len = arr.length;
        ListNode listNode = node;
        for (int i = 1; i < len; i++) {
            listNode.next = new ListNode(arr[i]);
            listNode = listNode.next;
        }

        return node;
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
