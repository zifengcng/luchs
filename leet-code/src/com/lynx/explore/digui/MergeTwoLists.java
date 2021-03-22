package com.lynx.explore.digui;

/**
 * @author wbc
 * @date 2020/6/28 9:47
 * <p>
 * 合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * 示例：
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * <p>
 * https://leetcode-cn.com/explore/featured/card/recursion-i/260/conclusion/1229/
 */
public class MergeTwoLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode node;
        if (l1.val < l2.val) {
            node = l1;
            node.next = mergeTwoLists(l1.next, l2);
        } else {
            node = l2;
            node.next = mergeTwoLists(l1, l2.next);
        }
        return node;
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode pre = new ListNode(-1);
        ListNode end = pre;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                end.next = l1;
                l1 = l1.next;
            } else {
                end.next = l2;
                l2 = l2.next;
            }
            end = end.next;
        }
        if (l1 == null) {
            end.next = l2;
        } else {
            end.next = l1;
        }

        return pre.next;
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
