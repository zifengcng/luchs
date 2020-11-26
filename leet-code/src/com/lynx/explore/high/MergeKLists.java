package com.lynx.explore.high;

/**
 * @Author cheng
 * @Date 2020/8/27
 * 合并K个排序链表
 * 给你一个链表数组，每个链表都已经按升序排列。
 * <p>
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 * 示例 2：
 * <p>
 * 输入：lists = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：lists = [[]]
 * 输出：[]
 *  
 * <p>
 * 提示：
 * <p>
 * k == lists.length
 * 0 <= k <= 10^4
 * 0 <= lists[i].length <= 500
 * -10^4 <= lists[i][j] <= 10^4
 * lists[i] 按 升序 排列
 * lists[i].length 的总和不超过 10^4
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-hard/xwylvd/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class MergeKLists {

    public ListNode mergeKLists(ListNode[] lists) {
        int length = lists.length;
        if (length == 0) {
            return null;
        }
        ListNode res = null;

        for (int i = 0; i < length; i++) {
            ListNode node = lists[i];
            if (res == null) {
                res = node;
                continue;
            }
            ListNode root = res;
            while (node != null) {
                while (root.next != null && root.val <= node.val) {
                    root = root.next;
                }
                if (root.next == null) {
                    if (root.val <= node.val) {
                        root.next = node;
                        break;
                    } else {
                        ListNode t = new ListNode(root.val);
                        root.val = node.val;
                        root.next = t;
                    }
                } else {
                    ListNode t = new ListNode(root.val, root.next);
                    root.val = node.val;
                    root.next = t;
                }
                node = node.next;
            }
        }

        return res;
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

}


