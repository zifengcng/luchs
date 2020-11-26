package com.lynx.explore.high;

/**
 * @Author cheng
 * @Date 2020/8/31
 * 二叉树中的最大路径和
 * 给定一个非空二叉树，返回其最大路径和。
 * <p>
 * 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3]
 * <p>
 * 1
 * / \
 * 2   3
 * <p>
 * 输出: 6
 * 示例 2:
 * <p>
 * 输入: [-10,9,20,null,null,15,7]
 * <p>
 *    -10
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * <p>
 * 输出: 42
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-hard/xdhfe5/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class MaxPathSum {

    private int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        getMaxPathSum(root);
        return max;
    }

    private int getMaxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(getMaxPathSum(root.left), 0);
        int right = Math.max(getMaxPathSum(root.right), 0);
        int res = root.val + left + right;
        max = Math.max(max, res);
        return root.val + Math.max(left, right);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        MaxPathSum m = new MaxPathSum();

        TreeNode root = new TreeNode(-1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(-1);
        int i = m.maxPathSum(root);
        System.out.println(i);
    }
}
