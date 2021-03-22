package com.lynx.explore.list;

/**
 * @author wbc
 * @date 2020/7/17 11:54
 * 移除链表元素
 * 删除链表中等于给定值 val 的所有节点。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 * https://leetcode-cn.com/explore/learn/card/linked-list/195/classic-problems/752/
 */
public class RemoveElements {

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode res = head;
        ListNode t = head;
        while (t != null) {
            while (t.next != null && t.next.val == val) {
                t.next = t.next.next;
            }
            t = t.next;
        }
        if (res.val == val) {
            res = res.next;
        }
        return res;
    }

    public static void main(String[] args) {
        RemoveElements removeElements = new RemoveElements();
        ListNode head = new ListNode(1);
        ListNode next = new ListNode(1);
        next.next = new ListNode(1);
        head.next = next;
        ListNode listNode = removeElements.removeElements(head, 1);
        System.out.println(listNode);
    }
}
