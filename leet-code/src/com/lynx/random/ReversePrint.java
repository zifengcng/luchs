package com.lynx.random;

import com.lynx.common.annotition.EasyCode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author cheng
 * @Date 2020/10/30
 * <p>
 * 剑指 Offer 06. 从尾到头打印链表
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 *  
 * <p>
 * 限制：
 * <p>
 * 0 <= 链表长度 <= 10000
 * <p>
 * 作者：Krahets
 * 链接：https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/5dt66m/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
@EasyCode
public class ReversePrint {


    public int[] reversePrint(ListNode head) {
        int len = 0;

        Deque<ListNode> stack = new ArrayDeque<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
            len++;
        }

        int[] res = new int[len];
        int i = 0;
        while (!stack.isEmpty()) {
            res[i++] = stack.pop().val;
        }
        return res;
    }

    public class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
