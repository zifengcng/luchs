package com.lynx.explore.list;

/**
 * @author wbc
 * @date 2020/7/17 15:22
 * 回文链表
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
 * https://leetcode-cn.com/explore/learn/card/linked-list/195/classic-problems/754/
 */
public class IsPalindrome {

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode midNode = getMidNode(head);
        ListNode reverseNode = getReverseNode(midNode.next);

        while (reverseNode != null) {
            if (head.val != reverseNode.val) {
                return false;
            }
            head = head.next;
            reverseNode = reverseNode.next;
        }
        return true;
    }

    private ListNode getReverseNode(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode pre = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }

        return pre;
    }

    private ListNode getMidNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        IsPalindrome isPalindrome = new IsPalindrome();
        ListNode head = new ListNode(1);
        ListNode head2 = new ListNode(2);
        head2.next = new ListNode(1);
        head.next = head2;
        boolean palindrome = isPalindrome.isPalindrome(head);
        System.out.println(palindrome);
    }
}
