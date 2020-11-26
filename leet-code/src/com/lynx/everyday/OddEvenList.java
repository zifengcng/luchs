package com.lynx.everyday;

import com.lynx.common.annotition.MidCode;

/**
 * @Author cheng
 * @Date 2020/11/13
 * 328. 奇偶链表
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 * <p>
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 1->3->5->2->4->NULL
 * 示例 2:
 * <p>
 * 输入: 2->1->3->5->6->4->7->NULL
 * 输出: 2->3->6->7->1->5->4->NULL
 * 说明:
 * <p>
 * 应当保持奇数节点和偶数节点的相对顺序。
 * 链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。
 * https://leetcode-cn.com/problems/odd-even-linked-list/
 */
@MidCode
public class OddEvenList {

    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode odd = head;
        ListNode even = head.next;

        ListNode evenT = even;
        while (evenT != null && evenT.next != null) {
            odd.next = evenT.next;
            odd = odd.next;
            evenT.next = odd.next;
            evenT = evenT.next;
        }

        odd.next = even;
        return head;
    }

    public class ListNode {
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

    public static void main(String[] args) {
        OddEvenList o = new OddEvenList();
        // 输入: 1->2->3->4->5->NULL
        // 输出: 1->3->5->2->4->NULL
        ListNode head = buildNode(o, new int[]{1, 2, 3, 4, 5});
        ListNode node = o.oddEvenList(head);
        printNode(node);

        //  输入: 2->1->3->5->6->4->7->NULL
        //  输出: 2->3->6->7->1->5->4->NULL
        head = buildNode(o, new int[]{2, 1, 3, 5, 6, 4, 7});
        node = o.oddEvenList(head);
        printNode(node);


    }

    private static void printNode(ListNode node) {
        while (node != null) {
            System.out.print(node.val);
            node = node.next;
        }
        System.out.println();
    }

    private static ListNode buildNode(OddEvenList o, int[] nums) {
        ListNode head = o.new ListNode(-1);
        ListNode t = head;
        for (int num : nums) {
            t.next = o.new ListNode(num);
            t = t.next;
        }
        return head.next;
    }
}
