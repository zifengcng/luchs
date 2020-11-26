package com.lynx.everyday;

import com.lynx.common.annotition.EasyCode;

/**
 * @Author cheng
 * @Date 2020/10/23
 * <p>
 * 234. 回文链表
 * 请判断一个链表是否为回文链表。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 * <p>
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 * <p>
 * https://leetcode-cn.com/problems/palindrome-linked-list/
 */
@EasyCode
public class Palindrome {

    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }

        ListNode mid = getMid(head);
        ListNode right = reverseNode(mid.next);
        while (right != null) {
            if (head.val != right.val) {
                return false;
            }
            head = head.next;
            right = right.next;
        }

        return true;
    }

    private ListNode reverseNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = reverseNode(head.next);
        head.next.next = head;
        head.next = null;

        return cur;
    }

    private ListNode getMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }


    private ListNode reverseNode2(ListNode head) {
        ListNode cur = head;
        ListNode prev = null;

        while (cur != null) {
            ListNode next = cur.next;

            cur.next = prev;
            prev = cur;

            cur = next;
        }

        return prev;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}


