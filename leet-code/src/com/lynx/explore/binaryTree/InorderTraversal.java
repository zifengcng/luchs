package com.lynx.explore.binaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author wbc
 * @date 2020/7/22 15:17
 * 中序遍历二叉树
 * 给定一个二叉树，返回它的中序 遍历。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * 输出: [1,3,2]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * https://leetcode-cn.com/explore/learn/card/data-structure-binary-tree/2/traverse-a-tree/2/
 */
public class InorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        Set<TreeNode> visited = new HashSet<>();
        stack.push(root);
        visited.add(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            if (node.left != null && !visited.contains(node.left)) {
                stack.push(node.left);
                visited.add(node.left);
            } else {
                res.add(stack.pop().val);
                if (node.right != null && !visited.contains(node.right)) {
                    stack.push(node.right);
                    visited.add(node.right);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
