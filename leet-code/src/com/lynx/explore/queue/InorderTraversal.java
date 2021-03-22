package com.lynx.explore.queue;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

/**
 * @author wbc
 * @date 2020/7/9 19:02
 * 二叉树的中序遍历
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
 * https://leetcode-cn.com/explore/learn/card/queue-stack/219/stack-and-dfs/887/
 */
public class InorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        HashSet<TreeNode> visited = new HashSet<>();

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

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
        InorderTraversal traversal = new InorderTraversal();
        TreeNode root = new TreeNode(1);
        TreeNode right = new TreeNode(2);
        right.left = new TreeNode(3);
        root.right = right;
        List<Integer> list = traversal.inorderTraversal(root);
        System.out.println(list);
    }


}

/**
 * Definition for a binary tree node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
