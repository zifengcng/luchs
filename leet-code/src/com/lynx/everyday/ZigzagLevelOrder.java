package com.lynx.everyday;

import com.lynx.common.annotition.MidCode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Author cheng
 * @Date 2020/12/22
 * 103. 二叉树的锯齿形层序遍历
 * 给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * <p>
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回锯齿形层序遍历如下：
 * <p>
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 * https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/
 */
@MidCode
public class ZigzagLevelOrder {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        boolean left = true;

        while (!stack.isEmpty()) {
            int size = stack.size();
            Deque<TreeNode> temp = new ArrayDeque<>();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode pop = stack.pop();
                list.add(pop.val);
                if (left) {
                    if (pop.left != null) {
                        temp.push(pop.left);
                    }
                    if (pop.right != null) {
                        temp.push(pop.right);
                    }
                } else {
                    if (pop.right != null) {
                        temp.push(pop.right);
                    }
                    if (pop.left != null) {
                        temp.push(pop.left);
                    }
                }
            }
            res.add(list);
            left = !left;
            stack = temp;
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
