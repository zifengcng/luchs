package com.lynx.explore.binaryTree;

/**
 * @author wbc
 * @date 2020/7/23 10:00
 * 二叉树的最近公共祖先
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * <p>
 * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出: 3
 * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 * 示例 2:
 * <p>
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出: 5
 * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
 * <p>
 * <p>
 * 说明:
 * <p>
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉树中。
 * https://leetcode-cn.com/explore/learn/card/data-structure-binary-tree/4/conclusion/19/
 */
public class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == root || q == root) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        } else {
            return left == null ? right : left;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-1);
        TreeNode node1 = new TreeNode(0);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(-2);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(8);
        node3.left = node5;
        node1.left = node3;
        node1.right = node4;
        root.left = node1;
        root.right = node2;

        LowestCommonAncestor lowestCommonAncestor = new LowestCommonAncestor();
        TreeNode treeNode = lowestCommonAncestor.lowestCommonAncestor(root, node5, node4);
        System.out.println(treeNode.val);

    }
}
