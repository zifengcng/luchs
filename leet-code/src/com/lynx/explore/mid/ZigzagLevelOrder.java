package com.lynx.explore.mid;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Author cheng
 * @Date 2020/8/11
 * 二叉树的锯齿形层次遍历
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * <p>
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回锯齿形层次遍历如下：
 * <p>
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xvle7s/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class ZigzagLevelOrder {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        int c = 1;
        while (!stack.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            Deque<TreeNode> temp = new ArrayDeque<>();
            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                if (c % 2 == 0) {
                    if (node.right != null) {
                        temp.push(node.right);
                    }
                    if (node.left != null) {
                        temp.push(node.left);
                    }
                } else {
                    if (node.left != null) {
                        temp.push(node.left);
                    }
                    if (node.right != null) {
                        temp.push(node.right);
                    }
                }
                list.add(node.val);
            }
            res.add(list);
            stack.addAll(temp);
            c++;
        }

        return res;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
