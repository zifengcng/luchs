package com.luchs.java.tree;

public class DistTree {

    public int dist(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int res = getMax(root.left) + getMax(root.right) + 1;
        res = Math.max(res, dist(root.left));
        res = Math.max(res, dist(root.right));

        return res;
    }

    private int getMax(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int res = 1;
        res += getMax(root.left);
        res += getMax(root.right);
        return res;
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}