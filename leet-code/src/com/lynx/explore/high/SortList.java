package com.lynx.explore.high;

/**
 * @Author cheng
 * @Date 2020/8/27
 * 排序链表
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2:
 * <p>
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-hard/xwcdnh/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class SortList {

    public ListNode sortList(ListNode head) {
        int len = 0;
        ListNode t = head;
        while (t != null) {
            len++;
            t = t.next;
        }

        ListNode res = new ListNode(0);
        res.next = head;

        int intv = 1;
        ListNode pre;
        while (intv < len) {
            pre = res;
            t = res.next;

            while (t != null) {

                int c = intv;
                ListNode left = t;
                while (t != null && c > 0) {
                    t = t.next;
                    c--;
                }
                if (t == null) {
                    break;
                }

                c = intv;
                ListNode right = t;
                while (t != null && c > 0) {
                    t = t.next;
                    c--;
                }

                int c1 = intv;
                int c2 = intv - c;
                while (c1 > 0 && c2 > 0) {
                    if (left.val < right.val) {
                        pre.next = left;
                        left = left.next;
                        c1--;
                    } else {
                        pre.next = right;
                        right = right.next;
                        c2--;
                    }
                    pre = pre.next;
                }
                pre.next = c1 == 0 ? right : left;
                while (c1 > 0 || c2 > 0) {
                    pre = pre.next;
                    c1--;
                    c2--;
                }
                pre.next = t;
            }
            intv *= 2;
        }

        return res.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
