package com.lynx.everyday;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

/**
 * @Author cheng
 * @Date 2020/9/27
 * <p>
 * 113. 路径总和 II
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 * <p>
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \    / \
 * 7    2  5   1
 * 返回:
 * <p>
 * [
 * [5,4,11,2],
 * [5,8,4,5]
 * ]
 * <p>
 * https://leetcode-cn.com/problems/path-sum-ii/
 */
public class PathSum {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        Deque<Integer> stack = new ArrayDeque<>();
        return dfs(root, sum, stack);
    }

    private List<List<Integer>> dfs(TreeNode root, int sum, Deque<Integer> stack) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        int s = sum - root.val;
        stack.push(root.val);

        if (root.left == null && root.right == null) {
            if (!stack.isEmpty() && s == 0) {
                List<Integer> list = new ArrayList<>(stack);
                Collections.reverse(list);
                res.add(list);
            }
        }

        res.addAll(dfs(root.left, s, stack));
        res.addAll(dfs(root.right, s, stack));

        stack.pop();
        return res;
    }

    public static void main(String[] args) {
        PathSum p = new PathSum();
        TreeNode root = p.new TreeNode(5);
        TreeNode n1 = p.new TreeNode(4);
        TreeNode n2 = p.new TreeNode(8);
        TreeNode n3 = p.new TreeNode(11);
        TreeNode n4 = p.new TreeNode(13);
        TreeNode n5 = p.new TreeNode(4);
        TreeNode n6 = p.new TreeNode(7);
        TreeNode n7 = p.new TreeNode(2);
        TreeNode n8 = p.new TreeNode(5);
        TreeNode n9 = p.new TreeNode(1);

        n3.left = n6;
        n3.right = n7;
        n5.left = n8;
        n5.right = n9;

        n1.left = n3;
        n2.left = n4;
        n2.right = n5;

        root.left = n1;
        root.right = n2;

        List<List<Integer>> lists = p.pathSum(root, 22);
        System.out.println(lists);

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
