package com.lynx.explore.mid;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author cheng
 * @Date 2020/8/11
 */
public class KthSmallest {

    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (true) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (--k == 0) {
                return root.val;
            }
            root = root.right;
        }
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        KthSmallest kthSmallest = new KthSmallest();
        TreeNode root = kthSmallest.new TreeNode(1);
        root.left = null;
        root.right = kthSmallest.new TreeNode(2);
        int i = kthSmallest.kthSmallest(root, 2);
        System.out.println(i);
    }

}
